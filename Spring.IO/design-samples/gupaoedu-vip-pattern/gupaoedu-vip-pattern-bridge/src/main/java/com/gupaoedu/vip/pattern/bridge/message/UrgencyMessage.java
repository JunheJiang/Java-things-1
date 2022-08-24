package com.gupaoedu.vip.pattern.bridge.message;

/**
 * Created by Tom.
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    void sendMessage(String message, String toUser){
        message = "【加急】" + message;
        super.sendMessage(message,toUser);
    }

    public Object watch(String messageId){
        return null;
    }
}
