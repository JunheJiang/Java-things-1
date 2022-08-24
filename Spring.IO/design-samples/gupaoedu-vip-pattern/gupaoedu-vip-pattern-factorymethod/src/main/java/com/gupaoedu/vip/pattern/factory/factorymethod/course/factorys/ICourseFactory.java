package com.gupaoedu.vip.pattern.factory.factorymethod.course.factorys;


import com.gupaoedu.vip.pattern.factory.factorymethod.course.products.ICourse;

/**
 * 工厂模型
 * Created by Tom.
 * 工厂用方法创建对象
 */
public interface ICourseFactory {

    ICourse create();

}
