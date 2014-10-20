package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoReponse {
    private int statusCode;
    private String statusMessage;
    private VoUser voUser;

    public VoReponse() {
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

    public VoUser getVoUser() {
        return voUser;
    }

    public void setVoUser(VoUser voUser) {
        this.voUser = voUser;
    }
    
}
