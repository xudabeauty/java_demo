package com.my.spring.chapter04.beancycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("调用BeanPostProcessor.postProcesseBeforeInitialization()");
                car.setColor("red");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")) {
            Car car=(Car)bean;
            if(car.getMaxSpeed()>=50) {
                System.out.println("调用BeanPostprocessor,postProcessAfterInitialization");
                car.setMaxSpeed(240);
            }
        }
        return bean;
    }

}
