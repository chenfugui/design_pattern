package com.cfg.strategy;

/**
 * 策略接口
 */
public interface Strategy {

    /**
     * 策略执行方法
     * @param a
     * @param b
     * @return
     */
    public int doOperation(int a,int b);
}
