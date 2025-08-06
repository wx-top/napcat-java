package icu.wenxin.napcat.enums;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.utils.ListUtils;
import icu.wenxin.napcat.utils.StringUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EventType {
    // 元事件
    META_EVENT("meta_event"),
    // 元事件 - 心跳
    META_EVENT_HEARTBEAT("meta_event.heartbeat"),
    // 元事件 - 生命周期
    META_EVENT_LIFECYCLE("meta_event.lifecycle"),
    // 元事件 - 生命周期 - 连接
    META_EVENT_LIFECYCLE_CONNECT("meta_event.lifecycle.connect"),

    // 消息
    MESSAGE("message"),
    // 私聊消息
    MESSAGE_PRIVATE("message.private"),
    // 私聊消息 - 好友
    MESSAGE_PRIVATE_FRIEND("message.private.friend"),
    // 私聊消息 - 群临时
    MESSAGE_PRIVATE_GROUP("message.private.group"),
    // 群聊消息
    MESSAGE_GROUP("message.group"),
    // 群聊消息 - 普通
    MESSAGE_GROUP_NORMAL("message.group.normal"),

    // 消息发送
    MESSAGE_SEND("message_send"),
    // 消息发送 - 私聊
    MESSAGE_SEND_PRIVATE("message_send.private"),
    // 消息发送 - 私聊 - 好友
    MESSAGE_SEND_PRIVATE_FRIEND("message_send.private.friend"),
    // 消息发送 - 私聊 - 群临时
    MESSAGE_SEND_PRIVATE_GROUP("message_send.private.group"),
    // 消息发送 - 群聊
    MESSAGE_SEND_GROUP("message_send.group"),
    // 消息发送 - 群聊 - 普通
    MESSAGE_SEND_GROUP_NORMAL("message_send.group.normal"),

    // 请求
    REQUEST("request"),
    // 请求 - 加好友请求
    REQUEST_FRIEND("request.friend"),
    // 请求 - 加群请求（需要管理员权限）
    REQUEST_GROUP_ADD("request.group.add"),
    // 请求 - 邀请登录号入群
    REQUEST_GROUP_INVITE("request.group.invite"),

    // 通知
    NOTICE("notice"),
    // 通知 - 好友添加
    NOTICE_FRIEND_ADD("notice.friend_add"),
    // 通知 - 好友撤回
    NOTICE_FRIEND_RECALL("notice.friend_recall"),
    // 通知 - 群聊文件上传
    NOTICE_GROUP_UPLOAD("notice.group_upload"),
    // 通知 - 其他客户端在线状态变更
    NOTICE_CLIENT_STATUS("notice.client_status"),
    // 通知 - 群聊管理员变动
    NOTICE_GROUP_ADMIN("notice.group_admin"),
    // 通知 - 群聊管理员变动 - 增加
    NOTICE_GROUP_ADMIN_SET("notice.group_admin.set"),
    // 通知 - 群聊管理员变动 - 减少
    NOTICE_GROUP_ADMIN_UNSET("notice.group_admin.unset"),
    // 通知 - 群聊禁言
    NOTICE_GROUP_BAN("notice.group_ban"),
    // 通知 - 群聊禁言 - 禁言
    NOTICE_GROUP_BAN_BAN("notice.group_ban.ban"),
    // 通知 - 群聊禁言 - 取消禁言
    NOTICE_GROUP_BAN_LIFT_BAN("notice.group_ban.lift_ban"),
    // 通知 - 群聊成员名片更新
    NOTICE_GROUP_CARD("notice.group_card"),
    // 通知 - 群聊成员减少
    NOTICE_GROUP_DECREASE("notice.group_decrease"),
    // 通知 - 群聊成员减少 - 主动退群
    NOTICE_GROUP_DECREASE_LEAVE("notice.group_decrease.leave"),
    // 通知 - 群聊成员减少 - 成员被踢
    NOTICE_GROUP_DECREASE_KICK("notice.group_decrease.kick"),
    // 通知 - 群聊成员减少 - 登录号被踢
    NOTICE_GROUP_DECREASE_KICK_ME("notice.group_decrease.kick_me"),
    // 通知 - 群聊成员增加
    NOTICE_GROUP_INCREASE("notice.group_increase"),
    // 通知 - 群聊成员增加 - 管理员已同意入群
    NOTICE_GROUP_INCREASE_APPROVE("notice.group_increase.approve"),
    // 通知 - 群聊成员增加 - 管理员邀请入群
    NOTICE_GROUP_INCREASE_INVITE("notice.group_increase.invite"),
    // 通知 - 群聊消息撤回
    NOTICE_GROUP_RECALL("notice.group_recall"),
    // 通知 - 群聊设精
    NOTICE_ESSENCE("notice.essence"),
    // 通知 - 群聊设精 - 增加
    NOTICE_ESSENCE_ADD("notice.essence.add"),
    // 通知 - 戳一戳
    NOTICE_NOTIFY_POKE("notice.notify.poke"),
    // 通知 - 输入状态更新
    NOTICE_NOTIFY_INPUT_STATUS("notice.notify.input_status"),
    // 通知 - 点赞
    NOTICE_NOTIFY_PROFILE_LIKE("notice.notify.profile_like");

    private final String eventName;

    EventType(String eventName) {
        this.eventName = eventName;
    }

    public static EventType getEventTypeByName(String eventName) {
        for (EventType eventType : values()) {
            if (eventType.eventName.equals(eventName)) {
                return eventType;
            }
        }
        return null;
    }

    public static List<EventType> parseData(JSONObject data) {
        List<EventType> list = new ArrayList<>();
        String postType = data.getString("post_type");
        String nextType = data.getString(postType + "_type");
        String subType = data.getString("sub_type");
        ListUtils.addToHeadIfNotNull(list, EventType.getEventTypeByName(postType));
        ListUtils.addToHeadIfNotNull(list, EventType.getEventTypeByName(String.join(".", postType, nextType)));
        if (!StringUtils.isEmpty(subType)) {
            ListUtils.addToHeadIfNotNull(list, EventType.getEventTypeByName(String.join(".", postType, nextType, subType)));
        }
        return list;
    }
}
