package com.my.spring.chapter05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }
    @Bean
    public Car car() {
        return new Car();
    }

}
