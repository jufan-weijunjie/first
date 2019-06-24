package com.wei.first.bean;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    private Integer id;

    /**
     * 用户code
     */
    private String userCode;

    /**
     * 用户角色
     */
    private String userRole;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userCode=").append(userCode);
        sb.append(", userRole=").append(userRole);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}