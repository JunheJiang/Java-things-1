package com.gupaoedu.vip.pattern.adapter.demo.passport.adapterv1;

import com.gupaoedu.vip.pattern.adapter.demo.passport.PassportService;
import com.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;


/**
 * Created by Tom.
 * 单一直接适配实现
 */
public class PassportForThirdAdapter extends PassportService implements IPassportForThird {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return loginForRegister(openId, null);
    }

    public ResultMsg loginForToken(String token) {
        return loginForRegister(token, null);
    }

    public ResultMsg loginForTelephone(String phone, String code) {
        return loginForRegister(phone, null);
    }

    private ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}
