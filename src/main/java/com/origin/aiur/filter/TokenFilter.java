package com.origin.aiur.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.AiurUtils;
import com.origin.aiur.util.TokenUtil;

public class TokenFilter implements Filter {
    private static final int ERROR_TOKEN_INVALID = 4096;
    private static final String ENCODING = "UTF-8";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

        String token = request.getHeader("token");
        String deviceId = request.getHeader("device-id");
        String uId = request.getHeader("uid");

        String reqpath = request.getPathInfo();

        AiurLog.logger().debug("");
        AiurLog.logger().debug("req-path=" + reqpath);

        response.setCharacterEncoding(ENCODING);

        if (AiurUtils.isEmpty(deviceId)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "bad request!");
            return;
        }

        if (reqpath.equals("/user/startup")) {
            arg2.doFilter(arg0, arg1);
        } else {
            if (AiurUtils.isEmpty(token)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "bad request!");
                return;
            }

            Map<String, String> paramMap = TokenUtil.decodeToken(token);
            // No valid token found, bad request
            if (paramMap.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid token!");
                return;
            }

            // If token is expire, need re-login
            String expireTime = paramMap.get(TokenUtil.TOKEN_EXPIRE_KEY);
            if (!AiurUtils.isEmpty(expireTime) && TokenUtil.isExpired(expireTime)) {
                response.sendError(ERROR_TOKEN_INVALID, "session expire, re-login");
                return;
            }

            // If user device changed, we need re-login
            String deviceInfo = paramMap.get(TokenUtil.TOKEN_DEVICE_ID);
            if (AiurUtils.isEmpty(deviceInfo) || !deviceId.equals(deviceInfo)) {
                response.sendError(ERROR_TOKEN_INVALID, "invalid device, need re-login");
                return;
            }
            // If user id consist
            String userId = paramMap.get(TokenUtil.TOKEN_USER_ID);
            if (AiurUtils.isEmpty(userId) || !uId.equals(userId)) {
                response.sendError(ERROR_TOKEN_INVALID, "invalid user, need re-login");
                return;
            }
            arg2.doFilter(arg0, arg1);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
