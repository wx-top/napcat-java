package icu.wenxin.napcat.message;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.enums.ActionType;
import lombok.Data;

import java.util.UUID;

@Data
public class SendMessage {
    private String action;
    private JSONObject params;
    private String echo = UUID.randomUUID().toString();

    public SendMessage(ActionType action, JSONObject params) {
        this.action = action.getAction();
        this.params = params;
    }

    public void setAction(ActionType action) {
        this.action = action.getAction();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ActionType type = null;
        private JSONObject params = new JSONObject();

        public Builder type(ActionType type) {
            this.type = type;
            return this;
        }

        public Builder params(JSONObject params) {
            this.params = params;
            return this;
        }

        public SendMessage build() {
            return new SendMessage(type, params);
        }
    }
}
