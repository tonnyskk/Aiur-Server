package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoGroupActivity {
    private long activityId;
    private long groupId;
    private String groupName;
    private double money;

    private String description;
    private String status;
    private long createTime;
    private String type;
    private double groupConsume;
    private double userConsume;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getGroupConsume() {
        return groupConsume;
    }

    public void setGroupConsume(double groupConsume) {
        this.groupConsume = groupConsume;
    }

    public double getUserConsume() {
        return userConsume;
    }

    public void setUserConsume(double userConsume) {
        this.userConsume = userConsume;
    }
}
