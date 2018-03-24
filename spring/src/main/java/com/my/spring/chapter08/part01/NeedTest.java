package com.my.spring.chapter08.part01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//生命注解的保留期限
@Target(ElementType.METHOD)//声明注解的目标类型
public @interface NeedTest {
    boolean value() default true;
}
