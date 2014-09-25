package com.origin.aiur.util;

public class TokenService {

    public static int validToken(String token) {
        if (token == null || token.trim().length() <= 0) {
            return RespStatus.TOKEN_INVALID;
        }

        return RespStatus.OK;
    }
}
