package com.origin.aiur.service;

import com.origin.aiur.orm.DbService;
import com.origin.aiur.pojo.VoReponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.util.AiurUtils;
import com.origin.aiur.util.RespStatus;

public class UserService {

    public static VoReponse login(String userName, String password) {
        VoReponse response = new VoReponse();
        response.setStatusCode(RespStatus.OK);

        if (AiurUtils.isEmpty(userName)) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_USER);
            return response;
        } else if (AiurUtils.isEmpty(password)) {
            response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_PWD);
            return response;
        }

        try {
            VoUser user = DbService.checkUserAccount(userName, password);
            if (user == null) {
                response.setStatusCode(RespStatus.USER_NOT_FOUND);
                return response;
            }

            response.setVoUser(user);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(RespStatus.ERROR_EXCEPTION);
            response.setStatusMessage(e.getMessage());
        }

        return response;
    }
}
