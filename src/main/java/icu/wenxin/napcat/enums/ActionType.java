package icu.wenxin.napcat.enums;

import lombok.Getter;

@Getter
public enum ActionType {
    // 消息相关
    SEND_GROUP_MSG("send_group_msg", "发送群消息"),
    SEND_PRIVATE_MSG("send_private_msg", "发送私聊消息"),
    SEND_MSG("send_msg", "发送消息"),
    DELETE_MSG("delete_msg", "撤回消息"),
    GET_MSG("get_msg", "获取消息"),
    GET_FORWARD_MSG("get_forward_msg", "获取合并转发消息"),
    SEND_LIKE("send_like", "发送好友赞"),
    
    // 群组管理
    SET_GROUP_KICK("set_group_kick", "群组踢人"),
    SET_GROUP_BAN("set_group_ban", "群组单人禁言"),
    SET_GROUP_WHOLE_BAN("set_group_whole_ban", "群组全员禁言"),
    SET_GROUP_ADMIN("set_group_admin", "群组设置管理员"),
    SET_GROUP_CARD("set_group_card", "设置群名片"),
    SET_GROUP_NAME("set_group_name", "设置群名"),
    SET_GROUP_LEAVE("set_group_leave", "退出群组"),
    SET_GROUP_SPECIAL_TITLE("set_group_special_title", "设置群组专属头衔"),
    
    // 好友和群组请求
    SET_FRIEND_ADD_REQUEST("set_friend_add_request", "处理加好友请求"),
    SET_GROUP_ADD_REQUEST("set_group_add_request", "处理加群请求/邀请"),
    
    // 信息获取
    GET_LOGIN_INFO("get_login_info", "获取登录号信息"),
    GET_STRANGER_INFO("get_stranger_info", "获取陌生人信息"),
    GET_FRIEND_LIST("get_friend_list", "获取好友列表"),
    GET_GROUP_INFO("get_group_info", "获取群信息"),
    GET_GROUP_LIST("get_group_list", "获取群列表"),
    GET_GROUP_MEMBER_INFO("get_group_member_info", "获取群成员信息"),
    GET_GROUP_MEMBER_LIST("get_group_member_list", "获取群成员列表"),
    GET_GROUP_HONOR_INFO("get_group_honor_info", "获取群荣誉信息"),
    
    // 凭证相关
    GET_COOKIES("get_cookies", "获取 Cookies"),
    GET_CSRF_TOKEN("get_csrf_token", "获取 CSRF Token"),
    GET_CREDENTIALS("get_credentials", "获取 QQ 相关接口凭证"),
    
    // 媒体文件
    GET_RECORD("get_record", "获取语音"),
    GET_IMAGE("get_image", "获取图片"),
    CAN_SEND_IMAGE("can_send_image", "检查是否可以发送图片"),
    CAN_SEND_RECORD("can_send_record", "检查是否可以发送语音"),
    
    // 系统相关
    GET_STATUS("get_status", "获取运行状态"),
    GET_VERSION_INFO("get_version_info", "获取版本信息"),
    CLEAN_CACHE("clean_cache", "清理缓存"),
    
    // 扩展功能
    SET_QQ_PROFILE("set_qq_profile", "设置登录号资料"),
    GET_ONLINE_CLIENTS("get_online_clients", "获取当前账号在线客户端列表"),
    DELETE_FRIEND("delete_friend", "删除好友"),
    MARK_MSG_AS_READ("mark_msg_as_read", "标记消息已读"),
    SEND_GROUP_FORWARD_MSG("send_group_forward_msg", "发送合并转发(群聊)"),
    SEND_PRIVATE_FORWARD_MSG("send_private_forward_msg", "发送合并转发(好友)"),
    GET_GROUP_MSG_HISTORY("get_group_msg_history", "获取群消息历史记录"),
    OCR_IMAGE("ocr_image", "图片 OCR"),
    
