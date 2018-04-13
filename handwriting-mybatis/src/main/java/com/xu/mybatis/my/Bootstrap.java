package com.xu.mybatis.my;

import com.xu.mybatis.bean.Test;

public class Bootstrap {
    public static void start() {
        MySqlSession mySqlSession = new MySqlSession();
        TestMapper mapper = mySqlSession.getMapper(TestMapper.class);
        Test test = mapper.getByPrimaryId(1);
        System.out.println(test);
    }
    public static void main(String[] args) {
        start();
    }

}
