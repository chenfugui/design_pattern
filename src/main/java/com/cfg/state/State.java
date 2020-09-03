package com.cfg.state;

/**
 * @description: 状态抽象类
 * @author: chenfg
 * @time: 2020/8/26 9:49
 */
public abstract class State {

    public abstract void handle(Context context);
}
