package com.saas.ec;

import org.junit.runner.Runner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.saas.ec.mapper")
public class App
{
    public static void main(String[] args) {

        SpringApplication.run(App.class);
    }
}
