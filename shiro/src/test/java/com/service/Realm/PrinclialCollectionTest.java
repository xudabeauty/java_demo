package com.service.Realm;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.BaseTest;
import com.my.entity.User;

import junit.framework.Assert;

public class PrinclialCollectionTest extends BaseTest{
    @Test
    public void test() {
        login("classpath:shiro-multirealm.ini","zhang" , "123");
        Subject subject=subject();
        Object primaryPrincipal1 = subject.getPrincipal();
        PrincipalCollection princialCollection = subject.getPrincipals();
        Object primaryPrincipal2 = princialCollection.getPrimaryPrincipal();
        Assert.assertEquals(primaryPrincipal1, primaryPrincipal2);
        
      //返回 a b c
        Set<String> realmNames = princialCollection.getRealmNames();
        System.out.println(realmNames);

        //因为MyRealm1和MyRealm2返回的凭据都是zhang，所以排重了
        Set<Object> principals = princialCollection.asSet(); //asList和asSet的结果一样
        System.out.println(principals);

        //根据Realm名字获取
        Collection<User> users = princialCollection.fromRealm("c");
        System.out.println(users);
        
}
}
