package com.gupaoedu.vip.pattern.composite.demo.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Folder extends Directory {

    private List<Directory> dirs;

    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<Directory>();
    }

    public void show() {
        System.out.println(this.name);
        for (Directory c : dirs) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            c.show();
        }
    }

    public boolean add(Directory dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir) {
        return this.dirs.remove(dir);
    }

    public Directory get(int index) {
        return this.dirs.get(index);
    }

    public void list() {
        for (Directory dir : dirs) {
            System.out.println(dir.name);
        }
    }
}
