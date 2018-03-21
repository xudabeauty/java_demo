package com.my;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class PasswordTest extends BaseTest {
    @Test
    public void testPasswordServiceWithMyRealm() {
        login("classpath:shiro-passwordservice.ini", "wu", "123");
    }
    public void testGeneratePassword() {
        String algorithmName="md5";
        String username="liu";
        String password="123";
        String salt1=username;
        String salt2=new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations=2;
        SimpleHash hash=new SimpleHash(algorithmName,password,salt1+salt2,hashIterations);
        String encodedPassword=hash.toHex();
        System.out.println(salt2);
        System.out.println(encodedPassword);
        
    }
    
}
