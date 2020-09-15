package com.cfg.composite;

/**
 * 组合模式例子
 */
public class CompositeDemo {

    public static void main(String[] args) {
        //总校部门
        School rootSchool = new ConcreteSchool("总校");
        rootSchool.addPart(new InternetDepartment("总校网络部"));
        rootSchool.addPart(new SecurityDepartment("总校安全部"));
        //分校部门
        School bjBranchSchool = new ConcreteSchool("北京分校");
        bjBranchSchool.addPart(new InternetDepartment("北京分校网络部"));
        bjBranchSchool.addPart(new SecurityDepartment("北京分校安全部"));
        //添加到根
        rootSchool.addPart(bjBranchSchool);

        rootSchool.displayPart();
        rootSchool.action();

    }
}
