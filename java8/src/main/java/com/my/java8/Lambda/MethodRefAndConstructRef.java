package com.my.java8.Lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/*
 * 方法引用
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *使用::操作符将方法名和对象或类的名字分隔开
 *分为三种情况
 *对象::实例方法
 *类::静态方法
 *类::实例方法
 *
 *构造器引用
 *ClassName::new
 *
 *数组引用
 *type[]::new
 */
public class MethodRefAndConstructRef {
    public static void main(String[] args) {
        //方法引用
        BinaryOperator<Double> bOperator=(x,y)->Math.pow(x, y);
        BinaryOperator<Double>binaryOperator2=Math::pow;
        Double apply = binaryOperator2.apply(1.2, 2.3);
        
        //构造器应用
        Function<Integer, TestLambda> function=TestLambda::new;
        
        //数组引用
        Function<Integer, Integer[]> function2=Integer []::new;
    }

}
