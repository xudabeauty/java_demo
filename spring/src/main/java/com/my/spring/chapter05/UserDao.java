package com.my.spring.chapter05;

import org.springframework.stereotype.Component;
//这个效果等同于<bean id="userDao" class="com.my.spring.userDao"></bean>，spring自动将该pojo转换为容器处理
@Component("userDao")  
public class UserDao {

}
