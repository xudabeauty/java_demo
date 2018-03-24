package com.my.spring.chapter08.part02;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {
  @Test
    public void test() {
        Waiter target=new NavieWaiter();
        AspectJProxyFactory factory=new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetAspect.class);
        Waiter proxy=factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
