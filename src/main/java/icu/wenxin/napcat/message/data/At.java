package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class At implements MessageData {
    private String qq; // 被 @ 的用户 QQ
    private String type; // @ 类型，例如 "all" 表示全体
} 