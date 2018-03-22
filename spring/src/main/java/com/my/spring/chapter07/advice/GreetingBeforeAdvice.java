package com.my.spring.chapter07.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 前置增强
 * 
 * @author huixu
 * @version $Id: GreetingBeforeAdvice.java, v 0.1 2018年3月13日 下午7:51:28 huixu Exp $
 */
public class GreetingBeforeAdvice  implements MethodBeforeAdvice{
   /**
    * 在方法调用前执行
    * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
    */
    @Override
    public void before(Method method, Object[] args, Object object) throws Throwable {
        String clientName=(String) args[0];
        System.out.println("How are you !Mr "+clientName);
    }

}
