package com.origin.aiur.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.origin.aiur.orm.DbService;
import com.origin.aiur.pojo.VoUser;

@Path("/user")
public class UserRest {
    private static Logger logger = Logger.getLogger(UserRest.class);
    private static int index = 1;
    private static Map<Integer, VoUser> VoUserList = new HashMap<Integer, VoUser>();

    public UserRest() {
        if (VoUserList.size() == 0) {
            VoUserList.put(index, new VoUser(index++, "Frank", "CS"));
            VoUserList.put(index, new VoUser(index++, "Jersey", "Math"));
        }
    }

    @GET
    @Path("{VoUserid}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public VoUser getMetadata(@PathParam("VoUserid") int VoUserid) {
        if (VoUserList.containsKey(VoUserid))
            return VoUserList.get(VoUserid);
        else
            return new VoUser(0, "Nil", "Nil");
    }

    @GET
    @Path("list")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<VoUser> getAllVoUsers() {
        List<VoUser> VoUsers = new ArrayList<VoUser>();
        VoUsers.addAll(VoUserList.values());
        return VoUsers;
    }

    @POST
    @Path("add")
    @Produces("text/plain")
    public String addVoUser(@FormParam("name") String name, @FormParam("dept") String dept) {
        VoUserList.put(index, new VoUser(index++, name, dept));
        return String.valueOf(index - 1);
    }

    @DELETE
    @Path("delete/{VoUserid}")
    @Produces("text/plain")
    public String removeVoUser(@PathParam("VoUserid") int VoUserid) {
        logger.info("Receieving quest for deleting VoUser: " + VoUserid);

        VoUser removed = VoUserList.remove(VoUserid);
        if (removed == null)
            return "failed!";
        else
            return "true";
    }

    @PUT
    @Path("put")
    @Produces("text/plain")
    public String putVoUser(@QueryParam("VoUserid") int VoUserid, @QueryParam("name") String name, @QueryParam("dept") String dept) {
        logger.info("Receieving quest for putting VoUser: " + VoUserid);
        if (!VoUserList.containsKey(VoUserid))
            return "failed!";
        else
            VoUserList.put(VoUserid, new VoUser(VoUserid, name, dept));

        return String.valueOf(VoUserid);
    }
}
