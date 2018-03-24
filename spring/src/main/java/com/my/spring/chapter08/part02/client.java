package com.my.spring.chapter08.part02;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
    @Test
    public void test() {
        String config="com/my/spring/chapter08/part02/applicationContext.xml";
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);
        Waiter waiter =(Waiter) classPathXmlApplicationContext.getBean("waiter");
        waiter.serveTo("john");
        waiter.greetTo("john");
    }

}
