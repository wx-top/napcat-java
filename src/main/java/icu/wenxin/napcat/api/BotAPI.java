package icu.wenxin.napcat.api;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.BotClient;
import icu.wenxin.napcat.message.Message;

import java.util.List;

public class BotAPI {

    private static final BotClient.BotWsClientEndpoint endpoint = BotClient.getEndpoint();

    /**
     * send_group_msg
     */
    public static void sendGroupMsg(Integer groupId, List<Message> messages) {
        JSONObject wsData = new JSONObject();
        wsData.put("params", new JSONObject() {{
            put("group_id", groupId);
            put("message", messages);
        }});
        System.out.println(wsData.toJSONString());
        endpoint.send(wsData.toJSONString());
    }



}