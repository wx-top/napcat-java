package icu.wenxin.napcat.message.data;

import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Rps implements MessageData {
    private String result; // RPS 结果
} 