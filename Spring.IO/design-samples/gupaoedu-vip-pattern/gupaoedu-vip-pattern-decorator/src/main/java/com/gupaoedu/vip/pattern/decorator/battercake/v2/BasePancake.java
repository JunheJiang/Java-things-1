package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class BasePancake extends Pancake {
    protected String getMsg() {
        return "煎饼";
    }

    protected int getPrice() {
        return 5;
    }
}
