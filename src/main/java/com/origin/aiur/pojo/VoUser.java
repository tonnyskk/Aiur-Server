package com.origin.aiur.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoUser {
    private int userID;
    private String loginName;
    private String nickName;
    private List<VoGroup> userGroupList;
    
    public VoUser() {
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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

    
    

}
