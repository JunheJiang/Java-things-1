package com.gupaoedu.vip.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public interface ILoginAdapter {
    //支持何种适配对象
    boolean support(Object object);
    ResultMsg login(String id,Object adapter);
}
