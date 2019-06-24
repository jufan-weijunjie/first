package com.wei.first.bean;

import java.io.Serializable;
import java.util.Date;

public class SysRolePower implements Serializable {
    private Integer id;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 角色权限 
     */
    private String rolePowerName;

    /**
     * 角色权限状态
     */
    private String rolePowerStatus;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getRolePowerName() {
        return rolePowerName;
    }

    public void setRolePowerName(String rolePowerName) {
        this.rolePowerName = rolePowerName == null ? null : rolePowerName.trim();
    }

    public String getRolePowerStatus() {
        return rolePowerStatus;
    }

    public void setRolePowerStatus(String rolePowerStatus) {
        this.rolePowerStatus = rolePowerStatus == null ? null : rolePowerStatus.trim();
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
        sb.append(", userRole=").append(userRole);
        sb.append(", rolePowerName=").append(rolePowerName);
        sb.append(", rolePowerStatus=").append(rolePowerStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}