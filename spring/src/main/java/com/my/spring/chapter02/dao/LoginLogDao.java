package com.my.spring.chapter02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my.spring.chapter02.domain.LoginLog;

@Repository
public class LoginLogDao {

    private JdbcTemplate template;
    
    private final static String INSERT_LOGIN_SQL="insert into t_login_log(user_id,ip,login_datetime)  values (?,?,?)";
    public void insertLoginLog(LoginLog loginLog) {
        Object[] args= {loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        template.update(INSERT_LOGIN_SQL,args);
    }
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template=jdbcTemplate;
    }
}
