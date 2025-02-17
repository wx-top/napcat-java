package icu.wenxin.napcat;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.api.BotAPI;
import icu.wenxin.napcat.context.BaseContext;
import icu.wenxin.napcat.enums.EventType;
import icu.wenxin.napcat.interfaces.EventHandler;
import icu.wenxin.napcat.message.Message;
import icu.wenxin.napcat.message.data.Text;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class BotClient {
    private final Map<EventType, List<EventHandler<? extends BaseContext>>> handlers = new ConcurrentHashMap<>();
    private final Executor executor = Executors.newCachedThreadPool();

    private final BotConfig config;

    @Getter
    private static volatile BotWsClientEndpoint endpoint;

    public BotClient(BotConfig config) {
        this.config = config;
    }

    // 原始数据注册
    public <T extends BaseContext> void registerHandler(EventType eventType, EventHandler<T> handler) {
        handlers.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
                .add(handler);
    }

    // 添加取消注册接口
    public <T extends BaseContext> void unregisterHandler(EventType eventType, EventHandler<T> handler) {
        List<EventHandler<? extends BaseContext>> list = handlers.get(eventType);
        if (list != null) list.remove(handler);
    }

    // 支持清空处理器
    public void clearHandlers() {
        handlers.clear();
    }

    public class BotWsClientEndpoint extends WebSocketClient {
        public BotWsClientEndpoint(URI serverUri) {
            super(serverUri);
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {
            log.info("连接成功");
        }

        private <T extends BaseContext> void handleEvent(EventHandler<T> handler, JSONObject data, Class<? extends BaseContext> clazz) {
            try {
                @SuppressWarnings("unchecked")
                T context = data.to((Class<T>) clazz);
                // 调用 handler 处理事件
                handler.handle(context);
            } catch (Exception e) {
                log.error("事件处理异常", e);
            }
        }

        @Override
        public void onMessage(String s) {
            CompletableFuture.runAsync(() -> {
                try {
                    JSONObject data = JSONObject.parseObject(s);
                    log.info("收到消息 {}", data);
                    List<EventType> eventTypeList = EventType.parseData(data);
                    eventTypeList.forEach(eventType -> {
                        log.info("监听事件 {}", eventType);
                        handlers.getOrDefault(eventType, Collections.emptyList())
                        .forEach(handler -> {
                            log.info("处理事件 {} {}", eventType, data);
                            // 调用封装的方法处理事件
                            handleEvent(handler, data, eventType.getClazz());
                        });
                    });
                } catch (Exception e) {
                    log.error("消息解析失败 {}", e.getMessage());
                }
            }, executor);
        }

        @Override
        public void onClose(int i, String s, boolean b) {
            log.error("连接关闭 {}", s);
        }

        @Override
        public void onError(Exception e) {
            log.error("连接异常 {}", e.getMessage());
        }
    }

    public void connect() throws Exception {
        endpoint = new BotWsClientEndpoint(new URI(config.getUrl()));
        endpoint.connectBlocking();

    }

}