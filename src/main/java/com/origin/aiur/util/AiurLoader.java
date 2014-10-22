package com.origin.aiur.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AiurLoader {
	private Properties props = null;
	private static AiurLoader loader = new AiurLoader();

	private AiurLoader() {
		init();
	}

	public static AiurLoader getInstance() {
		return loader;
	}

	private void init() {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("config.properties");
		props = new Properties();
		try {
			props.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public String getProp(String key) {
		if (key == null || key.trim().length() <= 0) {
			return null;
		}
		if (props == null) {
			return null;
		}
		return props.getProperty(key);
	}

	public String getPublicKey() {
		return getProp("RSA.PUBLIC");
	}
	public String getPrivateKey() {
		return getProp("RSA.PRIVATE");
	}
}
