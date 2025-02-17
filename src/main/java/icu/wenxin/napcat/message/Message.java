package icu.wenxin.napcat.message;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;


@Data
public class Message {
    private String type;
    private MessageData data;

    public Message(String type, MessageData data) {
        this.type = type;
        this.data = data;
    }

    public static Message of(String type, MessageData data) {
        return new Message(type, data);
    }
}
