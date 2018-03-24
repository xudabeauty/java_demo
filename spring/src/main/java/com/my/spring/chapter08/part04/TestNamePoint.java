package com.my.spring.chapter08.part04;

import org.aspectj.lang.annotation.Pointcut;
/**
 * 切点命名
 * 
 * @author huixu
 * @version $Id: TestNamePoint.java, v 0.1 2018年3月24日 下午2:57:23 huixu Exp $
 */
public class TestNamePoint {
    @Pointcut("with(com.my.*)")
    private void inPackage() {//private表明该切点只能在本切面类中使用
    }
    @Pointcut("execution(* greetTo(..))")
    protected void greetTo() {//protected报名该切点只能在当前包中的切面类，子切面类中使用
    }
    
    @Pointcut("inPackage() and greetTo")//复合切点
    public void inPackgGreetTo() {//可视域为public
    }

}
