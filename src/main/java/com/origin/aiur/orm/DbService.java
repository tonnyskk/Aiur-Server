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
            param.put("pwd_val",  pwd);
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
            param.put("pwd_val",  password);
            param.put("nick_name",  nickName);
            userId = (Long)DbOrm.getORMClient().insert("insertNewUser", param);
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
//    
//    
//    // **************************************************************************
//    /**
//     * @Title: getCrossList
//     * @return
//     * @return List<CrossItem>
//     * @throws
//     */
//    // **************************************************************************
//    @SuppressWarnings("unchecked")
//    public static List<VoUser> getUserList(long userId) {
//        List<VoUser> crossList = null;
//        try {
//            crossList = (List<VoUser>) DbOrm.getORMClient().queryForList("getGroupList", userId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return crossList;
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: getMailActiveStatus
//     * @param checkCode
//     * @return
//     * @return String
//     * @throws
//     */
//    // **************************************************************************
//    public static String getMailActiveStatus(String checkCode) {
//        String status = null;
//        try {
//            status = (String) DbOrm.getORMClient().queryForObject("getActiveMailStatus", checkCode);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: insertActiveMail
//     * @param checkCode
//     * @param oauthNoticeMailMsg
//     * @return void
//     * @throws
//     */
//    // **************************************************************************
//    public static void insertActiveMail(String checkCode, String oauthNoticeMailMsg) {
//        try {
//            Map<String, String> param = new HashMap<String, String>();
//            param.put("mail_code", checkCode);
//            param.put("mail_msg", oauthNoticeMailMsg);
//            DbOrm.getORMClient().insert("insertActiveMail", param);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: updateActiveMail
//     * @param state
//     * @return void
//     * @throws
//     */
//    // **************************************************************************
//    public static void updateActiveMail(String state) {
//        try {
//            DbOrm.getORMClient().update("updateActiveMail", state);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: getUserTimelineId
//     * @param sinaUid
//     * @return
//     * @return long
//     * @throws
//     */
//    // **************************************************************************
//    public static long getUserTimelineId(String sinaUid) {
//        long timelineId = 0;
//        try {
//            Long object = (Long) DbOrm.getORMClient().queryForObject("getUserTimelineId", sinaUid);
//            if (object != null) {
//                timelineId = object.longValue();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return timelineId;
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: saveUserTimelineId
//     * @param sinaUid
//     * @param maxTimeLineId
//     * @return void
//     * @throws
//     */
//    // **************************************************************************
//    public static void saveUserTimelineId(String sinaUid, long maxTimeLineId) {
//        try {
//            Map<String, String> param = new HashMap<String, String>();
//            param.put("user_uuid", sinaUid);
//            param.put("timeline_id", String.valueOf(maxTimeLineId));
//            DbOrm.getORMClient().update("updateUserTimelineId", param);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: getTrafficRoad
//     * @param orderMap
//     * @return
//     * @return long
//     * @throws
//     */
//    // **************************************************************************
//    public static long getTrafficRoad(Map<String, String> orderMap) {
//        long roadId = 0L;
//        try {
//            Long road = (Long) DbOrm.getORMClient().queryForObject("getTrafficRoadId", orderMap);
//            if (road == null || road.longValue() <= 0) {
//                roadId = (Long) DbOrm.getORMClient().insert("insertTrafficRoad", orderMap);
//            } else {
//                roadId = road.longValue();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return roadId;
//    }
//
//    // **************************************************************************
//    /**
//     * @Title: saveUserTrafficOrder
//     * @param userMap
//     * @return void
//     * @throws
//     */
//    // **************************************************************************
//    public static void saveUserTrafficOrder(Map<String, Object> userMap) {
//        try {
//            DbOrm.getORMClient().insert("insertUserTrafficRoad", userMap);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
