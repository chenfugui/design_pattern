package com.cfg.javassist;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Person
 * @Author: chenfg
 * @Date: 2021/4/1
 * @Version:v1.0
 */
@Slf4j
public class Person {

    public void eat(String food){
        log.info("I am eating {}, very good ! ",food);
    }

    public void drink(String food){
        log.info("I am dinking {}}, very good ! ",food);
    }
}
