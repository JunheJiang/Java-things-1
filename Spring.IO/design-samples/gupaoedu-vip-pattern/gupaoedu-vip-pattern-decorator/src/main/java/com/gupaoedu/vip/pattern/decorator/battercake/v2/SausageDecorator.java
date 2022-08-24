package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class SausageDecorator extends PancakeDecorator {
    public SausageDecorator(Pancake pancake) {
        super(pancake);
    }

    public void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
