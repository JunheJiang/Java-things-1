package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public abstract class PancakeDecorator extends Pancake {

    private Pancake pancake;

    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    public abstract void doSomething();

    protected String getMsg() {
        return this.pancake.getMsg();
    }

    protected int getPrice() {
        return this.pancake.getPrice();
    }
}
