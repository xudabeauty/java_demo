package com.my.java8.Lambda;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * 流：数据渠道，用于操作数据源(集合，数组)所生成的序列，集合基于数据，流基于计算
 * 1、Stream 本身不存储元素
 * 2、stream不会改变源对象，他们会返回一个出游结果的新的Stream
 * 3、操作是延迟执行的，得到需要结果的时候才执行
 * 
 * Stream的操作三个步骤
 * 创建，中间操作，终止操作
 * 
 * 获取流的两个方法
 * default Stream<R> stream;返回顺序流
 * default Stream<E>parallelStream;返回一个并行流
 * 
 *  中间操作：
 *  filter,distinct,limit,skip,map,mapToDouble,maoToInt,mapToLOng,flatMap,sorted,sorted(Comparatpr com)
 *  终止操作
 *  allMatch,anyMatch,noneMatch,findFirst,findAny,count,nax,min.forEach,reduce,reduce,collect(Collector c)
 *  
 *  
 */
public class TestStreamApi {
    public static void main(String[] args) {
        //创建流
        //数组创建流
       Stream<Integer> stream= Arrays.stream(new Integer[] {1,2,3});
       //由值创建流
       Stream<Integer> stream2 = Stream.of(new Integer[] {1,2,3});
       //有函数创建流:创建无限流
       Stream<Integer> stream3 = Stream.iterate(1, item->item+1);//迭代方式
       Stream<Double> stream4 = Stream.generate(new Supplier<Double>() {//生成方式
        @Override
        public Double get() {
            return Math.random();
        }
    });
       
      
      
       
       
       
       
       
    }

}
