package com.my.spring.chapter02.domain;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable{

    /**  */
    private static final long serialVersionUID = 1L;
    
    private int userId;
    private String userName;
    private String password;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getLastIp() {
        return lastIp;
    }
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }
    public Date getLastVisit() {
        return lastVisit;
    }
    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
    private int credit;
    private String lastIp;
    private Date lastVisit;
    

}
