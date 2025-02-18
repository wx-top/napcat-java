package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import icu.wenxin.napcat.message.Message;
import lombok.Data;
import java.util.List;

@Data
public class Forward implements MessageData {
    private String id; // 转发的消息 ID
    private List<Message> content; // 转发的内容数组
} 