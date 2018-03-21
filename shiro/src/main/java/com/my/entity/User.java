package com.my.entity;

import java.io.Serializable;

public class User implements Serializable{
    /**   */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    private String salt;
    private Boolean  locked=Boolean.FALSE;
    public User() {
    }
    
    public User(String username,String oassword) {
        this.username=username;
        this.password=oassword;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getLocked() {
        return locked;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    @Override
    public int hashCode() {
        return id!=null?id.hashCode():0;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
    
}
