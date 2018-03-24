package com.my.spring.chapter11;
/**
 * 实现一个加单的threadLocal思路
 * 
 * @author huixu
 * @version $Id: SimpleThreadLocal.java, v 0.1 2018年3月24日 下午5:17:12 huixu Exp $
 */

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {
    private Map valueMap=Collections.synchronizedMap(new HashMap<>());//同步valueMap；
    
    public void set(Object newValue) {
        valueMap.put(Thread.currentThread(), newValue);//键为线程对象，值为线程的变量副本
    }
    public Object get() {
        Thread thread=Thread.currentThread();
        Object object=valueMap.get(thread);
        if(object==null||!valueMap.containsKey(object)) {
            object=InitialValue();
        }
        valueMap.put(thread, object);
        return object;
    }
    public Object InitialValue() {
        return nullValue();
    }

}
