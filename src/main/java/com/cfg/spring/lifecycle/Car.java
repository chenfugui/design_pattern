package com.cfg.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 打印spring得bean生命周期
 */
public class Car implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    private String age;

    public Car(){
        System.out.println(" car 构造方法======");
    }

    public Car(String name,Integer age){
        System.out.println(" car 构造方法======");
    }

    public void myinit(){
        System.out.println(" myinit 方法======");
    }

    public void mydestroy(){
        System.out.println(" mydestroy 方法======");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware ===============setBeanFactory");

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware ===============setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean ===============destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean ===============afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware ===============setApplicationContext");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
