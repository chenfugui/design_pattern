package com.cfg.composite;
/**
 * 定义叶子（没有子节点）
 */
public class SecurityDepartment implements School {

    private String name;

    public SecurityDepartment(String name){
        this.name = name;
    }

    @Override
    public void addPart(School Company) {

    }

    @Override
    public void removePart(School Company) {

    }

    @Override
    public void displayPart() {

    }

    @Override
    public void action() {
        System.out.println("我是"+name+"负责学校的安全部门");
    }
}
