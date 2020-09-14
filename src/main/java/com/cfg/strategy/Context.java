package com.cfg.strategy;

/**
 * 策略环境类
 */
public class Context {

    private Strategy stategy;

    public int excuteStrategy(int x,int y){
        return this.stategy.doOperation(x,y);
    }

    public Strategy getStategy() {
        return stategy;
    }

    public void setStategy(Strategy stategy) {
        this.stategy = stategy;
    }
}
