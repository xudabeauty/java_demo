package com.my;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm{

    public String getName() {
        return "MyRealm1";
    }

    public boolean supports(AuthenticationToken token) {
        //仅支持username password 认证方式
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String) token.getPrincipal();
        String password=new String((char[])token.getCredentials());
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        //如果身份认证成功，返回一个AuthenticationIonfo实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }

}
