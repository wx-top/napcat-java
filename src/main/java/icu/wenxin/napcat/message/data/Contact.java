package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Contact implements MessageData {
    private String type; // 联系人类型，例如 "qq" 或 "group"
    private String id;   // QQ号或群号
} 