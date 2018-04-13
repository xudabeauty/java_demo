package com.my.spring.chapter08.part03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    @After("@annotation(com.my.spring.chapter08.part03.SeondNeedTest)")
    public void needTestFun() {
        System.out.println("needTestFun() executed");
        
    }

}
