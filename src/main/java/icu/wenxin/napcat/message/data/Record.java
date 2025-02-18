package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Record implements MessageData {
    private String file; // 文件内容
    private String name; // 文件名
    private String url; // 文件 URL
    private String path; // 文件路径
    private String fileId; // 文件 ID
    private String fileSize; // 文件大小
    private String fileUnique; // 文件唯一标识
} 