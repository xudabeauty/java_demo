package com.my.handwrite.mybatis.mapper;

import com.my.handwrite.mybatis.Bean.Test;

public class TestMybatis {
    public static void main(String[] args) {
        SqlSession session=new SqlSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        Test test = mapper.selectById(1);
        System.out.println(test);
    }
}
