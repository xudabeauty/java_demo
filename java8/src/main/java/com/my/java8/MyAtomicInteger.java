package com.my.java8;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import sun.misc.Unsafe;
/**
 * Unsafe使用的两种方式：
 * 1、Unsafe unsafe=Unsafe.getUnsafe(); 工厂方式获得，因为在unsafe的源码中有对安全性的检查，这种方式会抛出出SecurityException
 * 2、通过反射:Unsafe.java中声明了一个实例域("theUnsafe")
 * 
 * @author huixu
 * @version $Id: MyAtomicInteger.java, v 0.1 2018年4月13日 下午6:16:40 huixu Exp $
 */
public class MyAtomicInteger extends Number implements Serializable  {
    private static final long serialVersionUID = 1L;
    private static Unsafe unsafe =null;
    private static  final long valueOffSet;
    static {
        try {
            Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe=(Unsafe) declaredField.get(Unsafe.class);
            //获取当前对象field "value"的内存地址
            valueOffSet = unsafe.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception e) {
           throw new Error(e);
        }
    }
    private volatile int value;
    public MyAtomicInteger(int initialValue) {
        this.value=initialValue;
    }
    public MyAtomicInteger() {
    }
    public final int get() {
        return value;
    }
    
    public final void set(int newValue) {
        value=newValue;
    }
    
    public final void lazySet(int newValue) {
        unsafe.putOrderedInt(this, valueOffSet, newValue);
    }
    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffSet, newValue);
    }
    
    public final boolean compareAndSet(int expect,int update) {
        return unsafe.compareAndSwapInt(this, valueOffSet, expect, update);
    }
    
    public final boolean weakCompareAndSet(int expect,int update) {
        return unsafe.compareAndSwapInt(this, valueOffSet, expect, update);
    }
    
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffSet, 1);
    }
    public final int getAndDecrement() {
        return unsafe.getAndAddInt(this, valueOffSet, -1);
    }
    public final int getAndAdd(int delata) {
        return unsafe.getAndAddInt(this, valueOffSet, delata);
    }
    public final int incrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffSet, 1)+1;
    }
    public final int decrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffSet, -1)-1;
    }
    public final int addAndGet(int delta) {
        return unsafe.getAndAddInt(this, valueOffSet, delta)+delta;
    }
    
    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int prev,next;
        do {
            prev=get();
            next=updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));
        return prev;
    }
    
    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int prev,next;
        do {
            prev=get();
            next=updateFunction.applyAsInt(prev);
        } while (!compareAndSet(prev, next));
        return next;
    }
    
    public final int etAddAccumulate(int x,IntBinaryOperator accumatorFunction) {
        int pre,next;
        do {
            pre=get();
            next=accumatorFunction.applyAsInt(pre, x);
            
        } while (!compareAndSet(pre, next));
        return pre;
    }
    public final int accumulateAndGet(int x,
                                      IntBinaryOperator accumulatorFunction) {
        int prev, next;
        do {
            prev = get();
            next = accumulatorFunction.applyAsInt(prev, x);
        } while (!compareAndSet(prev, next));
        return next;
    }
    @Override
    public String toString() {
        return Integer.toString(get());
    }
    @Override
    public int intValue() {
        return get();
    }

    @Override
    public long longValue() {
        return (long)get();
    }

    @Override
    public float floatValue() {
        return (float)get();
    }

    @Override
    public double doubleValue() {
        return (double)get();
    }

}
