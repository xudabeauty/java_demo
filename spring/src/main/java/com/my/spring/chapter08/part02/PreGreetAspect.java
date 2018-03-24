package com.my.spring.chapter08.part02;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetAspect {
    @Before("execution(* greetTo(..))")
    public void beforeGreet() {
        System.out.println("how are you");       
    }

}
