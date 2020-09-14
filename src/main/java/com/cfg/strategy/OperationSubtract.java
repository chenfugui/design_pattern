package com.cfg.strategy;

/**
 * 求和算法
 */
public class OperationSubtract implements Strategy{

    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}
