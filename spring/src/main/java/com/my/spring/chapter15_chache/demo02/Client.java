package com.my.spring.chapter15_chache.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/my/spring/chapter15_chache/demo02/application.xml");
        UserService userService=(UserService)applicationContext.getBean("accountUserService");
        System.out.println("第一次查询");
        userService.getUserById("01");
        System.out.println("第二次查询");
        userService.getUserById("01");
    }

}
