package com.gupaoedu.vip.pattern.adapter.demo.passport.adapterv2.adapters;

import com.gupaoedu.vip.pattern.adapter.demo.passport.PassportService;
import com.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 * 抽象适配实现
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}
