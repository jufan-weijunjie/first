package com.wei.first.bean;

import java.io.Serializable;
import java.util.Date;

public class SysUserPower implements Serializable {
    private Integer id;

    /**
     * 权限名称
     */
    private String powerName;

    /**
     * 权限描述
     */
    private String powerNote;

    /**
     * 权限状态（1启用0禁用）
     */
    private String powerStatus;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }

    public String getPowerNote() {
        return powerNote;
    }

    public void setPowerNote(String powerNote) {
        this.powerNote = powerNote == null ? null : powerNote.trim();
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus == null ? null : powerStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", powerName=").append(powerName);
        sb.append(", powerNote=").append(powerNote);
        sb.append(", powerStatus=").append(powerStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}