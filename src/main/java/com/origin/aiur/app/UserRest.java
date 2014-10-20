package com.origin.aiur.app;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.pojo.VoReponse;
import com.origin.aiur.service.UserService;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.TokenService;

@Path("/user")
public class UserRest {

    @GET
    @Path("status/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoReponse tokenValidate(@PathParam("token") String token) {
        AiurLog.logger().info("Receieving quest for validate token: " + token);
        VoReponse response = new VoReponse();
        response.setStatusCode(TokenService.validToken(token));
        return response;
    }
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public VoReponse login(@FormParam("loginName") String loginName, @FormParam("password") String password) {
        AiurLog.logger().info("Receieving quest for login: " + loginName);
        return UserService.login(loginName, password);
    }
}
