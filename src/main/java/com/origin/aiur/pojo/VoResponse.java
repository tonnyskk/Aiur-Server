package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoResponse {
    private int statusCode;
    private String statusMessage;
    private Object data;
    private String token;
    private String key;

    public VoResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object voUser) {
        this.data = voUser;
    }

    public String getToken() {
        return token;
    }

	public void setToken(String token) {
        this.token = token;
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    
    
}
