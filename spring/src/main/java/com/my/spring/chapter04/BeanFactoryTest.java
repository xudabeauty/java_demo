package com.my.spring.chapter04;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {
    @Test
    public void getBean() throws IOException {
        //获取bean配置容器
        try {
//            ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//            Resource resource=resolver.getResource("classpath:com/my.spring/chapter04/applicationContext.xml");
//            System.out.println(resource.getURL());
//            DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
//            //通过resource 正在spring配置信息并启动ioc容器
//            XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
//            reader.loadBeanDefinitions(resource);
//            System.out.println("init Bean");
//            Car car=factory.getBean("car1",Car.class);
//            System.out.println("car bean has been use");
//            car.introduce();
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/my/spring/chapter04/applicationContext.xml");
             Car car=applicationContext.getBean("car",Car.class);
            assertNotNull(car);    
            car.introduce();
        }catch(Exception e) {
            e.printStackTrace();
        }
   
    }

}
