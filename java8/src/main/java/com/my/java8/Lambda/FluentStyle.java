package com.my.java8.Lambda;

/**
 * fluent 风格
 * 可以使代码更短跟容易编写
 * 
 * @author huixu
 * @version $Id: FluentStyle.java, v 0.1 2018年4月16日 下午4:28:21 huixu Exp $
 */
public class FluentStyle {
    public static void main(String[] args) {
        Student student = Student.build().setName("xuhui").setAddress("shanghai");
        System.out.println(student);
    }
}

class Student {
    private Integer id;
    private String  name;
    private String  address;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static Student build() {
        return new Student();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
    }

}
