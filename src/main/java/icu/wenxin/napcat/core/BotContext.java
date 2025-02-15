package icu.wenxin.napcat.core;

import icu.wenxin.napcat.handler.MessageHandler;
import icu.wenxin.napcat.message.Message;
import icu.wenxin.napcat.message.MessageParser;
import icu.wenxin.napcat.message.MessageType;

import java.util.HashMap;
import java.util.Map;

public class BotContext {
    private final Map<MessageType, MessageHandler> handlers = new HashMap<>();

    public void registerHandler(MessageType type, MessageHandler handler) {
        handlers.put(type, handler);
    }

    public void onOpen() {
        System.out.println("Bot connected!");
    }

    public void onMessage(String message) {
        Message msg = MessageParser.parse(message);
        MessageHandler handler = handlers.get(msg.getType());
        if (handler != null) {
            handler.handle(msg);
        } else {
            System.out.println("No handler found for message type: " + msg.getType());
        }
    }

    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Bot disconnected: " + reason);
    }

    public void onError(Exception ex) {
        System.err.println("Bot error:");
        ex.printStackTrace();
    }
}