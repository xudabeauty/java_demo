package com.xu.mybatis.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xu.mybatis.bean.Test;

public class SimpleExecutor implements Executor {
    private final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, "root", "xh123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T query(String sql, String params) {
        Connection connect = getConnect();
        try {
            PreparedStatement prepareStatement = connect.prepareStatement(String.format(sql, Integer.parseInt(params)));
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
                return (T) test;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
