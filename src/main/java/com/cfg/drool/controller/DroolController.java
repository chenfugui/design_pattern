package com.cfg.drool.controller;

import com.cfg.drool.UserInfo;
import com.drools.core.KieTemplate;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/8/28 15:31
 */
@RestController
public class DroolController {

    @Autowired
    private KieTemplate kieTemplate;

    @GetMapping("/drool")
    public Object testRule() {
        KieSession kieSession = kieTemplate.getKieSession("rule1.drl");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", "zhangsan");
        userMap.put("age", "11");
        userMap.put("sex", "男");
        kieSession.setGlobal("userMap", userMap);
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
            System.out.println(s + "=============" + userMap.get(s));

        }
        System.out.println(userInfo);
        return userInfo;
    }

}