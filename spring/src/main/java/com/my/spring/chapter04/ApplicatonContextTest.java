package com.my.spring.chapter04;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicatonContextTest {
    @Test
    public void getBean() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Beans.class);
        Car car=applicationContext.getBean("car",Car.class);
        assertNotNull(car);
        car.introduce();
        
        
    }

}
