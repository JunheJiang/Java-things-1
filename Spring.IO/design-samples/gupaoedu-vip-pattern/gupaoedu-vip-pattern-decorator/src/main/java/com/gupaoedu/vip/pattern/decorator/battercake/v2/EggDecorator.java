package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class EggDecorator extends PancakeDecorator {
    public EggDecorator(Pancake pancake) {
        super(pancake);
    }

    public void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
