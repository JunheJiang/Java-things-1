package com.gupaoedu.vip.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForWechatAdapter extends AbstractAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegister(id, null);
    }


}
