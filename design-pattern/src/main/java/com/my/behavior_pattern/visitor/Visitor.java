package com.my.behavior_pattern.visitor;

public class Visitor implements IVisitor {

    public void visit(CommonEmployee employee) {
        this.pringCommonEmployee(employee);
    }

    public void visit(Manage manage) {
        this.printManage(manage);
    }
    
    public String basicinfo(Employee employee) {
        String basicInfo="姓名： "+employee.getName()+"\t"
                +"性别： "+employee.getSex()+"\t"
                +"薪水： "+employee.getSalvery()+"\t";
       return basicInfo;
    }
    
    public void pringCommonEmployee(CommonEmployee employee) {
        String commonInfo="\t工作:"+employee.getJob();
        System.out.println(basicinfo(employee)+commonInfo);
    }
    
    public void  printManage(Manage manage) {
        String manageinfo="\t业绩"+manage.getPermance();
        System.out.println(basicinfo(manage)+manageinfo);
    }
    
}
