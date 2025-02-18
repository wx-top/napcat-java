package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import icu.wenxin.napcat.message.Message;
import lombok.Data;

import java.util.List;

@Data
public class Node implements MessageData {
    private String id; // 节点 ID
    private List<Message> content; // 节点内容数组
} 