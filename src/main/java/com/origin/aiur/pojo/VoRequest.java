package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoRequest {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
