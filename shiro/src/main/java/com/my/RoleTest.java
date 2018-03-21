package com.my;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class RoleTest {
    private Subject login(String file,String username,String password) {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory();
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        subject.login(token);
        System.out.println("logined");
        return subject;
    }

    @Test
    public void hasRole() {
        Subject subject=login("classpath:shiro-role.ini", "zhang", "123");
        Assert.assertEquals(true, subject.hasRole("role1"));
        System.out.println("zhang has role1");
        Assert.assertEquals(true, subject.hasAllRoles(Arrays.asList("role1","role2")));
        System.out.println("zhang has role1 and role2");
        boolean []results=subject.hasRoles(Arrays.asList("role1","role2","role3"));
        Assert.assertEquals(true, results[0]);
        System.out.println("has role1");
        Assert.assertEquals(true, results[1]);
        System.out.println("has role2");
        Assert.assertEquals(true, results[2]);
        System.out.println("has role3");
        
        
        
        
    }
}
