package icu.wenxin.napcat.message;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.enums.MessageType;
import lombok.Data;

@Data
public class Message {
    private String type;
    private JSONObject data;

    public Message(MessageType type, JSONObject data) {
        this.type = type.getType();
        this.data = data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private MessageType type;
        private JSONObject data = new JSONObject();

        public Builder type(MessageType type) {
            this.type = type;
            return this;
        }

        public Builder data(JSONObject data) {
            this.data = data;
            return this;
        }

        public Message build() {
            return new Message(type, data);
        }
    }

    public static Message reply(Long messageId) {
        return Message.builder()
                .type(MessageType.REPLY)
                .data(new JSONObject()
                        .fluentPut("id", messageId))
                .build();
    }

    public static Message text(String text) {
        return Message.builder()
                .type(MessageType.TEXT)
                .data(new JSONObject()
                        .fluentPut("text", text))
                .build();
    }

    public static Message image(String filePath) {
        return Message.builder()
                .type(MessageType.IMAGE)
                .data(new JSONObject()
                        .fluentPut("file", filePath))
                .build();
    }

    public static Message at(Long qq) {
        return Message.builder()
                .type(MessageType.AT)
                .data(new JSONObject()
                        .fluentPut("qq", qq))
                .build();
    }

    public static Message atAll() {
        return Message.builder()
                .type(MessageType.AT)
                .data(new JSONObject()
                        .fluentPut("qq", "all"))
                .build();
    }

    public static Message video(String filePath) {
        return Message.builder()
                .type(MessageType.VIDEO)
                .data(new JSONObject()
                        .fluentPut("file", filePath))
                .build();
    }

    public static Message file(String filePath, String fileName) {
        return Message.builder()
                .type(MessageType.FILE)
                .data(new JSONObject()
                        .fluentPut("file", filePath)
                        .fluentPut("name", fileName))
                .build();
    }
}
