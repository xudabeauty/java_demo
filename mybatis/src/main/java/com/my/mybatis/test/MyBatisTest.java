package com.my.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.my.mybatis.bean.Employee;
import com.my.mybatis.mapper.EmployeeMapper;

public class MyBatisTest {
    @Test
   public  void test() {
        try {
            
            InputStream inputStream=this.getClass().getResourceAsStream("/mybatis-config.xml");        
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
           Employee employee= mapper.selectEmployee(1);
           System.out.println(employee.getEmail());
            sqlSession.close();
        }catch (Exception e) {
          e.printStackTrace();
        }
        
    }

}
