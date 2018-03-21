package com.my.entity;

import java.io.Serializable;
/**
 * Description.用户角色关系
 * Copyright: Copyright (c) 2018年3月19日 下午4:20:37
 * Author: xuhui
 */
public class UserRole  implements Serializable{

    /**   */
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long roleId;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        UserRole userRole=(UserRole) o;
        if(roleId!=null?!roleId.equals(userRole.getRoleId()):userRole.roleId!=null) return false;
        if(userId!=null?userId.equals(userRole.getUserId()):userRole.userId!=null) return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

}
