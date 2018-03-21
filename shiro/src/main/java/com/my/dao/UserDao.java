package com.my.dao;

import java.util.Set;

import com.my.entity.User;

public interface UserDao {
    
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userid);
    public void correlationRoles(Long userId,Long...roleIds);
    public void unCorelationRoles(Long userid,Long...roleIds);
    
    User findOne(Long userId);
    User findByUsername(String username);
    Set<String> findRoles(String username);
    Set<String>findPermissions(String username);
}
