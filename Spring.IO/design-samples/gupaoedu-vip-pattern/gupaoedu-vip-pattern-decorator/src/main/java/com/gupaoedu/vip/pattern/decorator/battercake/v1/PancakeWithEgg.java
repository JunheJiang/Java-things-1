package com.gupaoedu.vip.pattern.decorator.battercake.v1;

/**
 * Created by Tom.
 */
public class PancakeWithEgg extends Pancake {

    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋蛋";
    }

    public int getPrice() {
        return super.getPrice() + 1;
    }

}
