package com.my.service;

import com.my.entity.Role;

public interface RoleService {
    public Role creatRole(Role role);
    public void deleteRole(Long roleId);
    /**
     * 添加角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermission(Long roleId,Long...permissionIds);
    
    /**
     * 删除角色-权限关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermission(Long roleId,Long...permissionIds);

}
