package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        Pancake pancake;
        pancake = new BasePancake();
        pancake = new EggDecorator(pancake);
        pancake = new EggDecorator(pancake);
        pancake = new SausageDecorator(pancake);
        System.out.println(pancake.getMsg() + "，总价：" + pancake.getPrice());
    }
}
