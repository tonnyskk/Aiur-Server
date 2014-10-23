package com.origin.aiur.util;

public class AiurUtils {
    public static boolean isEmpty(String value) {
        if (value == null || value.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    public static String getDbPassword(String password) throws Exception {
//        // decode with base64
//        byte[] rsaDecodedPassword = Base64Util.decode(rsaPassword);
//
//        // Decode with RSA private key
//        byte[] userPassword = RSAUtils.decryptByPrivateKey(rsaDecodedPassword, AiurLoader.getInstance().getPrivateKey());
//
//        // Then use Base64 to encode original password, and save encoded
//        // password into DB
//        return Base64Util.encode(userPassword);
        return password;
    }
}
