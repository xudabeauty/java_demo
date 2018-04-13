package com.xu.mybatis.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xu.mybatis.bean.Test;
import com.xu.mybatis.mapper.TestMapper;

public class MybatisDemo {
    public static SqlSession getSqlSession() {
        try {
            FileInputStream config = new FileInputStream("F:\\JavaProject\\tc\\Workspace\\handwriting-mybatis\\src\\main\\java\\com\\xu\\mybatis\\demo\\Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
            return factory.openSession();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Test get(SqlSession session,int id) {
        TestMapper mapper = session.getMapper(TestMapper.class);
        return mapper.selectByPrimaryKey(id);
    }
public static void main(String[] args) {
    SqlSession session=null;
    try {
         session = getSqlSession();
        System.out.println(get(session, 1));
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        if(session!=null) {
            session.close();
        }
    }
}    
    
}
