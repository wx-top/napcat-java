package icu.wenxin.napcat.enums;

import com.alibaba.fastjson2.JSONObject;
import icu.wenxin.napcat.context.BaseContext;
import icu.wenxin.napcat.context.message.MessageGroupContext;
import icu.wenxin.napcat.utils.ListUtils;
import icu.wenxin.napcat.utils.StringUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EventType {
    // 元事件
    META_EVENT("meta_event", null),
    // 元事件 - 心跳
    META_EVENT_HEARTBEAT("meta_event.heartbeat", null),
    // 元事件 - 生命周期
    META_EVENT_LIFECYCLE("meta_event.lifecycle", null),
    // 元事件 - 生命周期 - 启用
    // META_EVENT_LIFECYCLE_ENABLE("meta_event.lifecycle.enable", null),
    // 元事件 - 生命周期 - 停用
    // META_EVENT_LIFECYCLE_DISABLE("meta_event.lifecycle.disable", null),
    // 元事件 - 生命周期 - 连接
    META_EVENT_LIFECYCLE_CONNECT("meta_event.lifecycle.connect", null),

    // 消息
    MESSAGE("message", null),
    // 私聊消息
    MESSAGE_PRIVATE("message.private", null),
    // 私聊消息 - 好友
    MESSAGE_PRIVATE_FRIEND("message.private.friend", null),
    // 私聊消息 - 群临时
    MESSAGE_PRIVATE_GROUP("message.private.group", null),
    // 私聊消息 - 群中自身发送
    // MESSAGE_PRIVATE_GROUP_SELF("message.private.group_self", null),
    // 私聊消息 - 其他
    // MESSAGE_PRIVATE_OTHER("message.private.other", null),
    // 群聊消息
    MESSAGE_GROUP("message.group", MessageGroupContext.class),
    // 群聊消息 - 普通
    MESSAGE_GROUP_NORMAL("message.group.normal", null),
    // 群聊消息 - 匿名消息
    // MESSAGE_GROUP_ANONYMOUS("message.group.anonymous", null),
    // 群聊消息 - 系统提示
    // MESSAGE_GROUP_NOTICE("message.group.notice", null),

    // 消息发送
    MESSAGE_SEND("message_send", null),
    // 消息发送 - 私聊
    MESSAGE_SEND_PRIVATE("message_send.private", null),
    // 消息发送 - 私聊 - 好友
    MESSAGE_SEND_PRIVATE_FRIEND("message_send.private.friend", null),
    // 消息发送 - 私聊 - 群临时
    MESSAGE_SEND_PRIVATE_GROUP("message_send.private.group", null),
    // 消息发送 - 私聊消息 - 群中自身发送
    // MESSAGE_SEND_PRIVATE_GROUP_SELF("message_send.private.group_self", null),
    // 消息发送 - 私聊消息 - 其他
    // MESSAGE_SEND_PRIVATE_OTHER("message_send.private.other", null),
    // 消息发送 - 群聊
    MESSAGE_SEND_GROUP("message_send.group", null),
    // 消息发送 - 群聊 - 普通
    MESSAGE_SEND_GROUP_NORMAL("message_send.group.normal", null),
    // 消息发送 - 群聊 - 匿名消息
    // MESSAGE_SEND_GROUP_ANONYMOUS("message_send.group.anonymous", null),
    // 消息发送 - 群聊 - 系统提示
    // MESSAGE_SEND_GROUP_NOTICE("message_send.group.notice", null),

    // 请求
    REQUEST("request", null),
    // 请求 - 加好友请求
    REQUEST_FRIEND("request.friend", null),
    // 请求 - 加群请求（需要管理员权限）
    REQUEST_GROUP_ADD("request.group.add", null),
    // 请求 - 邀请登录号入群
    REQUEST_GROUP_INVITE("request.group.invite", null),

    // 通知
    NOTICE("notice", null),
    // 通知 - 好友添加
    NOTICE_FRIEND_ADD("notice.friend_add", null),
    // 通知 - 好友撤回
    NOTICE_FRIEND_RECALL("notice.friend_recall", null),
    // 通知 - 群聊文件上传
    NOTICE_GROUP_UPLOAD("notice.group_upload", null),
    // 通知 - 其他客户端在线状态变更
    NOTICE_CLIENT_STATUS("notice.client_status", null),
    // 通知 - 群聊管理员变动
    NOTICE_GROUP_ADMIN("notice.group_admin", null),
    // 通知 - 群聊管理员变动 - 增加
    NOTICE_GROUP_ADMIN_SET("notice.group_admin.set", null),
    // 通知 - 群聊管理员变动 - 减少
    NOTICE_GROUP_ADMIN_UNSET("notice.group_admin.unset", null),
    // 通知 - 群聊禁言
    NOTICE_GROUP_BAN("notice.group_ban", null),
    // 通知 - 群聊禁言 - 禁言
    NOTICE_GROUP_BAN_BAN("notice.group_ban.ban", null),
    // 通知 - 群聊禁言 - 取消禁言
    NOTICE_GROUP_BAN_LIFT_BAN("notice.group_ban.lift_ban", null),
    // 通知 - 群聊成员名片更新
    NOTICE_GROUP_CARD("notice.group_card", null),
    // 通知 - 群聊成员减少
    NOTICE_GROUP_DECREASE("notice.group_decrease", null),
    // 通知 - 群聊成员减少 - 主动退群
    NOTICE_GROUP_DECREASE_LEAVE("notice.group_decrease.leave", null),
    // 通知 - 群聊成员减少 - 成员被踢
    NOTICE_GROUP_DECREASE_KICK("notice.group_decrease.kick", null),
    // 通知 - 群聊成员减少 - 登录号被踢
    NOTICE_GROUP_DECREASE_KICK_ME("notice.group_decrease.kick_me", null),
    // 通知 - 群聊成员增加
    NOTICE_GROUP_INCREASE("notice.group_increase", null),
    // 通知 - 群聊成员增加 - 管理员已同意入群
    NOTICE_GROUP_INCREASE_APPROVE("notice.group_increase.approve", null),
    // 通知 - 群聊成员增加 - 管理员邀请入群
    NOTICE_GROUP_INCREASE_INVITE("notice.group_increase.invite", null),
    // 通知 - 群聊消息撤回
    NOTICE_GROUP_RECALL("notice.group_recall", null),
    // 通知 - 群聊表情回应（仅收自己的 其余扩展接口拉取）
    // NOTICE_GROUP_MSG_EMOJI_LIKE("notice.group_msg_emoji_like", null),
    // 通知 - 群聊设精
    NOTICE_ESSENCE("notice.essence", null),
    // 通知 - 群聊设精 - 增加
    NOTICE_ESSENCE_ADD("notice.essence.add", null),
    // 通知 - 群聊设精 - 取消
    // NOTICE_ESSENCE_DELETE("notice.essence.delete", null),
    // 通知 - 戳一戳
    NOTICE_NOTIFY_POKE("notice.notify.poke", null),
    // 通知 - 群红包运气王
    // NOTICE_NOTIFY_LUCKY_KING("notice.notify.lucky_king", null),
    // 通知 - 群成员荣誉变更
    // NOTICE_NOTIFY_HONOR("notice.notify.honor", null),
    // 通知 - 群成员荣誉变更 - 龙王
    // NOTICE_NOTIFY_HONOR_TALKATIVE("notice.notify.honor.talkative", null),
    // 通知 - 群成员荣誉变更 - 群聊之火
    // NOTICE_NOTIFY_HONOR_PERFORMER("notice.notify.honor.performer", null),
    // 通知 - 群成员荣誉变更 - 快乐源泉
    // NOTICE_NOTIFY_HONOR_EMOTION("notice.notify.honor.emotion", null),
    // 通知 - 输入状态更新
    NOTICE_NOTIFY_INPUT_STATUS("notice.notify.input_status", null),
    // 通知 - 群成员头衔变更
    // NOTICE_NOTIFY_TITLE("notice.notify.title", null),
    // 通知 - 点赞
    NOTICE_NOTIFY_PROFILE_LIKE("notice.notify.profile_like", null);

    private final String eventName;
    private final Class<? extends BaseContext> clazz;

    EventType(String eventName, Class<? extends BaseContext> clazz) {
        this.eventName = eventName;
        this.clazz = clazz;
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
