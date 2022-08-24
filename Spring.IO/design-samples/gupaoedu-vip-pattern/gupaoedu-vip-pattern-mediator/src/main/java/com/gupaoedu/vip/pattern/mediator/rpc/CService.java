package com.gupaoedu.vip.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class CService implements IService {
    Registry registry;
    CService(){
        registry.register("cService",this);
    }


}
