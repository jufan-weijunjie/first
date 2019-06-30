package com.wei.first.bean;

import com.wei.first.common.BasePageBean;

import java.io.Serializable;
import java.util.Date;

public class GetPhoto extends BasePageBean {
    private Integer id;

    /**
     * 图片下标
     */
    private Integer photoIndex;

    private String photoCode;

    private String photoName;

    /**
     * 缩略图
     */
    private String narrowUrl;

    /**
     * 清晰图
     */
    private String clearUrl;

    /**
     * 图片总数
     */
    private Integer total;

    private Date createTime;

    private Date updateTime;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhotoIndex() {
        return photoIndex;
    }

    public void setPhotoIndex(Integer photoIndex) {
        this.photoIndex = photoIndex;
    }

    public String getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(String photoCode) {
        this.photoCode = photoCode == null ? null : photoCode.trim();
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getNarrowUrl() {
        return narrowUrl;
    }

    public void setNarrowUrl(String narrowUrl) {
        this.narrowUrl = narrowUrl == null ? null : narrowUrl.trim();
    }

    public String getClearUrl() {
        return clearUrl;
    }

    public void setClearUrl(String clearUrl) {
        this.clearUrl = clearUrl == null ? null : clearUrl.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photoIndex=").append(photoIndex);
        sb.append(", photoCode=").append(photoCode);
        sb.append(", photoName=").append(photoName);
        sb.append(", narrowUrl=").append(narrowUrl);
        sb.append(", clearUrl=").append(clearUrl);
        sb.append(", total=").append(total);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}