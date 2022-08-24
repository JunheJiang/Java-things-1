package com.gupaoedu.vip.design.principle.simpleresponsibility.simple;

/**
 * Created by Tom on 2020/2/16.
 * 单一职责原则：Simple-Responsibility Principle, SRP
 * 一个Class\interface\Method 只负责一项职责
 * <p>
 * 　　不要存在大于一个导致功能变更的原因，降低变更引起的风
 */
public class Course {
    public void study(String courseName) {
        if ("直播课".equals(courseName)) {
            System.out.println("不能快进");
        } else {
            System.out.println("可以任意的来回播放");
        }
    }
}
