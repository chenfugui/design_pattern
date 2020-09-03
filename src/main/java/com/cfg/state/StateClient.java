package com.cfg.state;

/**
 * @description: 状态模式使用客户端
 * @author: chenfg
 * @time: 2020/8/26 10:02
 */
public class StateClient {

    public static void main(String[] args) {
        //创建环境类
        Context context = new Context();
        //处理请求
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }

}