package com.my.mvc.core;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.mvc.annoation.MyController;
import com.my.mvc.annoation.MyRequestMapping;
import com.my.mvc.annoation.MyRequestParam;

@MyController
@MyRequestMapping("/test")
public class TestController {
   @ MyRequestMapping("/test1")
    public void test(HttpServletRequest request,HttpServletResponse response,@MyRequestParam("username") String username) {
     try {
        response.getWriter().write("do test1 succeed!");
    } catch (IOException e) {
       e.printStackTrace();
    }
    }
   @MyRequestMapping("/test2")
    public void test2(HttpServletRequest request,HttpServletResponse response) {
        try {
            response.getWriter().write("do test2 succeed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
