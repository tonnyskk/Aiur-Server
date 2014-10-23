package com.origin.aiur.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.pojo.VoResponse;
import com.origin.aiur.service.GroupService;
import com.origin.aiur.util.AiurLog;

@Path("/group")
public class GroupRest {

	@GET
	@Path("/activity/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public VoResponse group(@PathParam("userId") long userId) {
		AiurLog.logger().info("Receieving quest for group with userID : " + userId);
		return GroupService.queryGroupActivity(userId);
	}
}
