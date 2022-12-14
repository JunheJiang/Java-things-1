package com.gupaoedu.vip.design.principle.openclose;

/**
 * Created by Tom on 2020/2/16.
 * 开闭原则：Open-Closed Principle, OCP
 * 对扩展开放、对修改关闭
 * 　　强调用抽象构建框架，用实现扩展细节
 */
public class OpenCloseTest {

    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "Java架构", 11800D);
        JavaDiscountCourse discountCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID：" + discountCourse.getId() +
                "\n课程标题：《" + discountCourse.getName() + "》" +
                "\n原价：" + discountCourse.getPrice() +
                "\n售价：" + discountCourse.getDiscountPrice());
    }

}
