package com.gupaoedu.vip.pattern.bridge.message;

/**
 * Created by Tom.
 * 桥接模式并未直接实现接口、嵌套了抽象
 * 实现类实现接口、super
 *
 */
public abstract class AbstractMessage {
    private IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }
}
