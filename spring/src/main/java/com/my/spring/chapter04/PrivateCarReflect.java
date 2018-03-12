package com.my.spring.chapter04;

import java.lang.reflect.Constructor;
import  java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    public static void main(String[] args) {
        try {
            ClassLoader loader=Thread.currentThread().getContextClassLoader();
            Class clazz=loader.loadClass("com.my.spring.chapter04.PrivateCar");
            Constructor constructor=clazz.getDeclaredConstructor((Class[])null);
            
            PrivateCar car=(PrivateCar)constructor.newInstance();
            
           Field colorfiled=clazz.getDeclaredField("color");
           colorfiled.setAccessible(true);
           colorfiled.set(car, "red");
           
           Method driveMethod=clazz.getDeclaredMethod("drive",(Class[])null);
           driveMethod.setAccessible(true);
           driveMethod.invoke(car, (Object[])null);
        }catch (Exception e) {
            // TODO: handle exception
        }

        
        
    }

}
