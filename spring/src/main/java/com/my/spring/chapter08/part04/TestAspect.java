package com.my.spring.chapter08.part04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
/**
 * 符合切面
 * 
 * @author huixu
 * @version $Id: TestAspect.java, v 0.1 2018年3月24日 下午2:43:03 huixu Exp $
 */
import org.aspectj.lang.annotation.Before;
@Aspect
public class TestAspect {
    @After("within(com.my.chapter08*)&&execution(* greetTo(..))")
    public void greetToFun() {
        System.out.println("greetoFun() executeion");
    }
    @Before( " !target(com.my.chapter08)&&execution(* serverTo(..))")
    public void notServerInNavieWatier() {
        System.out.println("... notserverInvieWaiter sexecuted...");
    }
    @AfterReturning("target(com.my.chapter08.part02.Waiter)||target(com.myChapter08.part02.Seller)")
    public void waiterOrSeller() {
        System.out.println("...watiter Or Seller exectuted...");
    }
    @Before("TestNamePoint.inPkgGreeetTo()")
    public void pkggGreet() {
        System.out.println("int pkggGreet exected");
    }
    
    @Before("!target(com.my.chapter08.part02.NavieWaiter)&&TestNamePoiny. inPkgGreetTo")
    public void pkgGreetNotNavieWaiter() {
        System.out.println("pkgGreetNotNavieWaiter executed");
        
    }

}
