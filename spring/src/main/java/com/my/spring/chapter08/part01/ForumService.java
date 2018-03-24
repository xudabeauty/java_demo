package com.my.spring.chapter08.part01;

/**
 * 使用注解
 * 
 * @author huixu
 * @version $Id: ForumService.java, v 0.1 2018年3月23日 下午8:15:34 huixu Exp $
 */
public class ForumService {
    @NeedTest(value=true)
    public void deleteForm(int formId) {
        System.out.println("删除论坛id"+formId);
    }
    @NeedTest(value=false)
    public void deleteTopic(int topicId) {
        System.out.println("删除topic Id"+topicId);
    }
    
    

}
