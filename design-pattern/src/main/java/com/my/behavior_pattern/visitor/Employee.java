package com.my.behavior_pattern.visitor;

public abstract class Employee {
   public static final  String MALE="女";
   public static final String FEMAL="男";
   private String name;
   private String sex;
   private String salvery;
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getSex() {
    return sex;
}
public void setSex(String sex) {
    this.sex = sex;
}
public String getSalvery() {
    return salvery;
}
public void setSalvery(String salvery) {
    this.salvery = salvery;
}
public abstract void accept(IVisitor visotor);
}
