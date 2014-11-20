package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoFinance {
    private double consumeSummary;
    private double incomingSummary;
    private long userId;

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public double getConsumeSummary() {
        return consumeSummary;
    }
    public void setConsumeSummary(double consumeSummary) {
        this.consumeSummary = consumeSummary;
    }
    public double getIncomingSummary() {
        return incomingSummary;
    }
    public void setIncomingSummary(double incomingSummary) {
        this.incomingSummary = incomingSummary;
    }
    
}
