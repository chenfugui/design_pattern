package com.cfg.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 合成部件 （有自己的孩子）
 * 具体的学校
 */
public class ConcreteSchool  implements School{

    private List<School> partList = new ArrayList<>();

    private String name;

    public ConcreteSchool(String name){
        this.name = name;
    }


    @Override
    public void addPart(School company) {
        this.partList.add(company);
    }

    @Override
    public void removePart(School company) {
        this.partList.remove(company);

    }

    @Override
    public void displayPart() {
        for (School school : this.partList) {
            school.displayPart();
        }
    }

    //每一个部门还可以做自己的事
    @Override
    public void action() {
        for (School school : this.partList) {
            school.action();
        }
    }
}
