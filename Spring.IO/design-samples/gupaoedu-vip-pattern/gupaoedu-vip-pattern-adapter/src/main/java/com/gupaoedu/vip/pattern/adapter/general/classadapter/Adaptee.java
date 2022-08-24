package com.gupaoedu.vip.pattern.adapter.general.classadapter;

/**
 * Created by Tom.
 */
public class Adaptee implements ITarget{

    public int specificRequest() {
        return 220;
    }

    public int request() {
        return 0;
    }
}
