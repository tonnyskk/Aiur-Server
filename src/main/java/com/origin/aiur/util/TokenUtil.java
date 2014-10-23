package com.origin.aiur.util;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.origin.aiur.exception.IllegalValueException;

public class TokenUtil {
	private static final byte[] CRYPTO_KEY = "Aiur.SE.DJia.key".getBytes();
	private static final String CIPHER_KEY = "AES/CBC/PKCS5Padding";
	private static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
	public static final SecureRandom secRand = new SecureRandom();
	private static final String DELIM = "|";
	public static final String TOKEN_EXPIRE_KEY = "Expire-At";
	public static final String TOKEN_USER_ID = "User-Id";
	public static final String TOKEN_DEVICE_ID = "Device-Id";

	public static Map<String, String> decodeToken(String token) {
		Map<String, String> paraMap = Collections.emptyMap();
		if (AiurUtils.isEmpty(token)) {
			return paraMap;
		}

		try {
			String decryptToken = decryptToken(token.trim());
			AiurLog.logger().info("decode=" + decryptToken);
			if (decryptToken != null) {
				return stringToMap(decryptToken, DELIM);
			}
		} catch (IllegalValueException e) {
		}
		return paraMap;
	}

	private static Map<String, String> stringToMap(String string, String delim) {
		StringTokenizer st = new StringTokenizer(string, delim);
		Map<String, String> map = Collections.emptyMap();
		if (st.hasMoreTokens()) {
			map = new HashMap<String, String>();
		}
		while (st.hasMoreTokens()) {
			String pair = st.nextToken();
			int i = pair.indexOf('=');
			if (i > 0) {
				String key = pair.substring(0, i);
				String value = pair.substring(i + 1);
				map.put(key, value);
			}
		}
		return map;
	}

	public static boolean isExpired(String expiryDateString) {
		long expiryDateLong = Long.parseLong(expiryDateString);
		Calendar expiryDate = Calendar.getInstance(GMT_TIME_ZONE);
		expiryDate.setTimeInMillis(expiryDateLong);

		Calendar now = Calendar.getInstance(GMT_TIME_ZONE);
		return expiryDate.before(now);
	}

	public static String generateToken(long userId, String deviceId) throws IllegalValueException {
		return generateToken(userId, deviceId, 7);
	}

	public static String generateToken(long userId, String deviceId, int validDay) throws IllegalValueException {
		Calendar now = Calendar.getInstance(GMT_TIME_ZONE);
		long timeInMillis = now.getTimeInMillis();
		long expire = timeInMillis + validDay * 24 * 60 * 60 * 1000; // login/reg 1 days, others 7 days

		StringBuilder builder = new StringBuilder();
		builder.append(TOKEN_USER_ID).append("=").append(userId).append(DELIM);
		builder.append(TOKEN_DEVICE_ID).append("=").append(deviceId).append(DELIM);
		builder.append(TOKEN_EXPIRE_KEY).append("=").append(expire);
		return generateToken(builder.toString());
	}

	private static String generateToken(String paramValue) throws IllegalValueException {
		if (AiurUtils.isEmpty(paramValue)) {
			return paramValue;
		}

		try {
			byte[] encrypted = encrypt(CRYPTO_KEY, paramValue.getBytes());
			byte[] encoded = Base64.encodeBase64(encrypted);
			return new String(encoded);
		} catch (IllegalValueException ex) {
			throw ex;
		}
	}

	private static String decryptToken(String token) throws IllegalValueException {
		String decrypted = null;
		try {
			byte[] tokenBytes = token.getBytes();
			if (!Base64.isBase64(tokenBytes)) {
				throw new IllegalValueException("Token is not base64 encoded.");
			}
			byte[] decoded = Base64.decodeBase64(tokenBytes);
			decrypted = new String(decrypt(CRYPTO_KEY, decoded));
		} catch (IllegalValueException e) {
			throw e;
		}
		return decrypted;
	}

	private static byte[] encrypt(byte[] key, byte[] encryptByte) throws IllegalValueException {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_KEY);
			byte abyte2[] = generateRandomBytes(cipher.getBlockSize());
			SecretKeySpec secretkeyspec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(abyte2);
			cipher.init(1, secretkeyspec, ivparameterspec);
			byte abyte3[] = cipher.doFinal(encryptByte);
			byte abyte4[] = new byte[abyte2.length + abyte3.length];
			System.arraycopy(abyte2, 0, abyte4, 0, abyte2.length);
			System.arraycopy(abyte3, 0, abyte4, abyte2.length, abyte3.length);
			return abyte4;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalValueException("Error while encrypting token: " + e.getMessage(), e);
		}
	}

	public static byte[] decrypt(byte abyte0[], byte abyte1[]) throws IllegalValueException {
		try {
			byte abyte2[] = new byte[16];
			System.arraycopy(abyte1, 0, abyte2, 0, abyte2.length);
			Cipher cipher = Cipher.getInstance(CIPHER_KEY);
			SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(abyte2);
			cipher.init(2, secretkeyspec, ivparameterspec);
			return cipher.doFinal(abyte1, abyte2.length, abyte1.length - abyte2.length);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalValueException("Error while decrypting token: " + e.getMessage(), e);
		}
	}

	public static byte[] generateRandomBytes(int i) {
		byte abyte0[] = new byte[i];
		secRand.nextBytes(abyte0);
		return abyte0;
	}
}
