package icu.wenxin.napcat.interfaces;

import com.alibaba.fastjson2.JSONObject;

@FunctionalInterface
public interface EventHandler {
    void handle(JSONObject msg);
}
