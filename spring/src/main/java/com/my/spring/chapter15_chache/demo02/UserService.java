package com.my.spring.chapter15_chache.demo02;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my.spring.chapter02.domain.User;

@Service(value="userServiceBean")
public class UserService {
    @Cacheable("users")
    public User getUserById(String userId) {
        System.out.println("real query user"+userId);
        return getFromDb(userId);
    }

    private User getFromDb(String userId) {
        System.out.println("real qyery user"+userId);
        return new User();
    }

}
