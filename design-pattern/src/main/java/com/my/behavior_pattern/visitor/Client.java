package com.my.behavior_pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Visitor visitor=new Visitor();
        List<Employee> list=getMock();
        for(Employee e: list) {
            e.accept(visitor);
        }
        
    }
    
    public static List<Employee> getMock(){
        List<Employee> list=new ArrayList<Employee>();
        CommonEmployee e1=new CommonEmployee();
        e1.setName("张三");;
        e1.setSex(Employee.MALE);
        e1.setSalvery("100");
        e1.setJob("程序员");
        
        list.add(e1);
        e1=new CommonEmployee();
        e1.setName("李四");;
        e1.setSex(Employee.FEMAL);
        e1.setSalvery("200");
        e1.setJob("美工");
        list.add(e1);
        
        Manage manage=new Manage();
        manage.setName("王五");
        manage.setSex(Employee.MALE);
        manage.setSalvery("300");
        manage.setPermance("评价得到普通员工绩效");
        list.add(manage);
        return list;
    }
}
