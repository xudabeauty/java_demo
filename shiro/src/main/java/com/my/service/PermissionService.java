package com.my.service;

import com.my.entity.Permission;

public interface PermissionService {
    
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permission);

}
