package com.gupaoedu.vip.pattern.mediator.rpc;

/**
 * Created by Tom.
 */
public class AService implements IService {
    Registry registry;
    AService(){
        registry.register("aService",this);
    }

    public void a(){
        //registry.get("bService").xxx();
    }
}
