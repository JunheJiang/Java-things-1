package com.gupaoedu.vip.design.principle.dependencyinversion;

/**
 * Created by Tom on 2020/2/16.
 */
public class Tom {
//    public void studyJavaCourse(){
//        System.out.println("Tom正在学习Java课程");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("Tom正在学习Python课程");
//    }
//
//    public void studyAICourse(){
//        System.out.println("Tom正在学习AI课程");
//    }

//    public void study(ICourse course){
//        course.study();
//    }

    private ICourse course;

//    public Tom(ICourse iCourse) {
//        this.iCourse = iCourse;
//    }

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }
}
