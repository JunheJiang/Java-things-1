package com.gupaoedu.vip.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForQQAdapter extends AbstractAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        //支持何种适配对象
        if (!support(adapter)) {
            return null;
        }
        //accessToken

        //time
        return super.loginForRegister(id, null);

    }

}
