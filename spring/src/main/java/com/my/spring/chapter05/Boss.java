package com.my.spring.chapter05;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class Boss {
    private Car car;
    
    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(Car car) {
        System.out.println("execute in setCar");
        this.car = car;
    }
    @PostConstruct
    private void init1() {
        System.out.println("execute in init1");
    }
    @PostConstruct
    private void init2() {
        System.out.println("execute in init2");
    }
    
    @PreDestroy
    private void destory1() {
        System.out.println("execute destory1");
    }
    
    private void destory2() {
        System.err.println("excute destory2");
    }
    
    

}
