package com.origin.aiur.service;

import java.util.List;

import com.origin.aiur.orm.DbService;
import com.origin.aiur.pojo.VoGroup;
import com.origin.aiur.pojo.VoGroupActivity;
import com.origin.aiur.pojo.VoResponse;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.AiurUtils;
import com.origin.aiur.util.RespStatus;

public class GroupService {
    public static VoResponse queryGroupActivity(long userId) {
        VoResponse response = new VoResponse();
        response.setStatusCode(RespStatus.OK);

        try {
            List<VoGroupActivity> activityList = DbService.getGroupActivityList(userId);
            if (activityList == null || activityList.isEmpty()) {
                response.setStatusCode(RespStatus.WARN_NO_DATA_FOUND);
            } else {
                response.setData(activityList);
            }
        } catch (Exception e) {
            AiurLog.logger().error(e.getMessage(), e);

            response.setStatusCode(RespStatus.ERROR_EXCEPTION);
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }

    public static VoResponse createNewGroup(VoGroup voGroup) {
        VoResponse response = new VoResponse();
        response.setStatusCode(RespStatus.OK);

        try {
            if (AiurUtils.isEmpty(voGroup.getGroupName())) {
                response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_GP_NAME);
                response.setStatusMessage("INVALID_PARAM_EMPTY_GP_NAME");
                return response;
            }

            DbService.createNewGroup(voGroup);
        } catch (Exception e) {
            AiurLog.logger().error(e.getMessage(), e);

            response.setStatusCode(RespStatus.ERROR_EXCEPTION);
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }

}
