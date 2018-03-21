package com.my.dao;

import com.my.entity.Role;

public interface RoleDao {
    public Role createRole(Role role);
    public void deleteRole(Long role);
    
    public void correlationPermissions(Long roleId,Long...permissioIds);
    public void uncorrelationPermissions(Long roleId,Long...permissionIds);

}
