package com.gupaoedu.vip.pattern.decorator.battercake.v1;

/**
 * Created by Tom.
 */
public class PancakeWithEggAndSausage extends PancakeWithEgg {

    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    public int getPrice() {
        return super.getPrice() + 2;
    }
}
