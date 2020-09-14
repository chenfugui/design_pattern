package com.cfg.strategy;

/**
 * 策略模式例子
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy addStrategy = new OperationAdd();
        Strategy subtractStrategy =  new OperationSubtract();
        Strategy multiplyStrategy = new OperationMultiply();
        context.setStategy(addStrategy);
        int x = 5;
        int y = 8;
        System.out.println("x="+x+"   y="+y);
        int addValue = context.excuteStrategy(x,y);
        System.out.println("=========addValue============"+addValue);
        context.setStategy(subtractStrategy);
        int subtractValue = context.excuteStrategy(x,y);
        System.out.println("=========subtractValue============"+subtractValue);
        context.setStategy(multiplyStrategy);
        int multiplyValue = context.excuteStrategy(x,y);
        System.out.println("=========multiplyValue============"+multiplyValue);
    }
}
