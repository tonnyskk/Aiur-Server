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
    private boolean isPrepaied;
    
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
    
    public boolean isPrepaied() {
        return isPrepaied;
    }
    public void setPrepaied(boolean isPrepaied) {
        this.isPrepaied = isPrepaied;
    }
    @Override
    public String toString() {
        return "GroupCharge [groupId=" + groupId + ", userId=" + userId + ", money=" + money + ", userList=" + userList + "]";
    }
    
}
