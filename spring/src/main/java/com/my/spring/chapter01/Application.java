package com.my.spring.chapter01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:/config1.properties")
@TestPropertySource("classpath:/config2.properties")
public class Application {

    @Autowired
    private Environment environment;
    
    public MyBean getBean() {
        //return new MyBean(environment.getProperty("appl.p1",environment.getProperty("app2.p1")));
        return null;
    }
    
public static void main(String[] args) {
}    
}
