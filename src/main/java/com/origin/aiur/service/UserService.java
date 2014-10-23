package com.origin.aiur.service;

import java.util.List;

import com.origin.aiur.orm.DbService;
import com.origin.aiur.pojo.VoGroup;
import com.origin.aiur.pojo.VoResponse;
import com.origin.aiur.pojo.VoUser;
import com.origin.aiur.util.AiurLog;
import com.origin.aiur.util.AiurUtils;
import com.origin.aiur.util.RespStatus;
import com.origin.aiur.util.TokenUtil;

public class UserService {

	public static VoResponse login(VoUser voUser) {
		VoResponse response = new VoResponse();
		response.setStatusCode(RespStatus.OK);

		if (AiurUtils.isEmpty(voUser.getLoginName())) {
			response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_USER);
			response.setStatusMessage("INVALID_PARAM_EMPTY_USER");
			return response;
		} else if (AiurUtils.isEmpty(voUser.getPassword())) {
			response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_PWD);
			response.setStatusMessage("INVALID_PARAM_EMPTY_PWD");
			return response;
		}

		try {
			VoUser user = DbService.checkUserAccount(voUser.getLoginName(), AiurUtils.getDbPassword(voUser.getPassword()));
			if (user == null) {
				response.setStatusCode(RespStatus.USER_NOT_FOUND);
			} else {
				response.setData(user);
				response.setToken(TokenUtil.generateToken(user.getUserID(), voUser.getDeviceId()));
			}
		} catch (Exception e) {
			AiurLog.logger().error(e.getMessage(), e);

			response.setStatusCode(RespStatus.ERROR_EXCEPTION);
			response.setStatusMessage(e.getMessage());
		}

		return response;
	}

	public static VoResponse regist(VoUser voUser) {
		VoResponse response = new VoResponse();
		response.setStatusCode(RespStatus.OK);

		if (AiurUtils.isEmpty(voUser.getLoginName())) {
			response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_USER);
			response.setStatusMessage("INVALID_PARAM_EMPTY_USER");
			return response;
		}
		if (AiurUtils.isEmpty(voUser.getPassword())) {
			response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_PWD);
			response.setStatusMessage("INVALID_PARAM_EMPTY_PWD");
			return response;
		}
		if (AiurUtils.isEmpty(voUser.getNickName())) {
			response.setStatusCode(RespStatus.INVALID_PARAM_EMPTY_NICK);
			response.setStatusMessage("INVALID_PARAM_EMPTY_NICK");
			return response;
		}

		try {
			if (DbService.isUserExists(voUser.getLoginName())) {
				response.setStatusCode(RespStatus.INVALID_USER_EXISTS);
				response.setStatusMessage("INVALID_USER_EXISTS");
			} else {
				long userId = DbService.regUserAccount(voUser.getLoginName(), voUser.getNickName(), AiurUtils.getDbPassword(voUser.getPassword()));
				VoUser user = DbService.getUserAccount(userId);
				if (user == null) {
					response.setStatusCode(RespStatus.INVALID_CREATE_USER_FAILED);
				} else {
					response.setData(user);
					response.setToken(TokenUtil.generateToken(user.getUserID(), voUser.getDeviceId()));
				}
			}
		} catch (Exception e) {
			AiurLog.logger().error(e.getMessage(), e);

			response.setStatusCode(RespStatus.ERROR_EXCEPTION);
			response.setStatusMessage(e.getMessage());
		}

		return response;

	}

	public static VoResponse queryGroup(long userId) {
		VoResponse response = new VoResponse();
		response.setStatusCode(RespStatus.OK);

		try {
			List<VoGroup> groupList = DbService.getUserGroupList(userId);
			if (groupList == null || groupList.isEmpty()) {
				response.setStatusCode(RespStatus.NO_DATA_FOUND);
			} else {
				response.setData(groupList);
			}
		} catch (Exception e) {
			AiurLog.logger().error(e.getMessage(), e);

			response.setStatusCode(RespStatus.ERROR_EXCEPTION);
			response.setStatusMessage(e.getMessage());
		}

		return response;
	}

}
