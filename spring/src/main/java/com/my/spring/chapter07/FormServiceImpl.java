package com.my.spring.chapter07;

public class FormServiceImpl  implements FormService{

    public void removeTopic(int topicId) {
        PermanceMonitor.begin("com.my.spring.chapter05.FormServiceImpl.removeTopic");
        System.out.println("模拟删除topic记录"+topicId);
        try {
            Thread.currentThread().sleep(20);
        }catch(Exception e) {
                 throw new RuntimeException(e);        
        }
        PermanceMonitor.end();
    }

    public void createForum(Forum forum) {
        PermanceMonitor.begin("com.my.spring.chapter05.FormServiceImpl.createForum");
        System.out.println("模拟创建form记录");
        try {
            Thread.currentThread().sleep(20);
        }catch(Exception e) {
                 throw new RuntimeException(e);        
        }
        PermanceMonitor.end();
    }

}
