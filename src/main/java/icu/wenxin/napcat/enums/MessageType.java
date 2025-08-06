package icu.wenxin.napcat.enums;

import lombok.Getter;

@Getter
public enum MessageType {
    TEXT("text", "文本消息"),
    FACE("face", "表情消息"),
    IMAGE("image", "图片消息"),
    AT("at", "@消息"),
    REPLY("reply", "回复消息"),
    FORWARD("forward", "合并转发消息"),
    NODE("node", "节点消息"),
    XML("xml", "XML消息"),
    JSON("json", "JSON消息"),
    FILE("file", "文件消息"),
    RECORD("record", "语音消息"),
    VIDEO("video", "视频消息");

    private final String type;
    private final String desc;

    MessageType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
