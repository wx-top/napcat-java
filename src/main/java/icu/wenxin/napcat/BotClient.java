package icu.wenxin.napcat;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.enums.EventType;
import icu.wenxin.napcat.exception.BotException;
import icu.wenxin.napcat.handler.EventHandlerManager;
import icu.wenxin.napcat.message.SendMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class BotClient {
    private static final Executor executor = Executors.newCachedThreadPool();
    private Integer reconnectCount = 0;
    private final URI serverUri;
    private static final Map<String, CompletableFuture<JSONObject>> pendingRequests = new ConcurrentHashMap<>();

    @Getter
    private static volatile BotWsClientEndpoint endpoint;

    public BotClient(BotConfig config) throws BotException.ConnectionException {
        try {
            this.serverUri = new URI(config.getUrl());
        } catch (Exception e) {
            throw new BotException.ConnectionException("无效的服务器地址", e);
        }
    }

    public static CompletableFuture<JSONObject> send(SendMessage sendMessage) {
        String json = JSON.toJSONString(sendMessage);
        log.info("发送消息: {}", json);
        
        CompletableFuture<JSONObject> future = new CompletableFuture<>();
        pendingRequests.put(sendMessage.getEcho(), future);
        
        // 设置超时
        executor.execute(() -> {
            try {
                Thread.sleep(30000); // 30秒超时
                if (pendingRequests.remove(sendMessage.getEcho()) != null) {
                    future.completeExceptionally(new BotException.TimeoutException("请求超时"));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        endpoint.send(json);
        return future;
    }

    private void createNewEndpoint() {
        endpoint = new BotWsClientEndpoint(serverUri);
    }

    public void registerHandler(Object handler) {
        EventHandlerManager.registerHandler(handler);
    }

    public void unregisterHandler(Object handler) {
        EventHandlerManager.unregisterHandler(handler);
    }

    public void clearHandlers() {
        EventHandlerManager.clearHandlers();
    }

    public class BotWsClientEndpoint extends WebSocketClient {
        public BotWsClientEndpoint(URI serverUri) {
            super(serverUri);
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {
            log.info("连接成功");
            reconnectCount = 0;
        }

        @Override
        public void onMessage(String msg) {
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println(msg);
                    JSONObject data = JSONObject.parseObject(msg);
                    String retCode = data.getString("retcode");
                    String echo = data.getString("echo");
                    
                    // 处理带 echo 的响应
                    if (echo != null) {
                        CompletableFuture<JSONObject> future = pendingRequests.remove(echo);
                        if (future != null) {
                            if ("0".equals(retCode)) {
                                future.complete(data);
                            } else {
                                future.completeExceptionally(new BotException.ApiException(retCode, data));
                            }
                            return;
                        }
                    }
                    
                    // 处理普通消息
                    List<EventType> eventTypeList = EventType.parseData(data);
                    eventTypeList.forEach(eventType -> 
                        EventHandlerManager.handleEvent(eventType, data)
                    );
                } catch (Exception e) {
                    log.error("消息解析失败", e);
                }
            }, executor);
        }

        @Override
        public void onClose(int i, String s, boolean b) {
            log.error("连接关闭 {}", s);
            if (reconnectCount < 5) {
                log.info("尝试重新连接");
                reconnectCount++;
                try {
                    connect();
                } catch (Exception e) {
                    log.error("重连失败", e);
                }
            } else {
                log.error("尝试重新连接失败");
            }
        }

        @Override
        public void onError(Exception e) {
            log.error("连接异常 {}", e.getMessage());
        }
    }

    public void connect() throws BotException.ConnectionException {
        try {
            createNewEndpoint();
            endpoint.connectBlocking();
        } catch (Exception e) {
            throw new BotException.ConnectionException("连接失败", e);
        }
    }
}