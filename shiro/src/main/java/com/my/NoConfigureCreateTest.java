package com.my;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;

import junit.framework.Assert;

public class NoConfigureCreateTest {

    public void test() {
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        ModularRealmAuthenticator authenticator=new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);
        
        ModularRealmAuthorizer authorizer=new ModularRealmAuthorizer();
        authorizer.setPermissionResolver(new WildcardPermissionResolver());
        securityManager.setAuthorizer(authorizer);
        
        DruidDataSource dSource=new DruidDataSource();
        dSource.setDriverClassName("com.my.sql.jdbc.Driver");
        dSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dSource.setUsername("root");
        dSource.setPassword("xh123456");
        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        securityManager.setRealms(Arrays.asList((Realm) jdbcRealm));
        SecurityUtils.setSecurityManager(securityManager);
        
        org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
        subject.login(token);
        Assert.assertTrue(subject.isAuthenticated());
    }
    @Test
    public void testLoop() {
        for (int i = 0; i < 10; i++) {
            if(i==5) {
                break;
            }
            System.out.println("number"+i);
        }
    }
    

}
