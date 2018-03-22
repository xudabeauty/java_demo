package com.my.spring.chapter07;

public class Client {
    public static void main(String[] args) {
        FormService formService=new FormServiceImpl();
        formService.removeTopic(1);
        formService.createForum(new Forum());
    }

}
