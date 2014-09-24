package com.origin.aiur.orm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.origin.aiur.pojo.VoUser;

public class DbService {

    // **************************************************************************
    /**
     * @Title: getCrossList
     * @return
     * @return List<CrossItem>
     * @throws
     */
    // **************************************************************************
    @SuppressWarnings("unchecked")
    public static List<VoUser> getUserList(long userId) {
        List<VoUser> crossList = null;
        try {
            crossList = (List<VoUser>) DbOrm.getORMClient().queryForList("getGroupList", userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crossList;
    }

    // **************************************************************************
    /**
     * @Title: getMailActiveStatus
     * @param checkCode
     * @return
     * @return String
     * @throws
     */
    // **************************************************************************
    public static String getMailActiveStatus(String checkCode) {
        String status = null;
        try {
            status = (String) DbOrm.getORMClient().queryForObject("getActiveMailStatus", checkCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    // **************************************************************************
    /**
     * @Title: insertActiveMail
     * @param checkCode
     * @param oauthNoticeMailMsg
     * @return void
     * @throws
     */
    // **************************************************************************
    public static void insertActiveMail(String checkCode, String oauthNoticeMailMsg) {
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("mail_code", checkCode);
            param.put("mail_msg", oauthNoticeMailMsg);
            DbOrm.getORMClient().insert("insertActiveMail", param);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // **************************************************************************
    /**
     * @Title: updateActiveMail
     * @param state
     * @return void
     * @throws
     */
    // **************************************************************************
    public static void updateActiveMail(String state) {
        try {
            DbOrm.getORMClient().update("updateActiveMail", state);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // **************************************************************************
    /**
     * @Title: getUserTimelineId
     * @param sinaUid
     * @return
     * @return long
     * @throws
     */
    // **************************************************************************
    public static long getUserTimelineId(String sinaUid) {
        long timelineId = 0;
        try {
            Long object = (Long) DbOrm.getORMClient().queryForObject("getUserTimelineId", sinaUid);
            if (object != null) {
                timelineId = object.longValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timelineId;
    }

    // **************************************************************************
    /**
     * @Title: saveUserTimelineId
     * @param sinaUid
     * @param maxTimeLineId
     * @return void
     * @throws
     */
    // **************************************************************************
    public static void saveUserTimelineId(String sinaUid, long maxTimeLineId) {
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("user_uuid", sinaUid);
            param.put("timeline_id", String.valueOf(maxTimeLineId));
            DbOrm.getORMClient().update("updateUserTimelineId", param);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // **************************************************************************
    /**
     * @Title: getTrafficRoad
     * @param orderMap
     * @return
     * @return long
     * @throws
     */
    // **************************************************************************
    public static long getTrafficRoad(Map<String, String> orderMap) {
        long roadId = 0L;
        try {
            Long road = (Long) DbOrm.getORMClient().queryForObject("getTrafficRoadId", orderMap);
            if (road == null || road.longValue() <= 0) {
                roadId = (Long) DbOrm.getORMClient().insert("insertTrafficRoad", orderMap);
            } else {
                roadId = road.longValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roadId;
    }

    // **************************************************************************
    /**
     * @Title: saveUserTrafficOrder
     * @param userMap
     * @return void
     * @throws
     */
    // **************************************************************************
    public static void saveUserTrafficOrder(Map<String, Object> userMap) {
        try {
            DbOrm.getORMClient().insert("insertUserTrafficRoad", userMap);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
