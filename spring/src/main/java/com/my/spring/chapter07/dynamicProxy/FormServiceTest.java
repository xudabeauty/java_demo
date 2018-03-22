package com.my.spring.chapter07.dynamicProxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.my.spring.chapter07.FormService;
import com.my.spring.chapter07.FormServiceImpl;
import com.my.spring.chapter07.Forum;

public class FormServiceTest {
    @Test
    public void proxy() {
        FormServiceImpl formServiceImpl=new FormServiceImpl();
        PermanceHandler permanceHandler=new PermanceHandler(formServiceImpl);
        FormService target=(FormService)Proxy.newProxyInstance(formServiceImpl.getClass().getClassLoader(), formServiceImpl.getClass().getInterfaces(),permanceHandler);
        target.removeTopic(1);
        target.createForum(new Forum());
    }

}
