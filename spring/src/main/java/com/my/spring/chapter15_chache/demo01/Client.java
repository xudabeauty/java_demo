package com.my.spring.chapter15_chache.demo01;

public class Client {
    public static void main(String[] args) {
         UserService userService=new UserService();
         userService.getUserById("01");
         userService.getUserById("01");
         userService.reload();
         System.out.println("after reload");
         userService.getUserById("02");
         
         userService.getUserById("02");
    }

}
