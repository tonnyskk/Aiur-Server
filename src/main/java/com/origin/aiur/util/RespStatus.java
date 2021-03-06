package com.origin.aiur.util;

public class RespStatus {
    public static final int OK = 200;
    public static final int ERROR_EXCEPTION = 4000;
    public static final int TOKEN_INVALID = 4001;
    public static final int TOKEN_EXIRE = 4002;
    public static final int ERROR_REQUEST = 4003;
    public static final int USER_NOT_FOUND = 4004;

    public static final int INVALID_PARAM_EMPTY_USER = 4005;
    public static final int INVALID_PARAM_EMPTY_PWD  = 4006;
    public static final int INVALID_PARAM_EMPTY_NICK  = 4007;
    public static final int INVALID_USER_EXISTS  = 4008;
    public static final int INVALID_CREATE_USER_FAILED  = 4009;
    public static final int INVALID_PARAM_EMPTY_GP_NAME  = 4010;
    public static final int INVALID_GROUP_NOT_FOUND  = 4011;
    public static final int INVALID_GROUP_EXISTS  = 4012;
    public static final int INVALID_CHANGE_PWD_WRONG = 4013;
    

    public static final int WARN_NO_DATA_FOUND = 3000;
    public static final int WARN_GROUP_JOIN_REPEATE_REQUEST = 3001;
    
}
