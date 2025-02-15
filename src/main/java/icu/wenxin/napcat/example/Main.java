package icu.wenxin.napcat.example;

import icu.wenxin.napcat.core.BotClient;
import icu.wenxin.napcat.core.BotConfig;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        BotConfig config = new BotConfig();
        config.setProtocol("ws");
        config.setAccessToken("napcat");
        config.setHost("127.0.0.1");
        config.setPort(3001);
        System.out.println(config.getUrl());
        BotClient botClient = new BotClient(config);
        botClient.connect();
        // 保持主线程运行
//        while (true) {
//            Thread.sleep(1000); // 主线程休眠，防止退出
//        }
    }
}
