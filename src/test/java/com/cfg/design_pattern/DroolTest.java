package com.cfg.design_pattern;

import com.cfg.drool.UserInfo;
import com.drools.core.KieTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/8/28 11:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolTest {

    @Autowired
    private KieTemplate kieTemplate;

    @Before
    public void setup(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void droolTest(){

        KieSession kieSession =  kieTemplate.getKieSession("rule1.drl");
        kieSession.insert(1d);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void droolTest2(){

        KieSession kieSession =  kieTemplate.getKieSession("rule1.drl");
        Map<String,String> userMap = new HashMap<>();
        userMap.put("name","zhangsan");
        userMap.put("age","11");
        userMap.put("sex","男");
        kieSession.setGlobal("userMap",userMap);
        kieSession.insert(1d);
        kieSession.fireAllRules();
        kieSession.dispose();
        for (String s : userMap.keySet()) {
            System.out.println(s+"============="+userMap.get(s));

        }
    }

    @Test
    public void droolTest3(){

        KieSession kieSession =  kieTemplate.getKieSession("rule1.drl");
        Map<String,String> userMap = new HashMap<>();
        userMap.put("name","zhangsan");
        userMap.put("age","11");
        userMap.put("sex","男");
        kieSession.setGlobal("userMap",userMap);
        UserInfo userInfo = new UserInfo();
        userInfo.setName("lisi");
        userInfo.setAge(9);
        userInfo.setMarried(false);
        userInfo.setAddress("beijing");
        userInfo.setPhone("1234444");
        userInfo.setScore(100);
        kieSession.insert(1d);
        kieSession.insert(userInfo);
        kieSession.fireAllRules();
        kieSession.dispose();
        for (String s : userMap.keySet()) {
            System.out.println(s+"============="+userMap.get(s));

        }
        System.out.println(userInfo);
    }


}