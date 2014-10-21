package com.origin.aiur.service;

import com.origin.aiur.orm.DbService;
import com.origin.aiur.pojo.VoReponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.AiurUtils;
import com.origin.aiur.util.RespStatus;
import com.origin.aiur.util.TokenUtil;

public class UserService {

    public static VoReponse login(VoUser voUser) {
        VoReponse response = new VoReponse();
        response.setStatusCode(RespStatus.OK);

        if (voUser == null) {
            voUser = new VoUser();
        }

        if (AiurUtils.isEmpty(voUser.getLoginName())) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_USER);
            response.setStatusMessage("INVALID_PARAM_EMPTY_USER");
            return response;
        } else if (AiurUtils.isEmpty(voUser.getPassword())) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_PWD);
            response.setStatusMessage("INVALID_PARAM_EMPTY_PWD");
            return response;
        }

        try {
            VoUser user = DbService.checkUserAccount(voUser.getLoginName(), voUser.getPassword());
            if (user == null) {
                response.setStatusCode(RespStatus.USER_NOT_FOUND);
            }else {
                response.setData(user);
                response.setToken(TokenUtil.generateToken(user.getUserID(), user.getDeviceId()));
            }
        } catch (Exception e) {
            AiurLog.logger().error(e.getMessage(), e);

            response.setStatusCode(RespStatus.ERROR_EXCEPTION);
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }

    public static VoReponse regist(VoUser voUser) {
        VoReponse response = new VoReponse();
        response.setStatusCode(RespStatus.OK);

        if (voUser == null) {
            voUser = new VoUser();
        }

        if (AiurUtils.isEmpty(voUser.getLoginName())) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_USER);
            response.setStatusMessage("INVALID_PARAM_EMPTY_USER");
            return response;
        }
        if (AiurUtils.isEmpty(voUser.getPassword())) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_PWD);
            response.setStatusMessage("INVALID_PARAM_EMPTY_PWD");
            return response;
        }
        if (AiurUtils.isEmpty(voUser.getNickName())) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_NICK);
            response.setStatusMessage("INVALID_PARAM_EMPTY_NICK");
            return response;
        }

        try {
            if (DbService.isUserExists(voUser.getLoginName())) {
                response.setStatusCode(RespStatus.INVALID_USER_EXISTS);
                response.setStatusMessage("INVALID_USER_EXISTS");
            } else {
                long userId = DbService.regUserAccount(voUser.getLoginName(), voUser.getNickName(), voUser.getPassword());
                VoUser user = DbService.getUserAccount(userId);
                if (user == null) {
                    response.setStatusCode(RespStatus.INVALID_CREATE_USER_FAILED);
                } else {
                    response.setData(user);
                    response.setToken(TokenUtil.generateToken(user.getUserID(), user.getDeviceId()));
                }
            }
        } catch (Exception e) {
            AiurLog.logger().error(e.getMessage(), e);

            response.setStatusCode(RespStatus.ERROR_EXCEPTION);
            response.setStatusMessage(e.getMessage());
        }

        return response;

    }
}
