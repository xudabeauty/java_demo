package com.my.spring.chapter08.part01;

import java.lang.reflect.Method;

import org.junit.Test;

public class ToolTest {
    @Test
    public void test() {
        Class clazz = ForumService.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            NeedTest annotation = method.getAnnotation(NeedTest.class);
            if (annotation != null) {
                if (annotation.value()) {
                    System.out.println(method.getName() + "需要测试");
                } else {
                    System.out.println(method.getName() + "不需要测试");
                }
            }
        }
    }
}
