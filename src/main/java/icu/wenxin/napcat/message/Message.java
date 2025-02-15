package icu.wenxin.napcat.message;

import lombok.Data;

@Data
public class Message {
    private MessageType type;
    private String content;
}
