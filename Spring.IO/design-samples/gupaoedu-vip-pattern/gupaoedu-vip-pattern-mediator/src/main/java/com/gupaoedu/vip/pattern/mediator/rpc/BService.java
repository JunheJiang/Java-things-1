package com.gupaoedu.vip.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class BService implements IService{
    Registry registry;
    BService(){
        registry.register("bService",this);
    }
}
