package icu.wenxin.napcat.example;

import icu.wenxin.napcat.BotClient;
import icu.wenxin.napcat.BotConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        BotConfig config = BotConfig.builder()
                .protocol("ws")
                .host("127.0.0.1")
                .port(3001)
                .accessToken("napcat")
                .build();
                
        BotClient botClient = new BotClient(config);
        botClient.registerHandler(new MyEventHandler());
        botClient.connect();
    }
}
