package icu.wenxin.napcat.core;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BotClient extends WebSocketClient {
    private final BotContext context;

    public BotClient(BotConfig config) throws URISyntaxException {
        super(config.getUrl());
        this.context = new BotContext();
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("Connected to WebSocket server");
        context.onOpen();
    }

    @Override
    public void onMessage(String message) {
        context.onMessage(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Disconnected from WebSocket server");
        context.onClose(code, reason, remote);
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("WebSocket error:");
        ex.printStackTrace();
        context.onError(ex);
    }
}