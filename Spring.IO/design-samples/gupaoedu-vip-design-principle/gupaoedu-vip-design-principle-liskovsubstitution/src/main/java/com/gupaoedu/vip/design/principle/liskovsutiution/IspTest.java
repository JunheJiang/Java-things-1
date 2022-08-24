package com.gupaoedu.vip.design.principle.liskovsutiution;

import com.gupaoedu.vip.design.principle.liskovsutiution.simple.*;
import com.gupaoedu.vip.design.principle.liskovsutiution.simple.Square;

/**
 * Created by Tom on 2020/2/16.】
 * 里氏替换原则：Liskov-Substitution Principle, LSP
 * 子类【可以扩展】父类功能，但【不能改变】父类原有的功能
 * <p>
 * 　　子类可以实现父类的抽象方法，但不能覆盖父类的抽象方法
 * 　　子类中可以增加自己特有的方法 当子类的方法实现父类的方法时（重写/重载或实现抽象方法）
 */
public class IspTest {

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("Width:" + rectangle.getWidth() + ",Height:" + rectangle.getHeight());
        }
        System.out.println("Resize End,Width:" + rectangle.getWidth() + ",Height:" + rectangle.getHeight());
    }

//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(20);
//        rectangle.setHeight(10);
//        resize(rectangle);
//    }

//    public static void main(String[] args) {
//        com.gupaoedu.vip.design.principle.liskovsutiution.simple.Square square = new Square();
//        square.setLength(10);
//        resize(square);
//    }

}
