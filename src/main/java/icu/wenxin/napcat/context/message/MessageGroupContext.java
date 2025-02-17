package icu.wenxin.napcat.context.message;

import com.alibaba.fastjson2.annotation.JSONField;
import icu.wenxin.napcat.context.BaseContext;
import icu.wenxin.napcat.message.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageGroupContext extends BaseContext {
    @JSONField(name = "user_id")
    private Long userId;               // user_id
    @JSONField(name = "message_id")
    private Long messageId;            // message_id
    @JSONField(name = "message_seq")
    private Long messageSeq;           // message_seq
    @JSONField(name = "real_id")
    private Long realId;               // real_id
    @JSONField(name = "message_type")
    private String messageType;        // message_type
    private Sender sender;             // sender
    @JSONField(name = "raw_message")
    private String rawMessage;         // raw_message
    private Integer font;                  // font
    @JSONField(name = "sub_type")
    private String subType;            // sub_type
    private List<Message> message;     // message
    @JSONField(name = "message_format")
    private String messageFormat;      // message_format
    @JSONField(name = "group_id")
    private Long groupId;              // group_id

    @Data
    public static class Sender {
        @JSONField(name = "user_id")
        private Long userId;         // sender.user_id
        private String nickname;     // sender.nickname
        private String card;         // sender.card
        private String role;         // sender.role
    }

}
