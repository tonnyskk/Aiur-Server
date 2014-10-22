package com.origin.aiur.util;

import org.apache.commons.codec.binary.Base64;

public class AiurUtils {
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().length() <= 0) {
			return true;
		}
		return false;
	}

	public static String getDbPassword(String rsaPassword) throws Exception {
		byte[] userPassword = RSAUtils.decryptByPrivateKey(rsaPassword
				.getBytes(), AiurLoader.getInstance().getPrivateKey());
		String dbPassword = Base64.encodeBase64String(userPassword);

		return dbPassword;
	}
}
