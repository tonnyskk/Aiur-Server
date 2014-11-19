package com.origin.aiur.app;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.origin.aiur.pojo.GroupCharge;
import com.origin.aiur.pojo.VoGroup;
import com.origin.aiur.pojo.VoResponse;
import com.origin.aiur.service.GroupService;
import com.origin.aiur.util.AiurLog;

@Path("/group")
public class GroupRest {

    @GET
    @Path("/activity/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse group(@PathParam("userId") long userId) {
        AiurLog.logger().info("Query user acitvity for user > " + userId);
        return GroupService.queryUserActivity(userId);
    }

    @GET
    @Path("/activity/{userId}/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse groupActivity(@PathParam("userId") long userId, @PathParam("groupId") long groupId) {
        AiurLog.logger().info("Query group activity for user>" + userId + " @ group = " + groupId);
        return GroupService.queryGroupActivity(groupId, userId);
    }
    
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoResponse create(VoGroup voGroup){
        AiurLog.logger().info("Create group > " + voGroup);
        return GroupService.createNewGroup(voGroup);
    }
    
    @GET
    @Path("/search/{userId}/{searchText}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse search(@PathParam("userId") long userId, @PathParam("searchText") String searchText) {
        AiurLog.logger().info("Search grop for user > " + userId + ", with text > " + searchText);
        return GroupService.searchGroup(userId, searchText);
    }
    
    @POST
    @Path("/join/{userId}/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse join(@PathParam("userId") long userId, @PathParam("groupId") long groupId) {
        AiurLog.logger().info("Join group request user > " + userId + " groupId > " + groupId);
        return GroupService.joinGroupRequest(userId, groupId);
    }

    @GET
    @Path("/finance/{userId}/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse finance(@PathParam("userId") long userId, @PathParam("groupId") long groupId) {
        AiurLog.logger().info("Query finance for user > " + userId + " @groupId > " + groupId);
        return GroupService.queryFinance(userId, groupId);
    }
    

    @GET
    @Path("/users/{groupId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VoResponse groupUsers(@PathParam("groupId") long groupId) {
        AiurLog.logger().info("Query user list in grop " + groupId);
        return GroupService.queryUserList(groupId);
    }

    @POST
    @Path("/charge")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public VoResponse charge(GroupCharge groupCharge) {
        AiurLog.logger().info("Group pay request> " + groupCharge);
        return GroupService.groupChargeReq(groupCharge);
    }
}
