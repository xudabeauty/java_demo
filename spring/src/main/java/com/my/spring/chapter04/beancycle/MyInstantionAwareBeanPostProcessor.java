package com.my.spring.chapter04.beancycle;
import java.beans.PropertyDescriptor;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantionAwareBeanPostProcessor  extends InstantiationAwareBeanPostProcessorAdapter{
    //接口方法在实例化bean时候调用
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName) {
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstiantion");
        }
        return null;
    }
    
    
    public boolean postProcessAfterInstantiation(Class beanClass,String beanName) {
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstiantion");
        }
        return true;
    }
    //接口放方法，在设置某个属性时调用
    public  PropertyValues postProcessPropertyValues(PropertyValues pvs,PropertyDescriptor pds,Object object,String beanName) {
        if("car".equals(beanName)) {
            System.err.println("Instantiation BeanPostprocessor.postProcessPropertyValues");
        }
        return pvs;
    }

}
