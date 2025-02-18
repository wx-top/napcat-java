package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import icu.wenxin.napcat.message.Message;
import lombok.Data;

import java.util.List;

@Data
public class Fake implements MessageData {
    private String userId; // 用户 ID
    private String nickname; // 昵称
    private String id; // 伪造信息 ID
    private List<Message> content; // 伪造信息内容数组
}
