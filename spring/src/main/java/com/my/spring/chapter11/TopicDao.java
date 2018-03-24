package com.my.spring.chapter11;

import java.sql.Connection;
/**
 * 数据库连接是单例的，使用threadLocal进行线程同步
 * 
 * @author huixu
 * @version $Id: TopicDao.java, v 0.1 2018年3月24日 下午5:27:54 huixu Exp $
 */
public class TopicDao {
    private static ThreadLocal<Connection> connection=new ThreadLocal<>();
    public static Connection getConnection() {
//        if(connection.get()==null) {
//            Connection conn=ConnectinManger.getConnection;
//            connection.set(conn);
//            return conn;
//        }else {
//            connection.get();
//        }
        return null;
    }

}
