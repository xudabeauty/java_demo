package com.my.java8;

import java.lang.reflect.Field;
import java.util.Arrays;

import sun.misc.Unsafe;
/**
 * Unsafe：java直接操作内存的一个类
 * 
 * @author huixu
 * @version $Id: TestUnsafe.java, v 0.1 2018年4月13日 下午7:05:25 huixu Exp $
 */
public class TestUnsafe {
    private static int byteArrayBaseOffset;
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);;
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);
        
        byte array[]=new byte[10];
        System.out.println(Arrays.toString(array));
        
        byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        
        unsafe.putByte(array, byteArrayBaseOffset,(byte)1);
        unsafe.putByte(array, byteArrayBaseOffset+5,(byte)5);
        System.out.println(Arrays.toString(array));
    }
}
