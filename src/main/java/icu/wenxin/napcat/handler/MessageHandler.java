package icu.wenxin.napcat.handler;

import icu.wenxin.napcat.message.Message;

public interface MessageHandler {
    void handle(Message message);
}