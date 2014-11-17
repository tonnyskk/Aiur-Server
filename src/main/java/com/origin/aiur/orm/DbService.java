package com.origin.aiur.orm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.origin.aiur.pojo.VoGroup;
import com.origin.aiur.pojo.VoGroupActivity;
import com.origin.aiur.pojo.VoUser;

public class DbService {

    public static VoUser checkUserAccount(String loginName, String pwd) throws Exception {
        VoUser userInfo = null;
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("login_name", loginName);
            param.put("pwd_val", pwd);
            userInfo = (VoUser) DbOrm.getORMClient().queryForObject("checkUserAccount", param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return userInfo;
    }

    public static boolean isUserExists(String loginName) throws Exception {
        boolean isExists = false;
        try {
            Integer userCount = (Integer) DbOrm.getORMClient().queryForObject("isUserExists", loginName);
            isExists = userCount.intValue() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return isExists;
    }

    public static long regUserAccount(String loginName, String nickName, String password) throws Exception {
        long userId = 0L;
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("login_name", loginName);
            param.put("pwd_val", password);
            param.put("nick_name", nickName);
            userId = (Long) DbOrm.getORMClient().insert("insertNewUser", param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return userId;
    }

    public static VoUser getUserAccount(long userId) throws Exception {
        VoUser userInfo = null;
        try {
            userInfo = (VoUser) DbOrm.getORMClient().queryForObject("queryUserAccount", userId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return userInfo;
    }

    @SuppressWarnings("unchecked")
    public static List<VoGroup> getUserGroupList(long userID) throws Exception {
        List<VoGroup> groupList = null;
        try {
            groupList = (List<VoGroup>) DbOrm.getORMClient().queryForList("queryUserGroupList", userID);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return groupList;
    }

    @SuppressWarnings("unchecked")
    public static List<VoGroupActivity> getGroupActivityList(long userId) throws Exception {
        List<VoGroupActivity> activityList = null;
        try {
            activityList = (List<VoGroupActivity>) DbOrm.getORMClient().queryForList("queryGroupActivity", userId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return activityList;
    }

    public static double getUserConsumeSummary(long userId) throws Exception {
        return queryUserFinance(userId, "queryUserConsumeSummary");
    }

    public static double getUserIncomingSummary(long userId) throws Exception {
        return queryUserFinance(userId, "queryUserIncomingSummary");
    }

    private static double queryUserFinance(long userId, String sqlMapKey) throws Exception {
        double finance = 0L;
        try {
            finance = (Double) DbOrm.getORMClient().queryForObject(sqlMapKey, userId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return finance;
    }

    public static void createNewGroup(VoGroup voGroup) throws Exception {
        try {
            long groupId = (Long) DbOrm.getORMClient().insert("insertNewGroup", voGroup);

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("group_id", groupId);
            param.put("user_id", voGroup.getOwnerUserId());
            DbOrm.getORMClient().insert("insertUserGroupRef", param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<VoGroup> searchGroupList(long userId, String searchText) throws Exception {
        List<VoGroup> groupList = null;
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("user_id", userId);
            param.put("search_text", searchText);
            groupList = (List<VoGroup>) DbOrm.getORMClient().queryForList("searchGroupList", param);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return groupList;
    }
    

    public static boolean isGroupExists(String groupName, long ownerId) throws Exception {
        boolean isExists = false;
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("group_name", groupName);
            param.put("owner_id", ownerId);
            Integer groupCount = (Integer) DbOrm.getORMClient().queryForObject("checkUserGroupExists", param);
            isExists = groupCount.intValue() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return isExists;
    }
}
