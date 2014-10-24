package com.origin.aiur.app;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.exception.IllegalValueException;
import com.origin.aiur.pojo.VoResponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.service.UserService;
import com.origin.aiur.util.AiurLoader;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.RespStatus;
import com.origin.aiur.util.TokenUtil;

@Path("/user")
public class UserRest {
    private static final String HEADER_DEVICE_ID = "device-id";
    private static final String HEADER_USER_ID = "uId";
    /**
     * When init startup app, sync resources to client. Like, RSA public key
     * URL: /aiur/rest/user/startup
     * Header: 
     *         device-id=a0000001
     * 
     * @return voResponse
     */
    @GET
    @Path("startup")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse startup(@Context HttpServletRequest request) {
        
        VoResponse response = new VoResponse();
        response.setStatusCode(RespStatus.OK);

        try {
            String deviceId = request.getHeader(HEADER_DEVICE_ID);
            long userId = Long.parseLong(request.getHeader(HEADER_USER_ID));
            response.setToken(TokenUtil.generateToken(userId, deviceId, 1));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
        response.setKey(AiurLoader.getInstance().getPublicKey());

        return response;
    }

    /**
     * When client startup, check token status.
     * URL: /aiur/rest/user/status
     * Header: 
     *         device-id=a0000001
     *         token=sdfadsfa
     * 
     * @return voResponse
     */
    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse tokenValidate() {
        VoResponse response = new VoResponse();
        response.setStatusCode(RespStatus.OK);
        return response;
    }

    /**
     * User login
     * URL: /aiur/rest/user/login
     * Header: 
     *         device-id=a0000001
     *         Content-Type=application/json
     * Raw data:
     *         {"loginName":"djia","password":"admin", "deviceId":"a00000001"}
     * @param voUser
     * @return
     */
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoResponse login(@Context HttpServletRequest request, VoUser voUser) {
        AiurLog.logger().info("Receieving quest for login: " + voUser);
        String deviceId = request.getHeader(HEADER_DEVICE_ID);
        if (voUser == null) {
            voUser = new VoUser();
        }
        voUser.setDeviceId(deviceId);
        return UserService.login(voUser);
    }

    /**
     * Register user
     * URL: /aiur/rest/user/reg
     * Header: 
     *         device-id=a0000001
     *         Content-Type=application/json
     * Raw data:
     *         {"loginName":"djia","password":"admin", "nickName":"Tonny", "deviceId":"a00000001"}
     * @param voUser
     * @return
     */
    @POST
    @Path("reg")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoResponse regist(@Context HttpServletRequest request, VoUser voUser) {
        AiurLog.logger().info("Receieving quest for regist > " + voUser);
        String deviceId = request.getHeader(HEADER_DEVICE_ID);
        if (voUser == null) {
            voUser = new VoUser();
        }
        voUser.setDeviceId(deviceId);
        return UserService.regist(voUser);
    }

    /**
     * List all groups for special user
     * 
     * @param userId
     * @return
     */
    @GET
    @Path("{userId}/group")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse group(@PathParam("userId") long userId) {
        AiurLog.logger().info("Query group for user > " + userId);
        return UserService.queryGroup(userId);
    }

    /**
     * Load user finance summary for special user
     * 
     * @param userId
     * @return
     */
    @GET
    @Path("{userId}/finance")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse finance(@PathParam("userId") long userId) {
        AiurLog.logger().info("Finance summary for user > " + userId);
        return UserService.queryFinance(userId);
    }
}
