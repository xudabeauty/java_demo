package com.my.spring.chapter02.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.my.spring.chapter02.domain.User;

@Repository
public class UserDao {
    
    private JdbcTemplate template;
    
    private final  static String MATCH_COUNT_SQL="select count(*) from t_user where user_name=? and password=?";
    private final static String UPDTE_LOGIN_LOG_INFO="update t_user set last_visit=?,last_ip=?,credits=? where user_id =?";

    @Autowired
    public void setJdbcTempate(JdbcTemplate jdbcTemplate) {
        this.template=jdbcTemplate;
    }
    
    public int GetMatchCout(String user,String password) {
        String sqlStr="select count(*) from t_user  where user_name=? and password =?";
        return template.queryForInt(sqlStr,new Object[] {user,password});
    }
    
    public User getUserByUsernaem(final String username) {
        final User user=new User();
        template.query(MATCH_COUNT_SQL, new Object[] {username},new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(username);
                user.setCredit(rs.getInt("credit"));
            }
        });
        return user;
    }
    
    public void updateLoginInfo(User user) {
        template.update(UPDTE_LOGIN_LOG_INFO,new Object[] {user.getLastVisit(),user.getLastIp(),user.getCredit(),user.getUserId()});
    }

}
