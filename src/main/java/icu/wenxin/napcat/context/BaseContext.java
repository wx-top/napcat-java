package icu.wenxin.napcat.context;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class BaseContext {
    private Long time;
    @JSONField(name = "self_id")
    private Long selfId;
    @JSONField(name = "post_type")
    private String postType;
}
