package icu.wenxin.napcat.handler;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.annotation.EventListener;
import icu.wenxin.napcat.enums.EventType;
import icu.wenxin.napcat.interfaces.EventHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class EventHandlerManager {
    private static final Map<EventType, List<EventHandler>> handlers = new ConcurrentHashMap<>();
    private static final List<Object> handlerInstances = new ArrayList<>();

    public static void registerHandler(Object instance) {
        if (handlerInstances.contains(instance)) {
            return;
        }
        handlerInstances.add(instance);
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventListener.class)) {
                EventListener annotation = method.getAnnotation(EventListener.class);
                EventType[] eventTypes = annotation.value();
                
                for (EventType eventType : eventTypes) {
                    handlers.computeIfAbsent(eventType, k -> new ArrayList<>())
                            .add((message) -> {
                                try {
                                    method.invoke(instance, message);
                                } catch (Exception e) {
                                    log.error("事件处理异常", e);
                                }
                            });
                }
            }
        }
    }

    public static void unregisterHandler(Object instance) {
        if (!handlerInstances.contains(instance)) {
            return;
        }
        handlerInstances.remove(instance);
        
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventListener.class)) {
                EventListener annotation = method.getAnnotation(EventListener.class);
                EventType[] eventTypes = annotation.value();
                
                for (EventType eventType : eventTypes) {
                    List<EventHandler> eventListeners = handlers.get(eventType);
                    if (eventListeners != null) {
                        eventListeners.removeIf(handler -> {
                            try {
                                return handler.equals(method.invoke(instance, new JSONObject()));
                            } catch (Exception e) {
                                return false;
                            }
                        });
                    }
                }
            }
        }
    }

    public static void handleEvent(EventType eventType, JSONObject message) {
        List<EventHandler> eventListeners = handlers.get(eventType);
        if (eventListeners != null) {
            for (EventHandler handler : eventListeners) {
                handler.handle(message);
            }
        }
    }

    public static void clearHandlers() {
        handlers.clear();
        handlerInstances.clear();
    }
}