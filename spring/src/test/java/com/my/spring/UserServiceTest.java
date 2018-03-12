//package com.my.spring;
//
//import org.junit.Test;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
//
//import com.my.spring.chapter02.domain.User;
//import com.my.spring.chapter02.service.UserService;
//
//import junit.framework.Assert;
//@ContextConfiguration("classpath:/applicationContext.xml")
//public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
//
//    private UserService userService;
//    
//    public void SetUserService(UserService userService) {
//        this.userService=userService;
//    }
//    
//    @Test
//    public void hasMatchUser() {
//        boolean b1=userService.hasMatchUser("admin", "123456");
//        boolean b2=userService.hasMatchUser("admin", "111");
//        Assert.assertTrue(b1);
//        Assert.assertTrue(b2);
//    }
//    
//    @Test
//    public void findUserByUserName() {
//          User user=userService.findUserByUsername("admin");
//         Assert.assertEquals(user.getUserName(),"admin");
//    }
//}
