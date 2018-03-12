package com.my.spring.chapter04.beancycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    private static void LifeCycleFactory() {
        Resource resource=new ClassPathResource("com/my/spring/chapter04/applicationContext.xml");
       BeanFactory factory=new DefaultListableBeanFactory();
       XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
       reader.loadBeanDefinitions(resource);
       ((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyBeanPostProcessor());
       ((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyInstantionAwareBeanPostProcessor());
       
       Car car1=(Car)factory.getBean("car");
       car1.introduce();
       car1.setColor("red");
       Car car2=(Car)factory.getBean("car");
       System.out.println("car1==car:"+(car1==car2));
       ((DefaultListableBeanFactory)factory).destroySingleton("car");
    }
    public static void main(String[] args) {
        LifeCycleFactory();
    }

}
