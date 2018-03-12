package com.my.spring.chapter01;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 空指针终结者
 * 
 * @author huixu
 * @version $Id: DefaultUserService.java, v 0.1 2018年3月11日 下午1:24:35 huixu Exp $
 */
@Service
public class DefaultUserService {

    @Autowired
    private Optional<UserDao> userDao;//userDao可能为空，autowired注解required=false或使用Optional避免NullPointerException
    public User findUserByUserName(String username) {
        if(userDao.isPresent()) {
            UserDao.get().findUserByUserName(username);
        }
        return null;
    }
    
   //Optional在springMVC框架中使用，表示请求参数是可选的
   // @RequestMapping("/user")
//    public User getUser(String id,Optional<String>username) {
//        return null; 
//    }
}
