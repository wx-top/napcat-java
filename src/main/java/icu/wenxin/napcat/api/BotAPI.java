package icu.wenxin.napcat.api;

import icu.wenxin.napcat.core.BotClient;

public class BotAPI {
    private final BotClient client;

    public BotAPI(BotClient client) {
        this.client = client;
    }

    public void sendMessage(String content) {
        client.send(content);
    }
}