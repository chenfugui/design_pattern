package com.cfg.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 如果说BeanFactoryPostProcessor是对BeanDefinition的扩展处理，
 * 那么BeanPostProcessor更多的是对Bean的扩展处理。
 * BeanPostProcessor的触发时间是在 Bean的实例化之后（执行了构造方法，并且对属性进行了赋值），
 * 在Bean的init方法执行之前（@PostConstruct注解方法、InitializeBean接口方法、@Bean中initMethod方法）。
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor=====================postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor=====================postProcessAfterInitialization");
        return bean;
    }
}
