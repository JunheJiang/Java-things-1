package com.gupaoedu.vip.design.principle.demeter;

/**
 * Created by Tom on 2020/2/16.
 * 德米特原则：一个对象应当对其他对象尽可能少的了解、不和陌生人说话
 */
public class LodTest {

    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);
    }
}
