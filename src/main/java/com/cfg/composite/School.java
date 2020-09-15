package com.cfg.composite;

/**
 * 定义组合部件
 * school接口（根）
 */
public interface School {

    public void addPart(School Company);

    public void removePart(School Company);

    public void displayPart();

    //不同部门所具有的职责
    public void action();


}
