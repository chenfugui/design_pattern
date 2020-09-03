package com.cfg.jep;

import org.nfunk.jep.JEP;

/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/8/27 10:58
 */
public class JepDemo {

    public static void main(String[] args) {
        JEP jep = new JEP();
        // 设置公式
        String expression = "(totalAmount * 0.99 - proxy - award ) * 0.3";
        // 给变量赋值
        jep.addVariable("totalAmount",100);
        jep.addVariable("proxy",20);
        jep.addVariable("award",10);
        // 运算
        jep.parseExpression(expression);
        // 得出结果
        System.out.println(jep.getValue());

    }

}