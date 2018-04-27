package com.my.java8.Lambda;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/*
 * Lambda 是一个匿名函数
 * 语法：
 * 1、无参。无返回值
 * 2、需要一个参数
 */
public class TestLambda {
    public TestLambda(Integer id) {
    }
    public static void main(String[] args) throws InterruptedException {
        //原来的匿名函数的实现方式
        Runnable r1=new Runnable() {
            public void run() {
                System.out.println("pre way");
            }
        };
        TreeSet<String> set1=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1,String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        //1、无参无返回值
        Runnable r2=()->System.out.println("new way");
        //2、需要一个参数
        Consumer<String>consumer=(arg)->System.out.println(arg);
        //3、需要一个参数，参数小括号可以省略
        Consumer<String> consumer2=arg->System.out.println(arg);
        //4、两个参数并且有返回值
        TreeSet<String>set2=new TreeSet<>((o1,o2)->Integer.compare(o1.length(), o2.length()));
        //5、lambda只有一条语句是，return 和大括号可以省略
        BinaryOperator<Long>binaryOperator=(x,y)->x+y;
        //6、参数数据类型可以省略，编译器可以推断得出，“类型推断”
    }

}
