package icu.wenxin.napcat.exception;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;

public class BotException extends RuntimeException {
    public BotException(String message) {
        super(message);
    }

    public BotException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class ConnectionException extends BotException {
        public ConnectionException(String message) {
            super(message);
        }

        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class TimeoutException extends BotException {
        public TimeoutException(String message) {
            super(message);
        }
    }

    @Getter
    public static class ApiException extends BotException {
        private final String retcode;
        private final JSONObject data;

        public ApiException(String retcode, JSONObject data) {
            super("API调用失败: " + data);
            this.retcode = retcode;
            this.data = data;
        }

    }

    public static class MessageException extends BotException {
        public MessageException(String message) {
            super(message);
        }

        public MessageException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