    // 群系统消息
    GET_GROUP_SYSTEM_MSG("get_group_system_msg", "获取群系统消息"),
    GET_ESSENCE_MSG_LIST("get_essence_msg_list", "获取精华消息列表"),
    GET_GROUP_AT_ALL_REMAIN("get_group_at_all_remain", "获取群@全体成员剩余次数"),
    SET_GROUP_PORTRAIT("set_group_portrait", "设置群头像"),
    SET_ESSENCE_MSG("set_essence_msg", "设置精华消息"),
    DELETE_ESSENCE_MSG("delete_essence_msg", "移出精华消息"),
    SEND_GROUP_SIGN("send_group_sign", "群打卡"),
    SEND_GROUP_NOTICE("_send_group_notice", "发送群公告"),
    GET_GROUP_NOTICE("_get_group_notice", "获取群公告"),
    
    // 群文件操作
    UPLOAD_GROUP_FILE("upload_group_file", "上传群文件"),
    DELETE_GROUP_FILE("delete_group_file", "删除群文件"),
    CREATE_GROUP_FILE_FOLDER("create_group_file_folder", "创建群文件文件夹"),
    DELETE_GROUP_FOLDER("delete_group_folder", "删除群文件文件夹"),
    GET_GROUP_FILE_SYSTEM_INFO("get_group_file_system_info", "获取群文件系统信息"),
    GET_GROUP_ROOT_FILES("get_group_root_files", "获取群根目录文件列表"),
    GET_GROUP_FILES_BY_FOLDER("get_group_files_by_folder", "获取群子目录文件列表"),
    
    // 其他功能
    SET_ONLINE_STATUS("set_online_status", "设置在线状态"),
    SET_QQ_AVATAR("set_qq_avatar", "设置头像"),
    GET_FILE("get_file", "获取文件信息"),
    TRANSLATE_EN2ZH("translate_en2zh", "英译中翻译"),
    SET_MSG_EMOJI_LIKE("set_msg_emoji_like", "设置消息的表情回复"),
    MARK_PRIVATE_MSG_AS_READ("mark_private_msg_as_read", "标记私聊信息已读"),
    MARK_GROUP_MSG_AS_READ("mark_group_msg_as_read", "标记群聊信息已读"),
    GET_FRIEND_MSG_HISTORY("get_friend_msg_history", "获取私聊记录"),
    CREATE_COLLECTION("create_collection", "创建文本收藏"),
    GET_COLLECTION_LIST("get_collection_list", "获取收藏列表"),
    SET_SELF_LONGNICK("set_self_longnick", "设置个人签名"),
    GET_RECENT_CONTACT("get_recent_contact", "获取最近的聊天记录"),
    MARK_ALL_AS_READ("_mark_all_as_read", "标记所有为已读"),
    GET_PROFILE_LIKE("get_profile_like", "获取自身点赞列表"),
    FETCH_CUSTOM_FACE("fetch_custom_face", "获取收藏表情"),
    FETCH_EMOJI_LIKE("fetch_emoji_like", "拉取表情回应列表"),
    SET_INPUT_STATUS("set_input_status", "设置输入状态"),
    GET_GROUP_INFO_EX("get_group_info_ex", "获取群组额外信息"),
    GET_GROUP_IGNORE_ADD_REQUEST("get_group_ignore_add_request", "获取群组忽略的通知"),
    DEL_GROUP_NOTICE("_del_group_notice", "删除群聊公告"),
    FRIEND_POKE("friend_poke", "私聊戳一戳"),
    GROUP_POKE("group_poke", "群聊戳一戳"),
    NC_GET_PACKET_STATUS("nc_get_packet_status", "获取PacketServer状态"),
    NC_GET_USER_STATUS("nc_get_user_status", "获取陌生人在线状态"),
    NC_GET_RKEY("nc_get_rkey", "获取Rkey"),
    GET_GROUP_SHUT_LIST("get_group_shut_list", "获取群聊被禁言用户"),
    GET_MINI_APP_ARK("get_mini_app_ark", "签名小程序卡片"),
    GET_AI_RECORD("get_ai_record", "AI文字转语音"),
    GET_AI_CHARACTERS("get_ai_characters", "获取AI语音角色列表"),
    SEND_GROUP_AI_RECORD("send_group_ai_record", "群聊发送AI语音"),
    SEND_POKE("send_poke", "群聊/私聊戳一戳");

    final String action;
    final String desc;

    ActionType(String action, String desc) {
        this.action = action;
        this.desc = desc;
    }
}
