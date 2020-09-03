package com.cfg.state;

/**
 * @description: 环境类
 * @author: chenfg
 * @time: 2020/8/26 9:49
 */
public class Context {

    private State state;

    //定义环境初始化状态
    public Context(){
        this.state = new StateA();
    }

    //获取状态
    public State getState() {
        return state;
    }

    //设置状态
    public void setState(State state) {
        this.state = state;
    }

    //处理请求
    public void handle(){
        this.state.handle(this);
    }
}