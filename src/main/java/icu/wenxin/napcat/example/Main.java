package icu.wenxin.napcat.example;

import icu.wenxin.napcat.BotClient;
import icu.wenxin.napcat.BotConfig;
import icu.wenxin.napcat.api.BotAPI;
import icu.wenxin.napcat.context.message.MessageGroupContext;
import icu.wenxin.napcat.enums.EventType;
import icu.wenxin.napcat.message.Message;
import icu.wenxin.napcat.message.data.Text;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {

        log.info("666");
        BotConfig config = new BotConfig();
        config.setProtocol("ws");
        config.setAccessToken("napcat");
        config.setHost("127.0.0.1");
        config.setPort(3001);
        System.out.println(config.getUrl());
        BotClient botClient = new BotClient(config);
        botClient.registerHandler(EventType.MESSAGE_GROUP, (MessageGroupContext context) -> {
            List<Message> messages = new ArrayList<>();
            Text text = new Text();
            text.setText("你好");
            messages.add(Message.of("text", text));
            BotAPI.sendGroupMsg(1027565242, messages);
        });
        botClient.connect();
    }
}
