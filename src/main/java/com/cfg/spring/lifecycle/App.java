package com.cfg.spring.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("/bean.xml");
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        definitionReader.loadBeanDefinitions(resource);

        //添加两个后置处理器（容器级）
        listableBeanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        //需要注意postProcessAfterInstantiation方法返回值，true注入属性，false跳过注入
        listableBeanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car = (Car) listableBeanFactory.getBean("car");
        System.out.println("bean=====car========"+car);
        listableBeanFactory.destroySingletons();
        System.out.println("bean=====car========"+car);

    }
}
