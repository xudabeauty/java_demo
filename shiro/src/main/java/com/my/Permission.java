package com.my;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class Permission {
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
    public void test() {
       Subject subject= login("classpath:shiro-permission.ini", "zhang", "123");
      //判断拥有权限：user:create
      Assert.assertTrue(subject.isPermitted("user:create"));
      //判断拥有权限：user:update and user:delete
      Assert.assertTrue(subject.isPermittedAll("user:update","user:delete"));
      //判断没有权限：user:view
      Assert.assertFalse(subject.isPermitted("user:view"));
    }

}
