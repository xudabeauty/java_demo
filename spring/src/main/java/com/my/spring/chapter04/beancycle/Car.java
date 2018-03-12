package com.my.spring.chapter04.beancycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;
    
    public Car() {
        System.out.println("调用Car 构造函数");
    }
    //beanFactoruAware 接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory=beanFactory;
    }

    //调用DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用disposableBean.destroy()");
    }

    //InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPrppertesSet()");
    }

    //BeanNameAware接口方法
    public void setBeanName(String arg0) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName=arg0;
    }
    
    public void setBrand(String brand) {
        System.out.println("调用setBrand函数");
        this.brand=brand;
    }
    
    public void introduce() {
        System.out.println("brand:"+brand+";color:"+color+";maxSpeed"+maxSpeed);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public String getBrand() {
        return brand;
    }
    //通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed=200;
    }
    
    //通过<bean>的destory-method属性指定的销毁放大
    public void myDestory() {
        System.out.println("调用destory-method所指定的myDestory()");
        
    }

    



}
