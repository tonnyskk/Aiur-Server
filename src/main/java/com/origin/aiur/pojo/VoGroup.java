package com.origin.aiur.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VoGroup {
    private long groupId;
    private String groupName;
    private boolean ownerUserId;

    public VoGroup() {

    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(boolean ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

}
