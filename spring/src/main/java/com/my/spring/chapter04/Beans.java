package com.my.spring.chapter04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean(name="car")
    public Car buildCar() {
       Car car=new Car();
       car.setBrand("红旗");
       car.setColor("black");
       car.setMaxSpeed(200);
       return car;
    }

}
