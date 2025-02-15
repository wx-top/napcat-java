package icu.wenxin.napcat.handler;

import icu.wenxin.napcat.message.Message;

public class DefaultMessageHandler implements MessageHandler {
    @Override
    public void handle(Message message) {
        System.out.println("Handling message: " + message.getContent());
        // 默认处理逻辑
    }
}
