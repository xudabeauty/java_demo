package com.my.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.my.entity.User;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
    
    private String algorithmName="md5";
    private final int hashInterations=2;
    
    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());

     String hex = new SimpleHash(algorithmName,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),hashInterations).toHex();
        user.setPassword(hex);
    }

}
