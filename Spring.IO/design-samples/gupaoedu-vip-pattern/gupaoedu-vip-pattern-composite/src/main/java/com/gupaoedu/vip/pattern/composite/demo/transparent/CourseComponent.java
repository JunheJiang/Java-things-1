package com.gupaoedu.vip.pattern.composite.demo.transparent;

/**
 * Created by Tom.
 */
public abstract class CourseComponent {

    public void addChild(CourseComponent componet){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void removeChild(CourseComponent componet){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponent componet){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponent componet){
        throw new UnsupportedOperationException("不支持获得价格操作");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
