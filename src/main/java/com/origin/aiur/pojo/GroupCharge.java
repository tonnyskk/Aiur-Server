package com.origin.aiur.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GroupCharge {
    private double money;
    private long userId;
    private long groupId;
    private List<Long> userList;
    private String description;
    private boolean userPrePay;
    private boolean payByGroupOwner;
    private String status;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUserPrePay() {
        return userPrePay;
    }

    public void setUserPrePay(boolean userPrePay) {
        this.userPrePay = userPrePay;
    }

    public boolean isPayByGroupOwner() {
        return payByGroupOwner;
    }

    public void setPayByGroupOwner(boolean payByGroupOwner) {
        this.payByGroupOwner = payByGroupOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupCharge [userId=" + userId + ", groupId=" + groupId + ", userList=" + userList + ", description=" + description + ", userPrePay=" + userPrePay + ", payByGroupOwner="
                + payByGroupOwner + ", money=" + money + "]";
    }


}
