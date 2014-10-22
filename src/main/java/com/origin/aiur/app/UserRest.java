package com.origin.aiur.app;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.pojo.VoReponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.service.UserService;
import com.origin.aiur.util.AiurLoader;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.RespStatus;

@Path("/user")
public class UserRest {

	/**
	 * When init startup app, sync resources to client. Like, RSA public key
	 * URL: /aiur/rest/user/startup
	 * Header: 
	 * 		device-id=a0000001
	 * 
	 * @return voResponse
	 */
	@GET
	@Path("startup")
	@Produces(MediaType.APPLICATION_JSON)
	public VoReponse startup() {
		VoReponse response = new VoReponse();
		response.setStatusCode(RespStatus.OK);
		response.setKey(AiurLoader.getInstance().getPublicKey());
		return response;
	}

	/**
	 * When client startup, check token status.
	 * URL: /aiur/rest/user/status
	 * Header: 
	 * 		device-id=a0000001
	 * 		token=sdfadsfa
	 * 
	 * @return voResponse
	 */
	@GET
	@Path("status")
	@Produces(MediaType.APPLICATION_JSON)
	public VoReponse tokenValidate() {
		VoReponse response = new VoReponse();
		response.setStatusCode(RespStatus.OK);
		return response;
	}

	/**
	 * User login
	 * URL: /aiur/rest/user/login
	 * Header: 
	 * 		device-id=a0000001
	 * 		Content-Type=application/json
	 * Raw data:
	 * 		{"loginName":"djia","password":"admin", "deviceId":"a00000001"}
	 * @param voUser
	 * @return
	 */
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public VoReponse login(VoUser voUser) {
		AiurLog.logger().info("Receieving quest for login: " + voUser);
		return UserService.login(voUser);
	}

	/**
	 * Register user
	 * URL: /aiur/rest/user/reg
	 * Header: 
	 * 		device-id=a0000001
	 * 		Content-Type=application/json
	 * Raw data:
	 * 		{"loginName":"djia","password":"admin", "nickName":"Tonny", "deviceId":"a00000001"}
	 * @param voUser
	 * @return
	 */
	@POST
	@Path("reg")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public VoReponse regist(VoUser voUser) {
		AiurLog.logger().info("Receieving quest for regist: " + voUser);
		return UserService.regist(voUser);
	}
}
