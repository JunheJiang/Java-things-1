package com.gupaoedu.vip.pattern.adapter.demo.power.classadapter;

/**
 * Created by Tom.
 * 适配AC220V输出DC5f接口
 * 单一适配
 *
 * 类适配
 * 接口适配
 * 对象适配
 */
public class PowerAdapter extends AC220 implements DC5 {
    public int output5V() {
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}
