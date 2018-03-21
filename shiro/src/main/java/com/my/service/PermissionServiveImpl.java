package com.my.service;

import com.my.dao.PermissionDao;
import com.my.dao.PermissionDaoImpl;
import com.my.entity.Permission;

public class PermissionServiveImpl implements PermissionService {
    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permission) {
        permissionDao.deletePermission(permission);
    }
}
