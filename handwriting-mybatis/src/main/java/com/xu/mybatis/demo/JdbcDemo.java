package com.xu.mybatis.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xu.mybatis.bean.Test;

public class JdbcDemo {
    public static final String ulr = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static int insert(Test test) {
        Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ulr,"root","xh123456");
            preparedStatement = connection.prepareStatement("insert into test values(?,?,?)");
            if (null != test.getId()) {
                preparedStatement.setInt(1, test.getId());
            } else {
                preparedStatement.setInt(1, 10);
            }
            preparedStatement.setInt(2, test.getNums());
            preparedStatement.setString(3, test.getName());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }
    
    public static Test get(int id) {
        Connection connection=null;
       PreparedStatement preparedStatement=null;
        Test test=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ulr,"root","xh123456");
            preparedStatement=connection.prepareStatement("select * from test where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                test =new Test();
                test.setId(resultSet.getInt(1));
                test.setNums(resultSet.getInt(2));
                test.setName(resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null&&!connection.isClosed())
                    connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return test;
    }
    
    public static void main(String[] args) {
        Test test = get(1);
        System.out.println(test);
        Test test2 = new Test(45, 7, "zhangzhang ");
        int insert = insert(test2);
        System.out.println(insert);
    }

}
