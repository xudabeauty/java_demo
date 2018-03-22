package com.my.spring.chapter07.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.my.spring.chapter07.PermanceMonitor;

public class PermanceHandler  implements InvocationHandler{
    private Object target;

    public PermanceHandler(Object obj) {
        this.target=obj;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PermanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object object=method.invoke(target, args);
        PermanceMonitor.end();
        return object;
    }

}
