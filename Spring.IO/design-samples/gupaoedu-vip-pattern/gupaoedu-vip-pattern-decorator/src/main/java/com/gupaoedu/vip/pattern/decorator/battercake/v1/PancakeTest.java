package com.gupaoedu.vip.pattern.decorator.battercake.v1;

/**
 * Created by Tom.
 */
public class PancakeTest {

    public static void main(String[] args) {
        Pancake pancake = new Pancake();
        System.out.println(pancake.getMsg() + ",总价：" + pancake.getPrice());

        PancakeWithEgg pancakeWithEgg = new PancakeWithEgg();
        System.out.println(pancakeWithEgg.getMsg() + ",总价：" + pancakeWithEgg.getPrice());

        PancakeWithEggAndSausage pancakeWithEggAndSausage = new PancakeWithEggAndSausage();
        System.out.println(pancakeWithEggAndSausage.getMsg() + ",总价：" + pancakeWithEggAndSausage.getPrice());
    }
}
