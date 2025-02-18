package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Dice implements MessageData {
    private String result; // 骰子结果
} 