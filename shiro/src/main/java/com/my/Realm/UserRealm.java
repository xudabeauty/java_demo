package com.my.Realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.my.entity.User;
import com.my.service.UserService;
import com.my.service.UserServiceImpl;

public class UserRealm extends AuthorizingRealm {
    private UserService userService=new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String) principals.getPrimaryPrincipal();
         SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
         simpleAuthorizationInfo.setRoles(userService.findRoles(username));
         simpleAuthorizationInfo.setStringPermissions(userService.findPermissions(username));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();
        User user=userService.findByUsername(username);
        if(null==user) {
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
            user.getUsername(),
            user.getPassword(),
            ByteSource.Util.bytes(user.getSalt()),getName());
        return authenticationInfo;
    }
}
