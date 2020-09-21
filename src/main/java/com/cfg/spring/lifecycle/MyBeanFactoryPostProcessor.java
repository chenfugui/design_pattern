package com.cfg.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 容器级别的后置处理器
 * BeanFactoryPostProcessor后置处理器
 * BeanFactoryPostProcessor是实现spring容器功能扩展的重要接口，例如修改BeanDefinition，实现bean动态代理等。
 * 很多框架都是通过此接口实现对spring容器的扩展，例如mybatis与spring集成时，只定义了mapper接口，无实现类，
 * 接口也没有添加@Component等注解，但spring却可以完成自动注入，也是基于BeanFactoryPostProcessor接口来实现的。
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 前文说到BeanDefinition在实例化之后，被放入BeanDefinition map中，
     * 而BeanFactoryPostProcessor就是在BeanDefinition map初始化完成后，Bean实例构造方法执行之前执行的。
     *
     * BeanFactoryPostProcessor的主要作用是，开发者可以修改容器中所有BeanDefinition的信息，
     * 接口方法的入参是ConfigurrableListableBeanFactory，使用该参数，
     * 可以获取到相关bean的定义信息。但 绝对不允许进行bean实例化相关的操作！
     * 因为中spring加载机制中，BeanFactoryPostProcessor是在Bean构造方法之前执行的，
     * 如果这个时候提前实例化bean，很可能会一连串的问题。
     *
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor =================== postProcessBeanFactory");
    }
}
