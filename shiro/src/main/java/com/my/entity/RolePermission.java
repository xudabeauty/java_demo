package com.my.entity;

import java.io.Serializable;
/**
 * Description.用户角色关系
 * Copyright: Copyright (c) 2018年3月19日 下午4:31:15
 * Author: xuhui
 */
public class RolePermission implements Serializable {

    /**   */
    private static final long serialVersionUID = 1L;
    private Long roleId;
    private Long permissionId;
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermission rolePermission = (RolePermission) o;

        if (permissionId != null ? !permissionId.equals(rolePermission.permissionId) : rolePermission.permissionId != null) return false;
        if (roleId != null ? !roleId.equals(rolePermission.roleId) : rolePermission.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePermssion{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
