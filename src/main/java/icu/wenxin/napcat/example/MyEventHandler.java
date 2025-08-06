package icu.wenxin.napcat.example;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.BotClient;
import icu.wenxin.napcat.annotation.EventListener;
import icu.wenxin.napcat.enums.EventType;
import icu.wenxin.napcat.enums.MessageType;
import icu.wenxin.napcat.message.Message;
import icu.wenxin.napcat.message.SendMessage;
import lombok.extern.slf4j.Slf4j;
import static icu.wenxin.napcat.enums.ActionType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Slf4j
public class MyEventHandler {
    @EventListener(EventType.MESSAGE_GROUP_NORMAL)
    public void handleGroupMessage(JSONObject msg) {
            Long groupId = msg.getLong("group_id");
            log.info("处理消息 groupId: {}", groupId);
            Long userId = msg.getJSONObject( "sender").getLong("user_id");
            String message = msg.getString("raw_message");
            log.info("收到消息: {}", message);
            if (userId == 1731551615) {
                JSONObject params = new JSONObject();
                params.put("group_id", groupId);
                params.put("character", "lucy-voice-f34");
                params.put("text", "你好哇");
                SendMessage sendMessage = SendMessage.builder().type(SEND_GROUP_AI_RECORD).params(params).build();
                try {
                    JSONObject response = BotClient.send(sendMessage).get(30, TimeUnit.SECONDS);
                    System.out.println("收到响应：" + response);
                } catch (Exception e) {
                    // 请求错误
                    log.error( "请求错误", e);
                }

            }
    }
}