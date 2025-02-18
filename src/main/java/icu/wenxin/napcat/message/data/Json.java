package icu.wenxin.napcat.message.data;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.interfaces.MessageData;
import lombok.Data;

@Data
public class Json implements MessageData {
    private JSONObject data; // JSON 数据内容
} 