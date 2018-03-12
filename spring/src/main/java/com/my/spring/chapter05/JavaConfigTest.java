package com.my.spring.chapter05;

import static org.junit.Assert.assertNotNull;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConf.class);
        Car car=applicationContext.getBean(Car.class);
        car.setBrand("kdlk");
        car.setColor("red");
        car.setMaxSpeed(100);
        assertNotNull(car);
        System.out.println("bean 容器运行中");
    }

}
