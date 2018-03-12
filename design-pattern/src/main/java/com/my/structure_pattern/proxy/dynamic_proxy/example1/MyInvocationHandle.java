package com.my.structure_pattern.proxy.dynamic_proxy.example1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler{
    private Object obj;
    public MyInvocationHandle(Object _obj) {
        this.obj=_obj;
    }
    public void before() {
        System.out.println("before method");
    }

    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        before();
        Object result=null;
        result =method.invoke(this.obj, args);
        after();
        return result;
    }
    public void after() {
        System.out.println("after method");
    }
}
