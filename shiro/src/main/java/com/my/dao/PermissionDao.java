package com.my.dao;

import com.my.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permission);

}
