package com.my.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcTemplateUtil {
    private static JdbcTemplate jdbcTemplate;
    
    public static JdbcTemplate jdbcTemplate() {
        if(jdbcTemplate==null) {
            jdbcTemplate=createJdbcTemplate();
        }
        return jdbcTemplate;
    }

    private static JdbcTemplate createJdbcTemplate() {
        DruidDataSource dSource=new DruidDataSource();
        dSource.setDriverClassName("com.mysql.jdbc.Driver");
        dSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dSource.setUsername("root");
        dSource.setPassword("xh123456");
        return new JdbcTemplate(dSource);
    }

}
