package com.saas.ec.model;

import com.saas.ec.entity.ActivityEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ActivityParamVo implements Serializable {
    private static final long serialVersionUID = 4311328077397328517L;

    private  Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Date updateTime;
    private Long minId;
    private Integer limitNum;
    private List<ActivityEntity> activityParamVoList;

    public List<ActivityEntity> getActivityParamVoList() {
        return activityParamVoList;
    }

    public void setActivityParamVoList(List<ActivityEntity> activityParamVoList) {
        this.activityParamVoList = activityParamVoList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Long getMinId() {
        return minId;
    }

    public void setMinId(Long minId) {
        this.minId = minId;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }
}
