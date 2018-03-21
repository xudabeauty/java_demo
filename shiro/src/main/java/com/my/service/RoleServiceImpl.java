package com.my.service;

import com.my.dao.RoleDao;
import com.my.dao.RoleDaoImpl;
import com.my.entity.Role;

public class RoleServiceImpl implements RoleService  {
    private RoleDao roleDao=new RoleDaoImpl();

    public Role creatRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-用户之间关系
     */
    public void correlationPermission(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    public void uncorrelationPermission(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }

}
