package com.my.java8.Lambda;

/*
 * 只包含一个抽象方法的接口，成为函数式接口
 * 可以通过lambda表达式创建该接口的对象
 * 可以在任意函数式接口上使用@FunctionalInterface注解
 *内置四大核心函数式接口
 *Consumer<T>   void accept(T t)
 *Supplier<T>   void T get()
 *Function<T,R> R apply(T t)
 *Predicate<T>    boolean test(T t)
 *其他接口
 *BiFunction<T,U,R> R apply(T t,U u)
 *UnaryOperator<T> T apply(T t)  Function的子接口
 *BinaryOperator<T>  T apply(T t1,T  t2)   BiFunction子接口
 *BiConsumer<T,U>  void accept(T t,U u)
 *ToIntFunction<T>        
 *ToLongFunciton<T>
 *toDoubleFunction<T>
 *IntFunction<T>
 *LongFunction<T>
 *DoubleFunction<T>
 */
public class TestFunctionalInterface {
    public static void main(String[] args) {
         String upperString = toUpperString((str)->str.toUpperCase(), "abcd");
         System.out.println(upperString);
    }
    public static String toUpperString(MyNumber<String> mf,String string) {
        return mf.getValue(string);
    }

}
