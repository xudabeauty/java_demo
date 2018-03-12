package com.my.structure_pattern.proxy.dynamic_proxy.example1;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
  private Object target;
  
  public DynamicProxy(Object obj) {
      Class class1=obj.getClass();
      //创建动态代理类的实例
      this.target=Proxy.newProxyInstance(class1.getClassLoader(), class1.getInterfaces(), new MyInvocationHandle(obj));
  }
  
  public Object exec(String methodName, Object...objects) {
      Class classes[]=new Class[objects.length];
      Object result=null;
      for(int i=0;i<objects.length;i++) {
          classes[i]=objects[i].getClass();
      }
      try {
          Method method=this.target.getClass().getMethod(methodName, classes);
           result=method.invoke(this.target, objects);
      }catch(Exception e) {
          e.printStackTrace();
      }
      return result;
  }

}
