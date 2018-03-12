package com.my.spring.chapter04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    @SuppressWarnings("rawtypes")
    public static Car getDefaultConst()   {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clzz=null;;
        try {
            clzz = loader.loadClass("com.my.spring.chapter04.Car");
            Constructor constructor=clzz.getDeclaredConstructor((Class[]) null);
            Car car=(Car) constructor.newInstance();
           
            Method method=clzz.getDeclaredMethod("setBrand", String.class);
            method.invoke(car, "红旗");
            
            Method setColor=clzz.getDeclaredMethod("setColor", String.class);
            setColor.invoke(car, "red");
            
            Method setMaxspeed=clzz.getDeclaredMethod("setMaxSpeed", int.class);
            setMaxspeed.invoke(car, 200);
            return car;
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
      Car car= getDefaultConst();
      car.introduce();
    }

}
