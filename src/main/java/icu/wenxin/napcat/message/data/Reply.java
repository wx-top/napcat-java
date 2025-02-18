package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Reply implements MessageData {
    private String id; // 回复的消息 ID
} 