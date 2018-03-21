package com.service.Realm;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.junit.Test;

import com.BaseTest;

import junit.framework.Assert;

public class UserRealmTest  extends BaseTest{
    @Test
    public void testLoginSuccess() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isAuthenticated());
    }
    
    @Test(expected=UnknownAccountException.class)
    public void testLoginFailWithKnownUsername() {
        login("classpath:shiro,ini", u1.getUsername()+"1", password);
    }
    @Test(expected = IncorrectCredentialsException.class)
    public void testLoginFailWithErrorPassowrd() {
        login("classpath:shiro.ini", u1.getUsername(), password + "1");
    }

    @Test(expected = LockedAccountException.class)
    public void testLoginFailWithLocked() {
        login("classpath:shiro.ini", u4.getUsername(), password + "1");
    }
    
    @Test(expected=ExcessiveAttemptsException.class)
    public void testLoginFailWithLinitRetryCount() {
        for(int i=0;i<=5;i++) {
            try {
                login("classpath:shiro.ini", u3.getUsername(), password);
            }catch(Exception e) {
                
            }
            login("classpath:shiro.ini", u3.getUsername(), password);
        }
        
    }
    
    @Test
    public void testNoRole() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().hasRole("admin"));
    }

    @Test
    public void testHasPermission() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
    }

    @Test
    public void testNoPermission() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().isPermitted("user:create"));
    }
    

}
