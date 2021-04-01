package com.cfg.javassist;

/**
 * @Description: Student
 * @Author: chenfg
 * @Date: 2021/4/1
 * @Version:v1.0
 */
public class Student {

    private String name;

    private Double height;

    private Integer age;

    public Student(){

    }

    public Student(String name,Double height,Integer age){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
