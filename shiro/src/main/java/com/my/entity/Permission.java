package com.my.entity;

import java.io.Serializable;

/**
 * 
 * Description.权限 不明白为什么要重写equals hascode这些函数 继续往下抄吧
 * Copyright: Copyright (c) 2018年3月19日 下午4:29:26
 * Author: xuhui
 */
public class Permission implements Serializable {

    /**   */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String permission;//权限标识，程序判断使用如"user:create"
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String description;//权限标识，前台界面显示使用
    private Boolean available=Boolean.FALSE;//是否可用。如果不可用将不会添加给用户
    public Permission(String permission,String description,Boolean isavailable) {
        this.permission=permission;
        this.description=description;
        this.available=available;
    }
    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public Permission() {
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
    
    

}
