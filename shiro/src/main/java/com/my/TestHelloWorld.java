package com.my;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class TestHelloWorld {
    @Test
    public void test() {
        //获取securityManager工厂
      Factory<SecurityManager>factory= new IniSecurityManagerFactory("classpath:shiro.ini");
     SecurityManager securityManager=  factory.getInstance();
     //将securityManager与SecurityUtils绑定     
     SecurityUtils.setSecurityManager(securityManager);
     //得到subject
     Subject subject=SecurityUtils.getSubject();
     //创建用户身份凭证
     UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
     try {
         subject.login(token);
     }catch (Exception e) {
        // TODO: handle exception
    }
     Assert.assertEquals(true, subject.isAuthenticated());
     //退出
     subject.logout();
    }
    @Test
    public void testRealm() {
      //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
    
    @Test
    public void testCostomRelm() {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        subject.login(token);
        Assert.assertEquals(true, subject.isAuthenticated());
        System.out.println("lgoined");
        subject.logout();
        
        
    }

}
