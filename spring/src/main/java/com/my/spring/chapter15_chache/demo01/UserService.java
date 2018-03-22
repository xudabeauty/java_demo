package com.my.spring.chapter15_chache.demo01;

import com.my.spring.chapter02.domain.User;

public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<>();
    }

    public User getUserById(String userId) {
        User result = cacheManager.get(userId);
        if (result != null) {
            System.out.println("get from cache...." + userId);
            return result;
        } else {
            result = getFromDb(userId);
            cacheManager.addOrUpdateCache(userId, result);
            return result;
        }
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDb(String userId) {
        System.out.println("real querying db....." + userId);
        return new User();
    }

}
