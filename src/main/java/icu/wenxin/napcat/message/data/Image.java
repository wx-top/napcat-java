package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Image implements MessageData {
    private String url; // 图片 URL
    private String alt; // 图片描述
} 