package com.my.handwrite.mvc.servlet;

import java.net.URL;

public class TestResource {
    public void print() {
        URL resource = this.getClass().getClassLoader().getResource("/com");
        System.out.println(resource);
    }

}
