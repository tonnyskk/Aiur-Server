package com.origin.aiur.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.pojo.VoReponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.service.UserService;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.RespStatus;

@Path("/user")
public class UserRest {

    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public VoReponse tokenValidate(@Context HttpServletRequest req, @Context HttpServletResponse resp) {
        /**
         * http://localhost:8080/aiur/rest/user/status
         * Header:
         *    device-id=a0000001
         */
        VoReponse response = new VoReponse();
        response.setStatusCode(RespStatus.OK);
        return response;
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoReponse login(VoUser voUser) {
        AiurLog.logger().info("Receieving quest for login: " + voUser);
        /**
         * http://localhost:8080/aiur/rest/user/login
         * Header:
         *    device-id=a0000001
         *    Content-Type=application/json
         * Raw data:
         *     {"loginName":"djia", "password":"admin", "deviceId":"a00000001"}
         */
        return UserService.login(voUser);
    }
    
    @POST
    @Path("regist")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoReponse regist(VoUser voUser) {
        AiurLog.logger().info("Receieving quest for regist: " + voUser);
        /**
         * http://localhost:8080/aiur/rest/user/regist
         * Header:
         *    device-id=a0000001
         *    Content-Type=application/json
         * Raw data:
         *     {"loginName":"djia", "password":"admin", "nickName":"Tonny", "deviceId":"a00000001"}
         */
        return UserService.regist(voUser);
    }
}
