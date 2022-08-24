package com.gupaoedu.vip.pattern.nullobject.general;

/**
 * Created by Tom.
 * 工厂模式
 */
public class Client {

    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        System.out.println(factory.getObject("Joe").isNull());
        System.out.println(factory.getObject("Tom").isNull());
    }


    //抽象对象
    static abstract class AbstractObject {
        abstract void request();

        abstract boolean isNull();
    }

    //空对象
    static class NullObject extends AbstractObject {

        public void request() {
            System.out.println("Not Available Request");
        }

        boolean isNull() {
            return true;
        }
    }

    //真实对象
    static class RealObject extends AbstractObject {
        private String name;

        public RealObject(String name) {
            this.name = name;
        }

        public void request() {
            System.out.println("Do samething...");
        }

        boolean isNull() {
            return false;
        }
    }

    //对象工厂
    static class ObjectFactory {
        private static final String[] names = {"Tom", "Mic", "James"};

        public AbstractObject getObject(String name) {
            for (String n : names) {
                if (n.equalsIgnoreCase(name)) {
                    return new RealObject(name);
                }
            }
            return new NullObject();
        }
    }
}
