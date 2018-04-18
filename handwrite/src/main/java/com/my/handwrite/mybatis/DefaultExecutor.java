package com.my.handwrite.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.my.handwrite.dataSource.DataSource;
import com.my.handwrite.mybatis.Bean.Test;

public class DefaultExecutor implements Executor {
    
    private Connection getConnect() {
        return new DataSource().getConn().getConnection();
    }
    

    @Override
    public <T> T query(String sql, String param) {
        Connection connect = getConnect();
        try {
            PreparedStatement prepareStatement = connect.prepareStatement(String.format(sql, Integer.parseInt(param)));
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()) {
                Test test=new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
                return (T)test;
            }
        } catch (Exception e) {
           e.printStackTrace();
        } 
        return null;
    }
    

}
