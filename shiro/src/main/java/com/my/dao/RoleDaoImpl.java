package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.my.entity.Role;
import com.my.utils.JdbcTemplateUtil;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate = JdbcTemplateUtil.jdbcTemplate();

    public Role createRole(final Role role) {
        final String sql="insert into sys_roles(role,description,available) values(?,?,?)";
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psStatement=connection.prepareStatement(sql,new String[] {"id"});
                psStatement.setString(1, role.getRole());
                psStatement.setString(2, role.getDescription());
                psStatement.setBoolean(3, role.getAvailable());
                return psStatement;
            }
        },keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
    }

    public void deleteRole(Long role) {
        //首先删除sys_user的相关role_id数据
        String delete1 = "delete from sys_users where role_id=?";
        jdbcTemplate.update(delete1, role);
        String delete2 = "delete from sys_roles where id=?";
        jdbcTemplate.update(delete2, role);
    }

    public void correlationPermissions(Long roleId, Long... permissioIds) {
        if (permissioIds == null || permissioIds.length == 0)
            return;
        String sql = "insert into sys_roles_permissions(role_id,permission_id) values(?,?)";
        for (Long permissinId : permissioIds) {
            if (!exists(roleId, permissinId)) {
                jdbcTemplate.update(sql, roleId, permissinId);
            }
        }
    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0)
            return;
        String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
        for (Long permissionId : permissionIds) {
            if (exists(roleId, permissionId)) {
                jdbcTemplate.update(sql, roleId, permissionId);
            }
        }
    }

    private boolean exists(Long roleId, Long permissinId) {
        String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, roleId, permissinId) != 0;
    }
}
