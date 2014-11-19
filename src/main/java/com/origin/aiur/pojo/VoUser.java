package com.origin.aiur.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoUser {
    private long userID;
    private long groupId;
    private String loginName;
    private String nickName;
    private String password;
    private String deviceId;
    private List<VoGroup> userGroupList;
    private long createTime;
    private double prepayMoney;
    private double cosumeMoney;

    public VoUser() {

    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<VoGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<VoGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public double getPrepayMoney() {
        return prepayMoney;
    }

    public void setPrepayMoney(double prepayMoney) {
        this.prepayMoney = prepayMoney;
    }

    public double getCosumeMoney() {
        return cosumeMoney;
    }

    public void setCosumeMoney(double cosumeMoney) {
        this.cosumeMoney = cosumeMoney;
    }

    @Override
    public String toString() {
        return "VoUser [userID=" + userID + ", loginName=" + loginName + ", nickName=" + nickName + ", deviceId=" + deviceId + "]";
    }
}
