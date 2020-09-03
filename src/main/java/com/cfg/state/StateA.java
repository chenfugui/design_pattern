package com.cfg.state;

/**
 * @description: 状态A
 * @author: chenfg
 * @time: 2020/8/26 9:53
 */
public class StateA extends State {

    @Override
    public void handle(Context context) {
        System.out.println("current state is A.......");
        context.setState(new StateB());
    }
}