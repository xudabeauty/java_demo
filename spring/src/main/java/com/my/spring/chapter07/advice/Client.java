package com.my.spring.chapter07.advice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    @Test
    public void before() {
//        Waiter waiter=new NavieWaiter();
//        BeforeAdvice beforeAdvice=new GreetingBeforeAdvice();
//        
//        //spring 提供的代理工厂
//        ProxyFactory proxyFactory=new ProxyFactory();
//         
//        //设置代理目标
//        proxyFactory.setTarget(waiter);
//        
//        //为代理目标添加增强
//        proxyFactory.addAdvice(beforeAdvice);
//        
//        //生成代理实例
//        Waiter proxy=(Waiter)proxyFactory.getProxy();
//        proxy.greeting("John");
//        proxy.serverTo("Tom");
        
          ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/my/spring/chapter07/advice/applicationContext.xml");
          Waiter waiter=(Waiter)applicationContext.getBean("waiter");
          waiter.greeting("John");
    }

}
