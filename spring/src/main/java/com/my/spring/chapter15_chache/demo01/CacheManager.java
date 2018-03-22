package com.my.spring.chapter15_chache.demo01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager <T> {
    private Map<String, T> cache =new ConcurrentHashMap<>();
    public T get(Object key) {
        return cache.get(key);
    }
    
    public void addOrUpdateCache(String key,T value) {
        cache.put(key, value);
    }
    //根据key删除缓存中的一天条记录
    public void evictCache(String key) {
        if(cache.containsKey(key)) {
           cache.remove(key);
        }
    }
    //清空缓存
 public void evictCache() {
     cache.clear();
 }

}
