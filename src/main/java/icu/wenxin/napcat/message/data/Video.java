package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Video implements MessageData {
    private String file; // 视频文件内容
    private String name; // 视频文件名
    private String thumb; // 视频缩略图
    private String url; // 视频 URL
    private String path; // 视频文件路径
    private String fileId; // 文件 ID
    private String fileSize; // 文件大小
    private String fileUnique; // 文件唯一标识
} 