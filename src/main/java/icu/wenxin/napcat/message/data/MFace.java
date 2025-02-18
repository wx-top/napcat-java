package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class MFace implements MessageData {
    private String emojiId; // 表情 ID
    private String emojiPackageId; // 表情包 ID
    private String key; // 表情键
    private String summary; // 表情描述
} 