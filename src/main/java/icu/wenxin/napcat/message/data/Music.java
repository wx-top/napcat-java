package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Music implements MessageData {
    private String type; // 音乐类型
    private String url; // 点击后跳转目标 URL
    private String audio; // 音乐 URL
    private String title; // 歌曲标题
    private String image; // 封面图片 URL
    private String singer; // 歌手名
} 