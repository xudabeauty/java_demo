package com.my.spring.chapter08.part03;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.spring.chapter08.part02.Waiter;

public class PointcytFuncTest {
    @Test
    public void test(){
        String config="com/my/spring/chapter08/part02/applicationContext.xml";
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(config);
        Waiter waiter=(Waiter) classPathXmlApplicationContext.getBean("waiter");
        waiter.greetTo("john");
        waiter.serveTo("john");
        
    }

}
