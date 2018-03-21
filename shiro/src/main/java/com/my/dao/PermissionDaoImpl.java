package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.my.entity.Permission;
import com.my.utils.JdbcTemplateUtil;

public class PermissionDaoImpl implements PermissionDao {
    private JdbcTemplate jdbcTemplate = JdbcTemplateUtil.jdbcTemplate();

    public Permission createPermission(final Permission permission) {
        final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql,  new String[] { "id" });
                psst.setString(1, permission.getPermission());
                psst.setString(2, permission.getDescription());
                psst.setBoolean(3, permission.getAvailable());
                return psst;
            }
        }, keyHolder);
        permission.setId(keyHolder.getKey().longValue());
        return permission;
    }

    public void deletePermission(Long permission) {
        String delete1 = "delete from sys_roles_permissions where permission_id=?";
        String delete2 = "delete from sys_permissions where id=?";
        jdbcTemplate.update(delete1, permission);
        jdbcTemplate.update(delete2, permission);

    }

}
