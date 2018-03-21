package com.my.spring.chapter02.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{

    public int getLoginLogId() {
        return loginLogId;
    }
    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public Date getLoginDate() {
        return loginDate;
    }
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    /**  */
    private static final long serialVersionUID = 1L;
    
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;
    

}