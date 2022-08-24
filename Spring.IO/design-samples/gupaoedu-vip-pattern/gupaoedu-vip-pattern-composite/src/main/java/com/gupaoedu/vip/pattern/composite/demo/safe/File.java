package com.gupaoedu.vip.pattern.composite.demo.safe;

/**
 * Created by Tom.
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    public void show() {
        System.out.println(this.name);
    }
}
