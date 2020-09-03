package com.cfg.state;

/**
 * @description: 状态B
 * @author: chenfg
 * @time: 2020/8/26 9:58
 */
public class StateB extends State{

    @Override
    public void handle(Context context) {
        System.out.println("current state is B .........");
        context.setState(new StateA());
    }
}