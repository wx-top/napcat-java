package icu.wenxin.napcat.enums;

import icu.wenxin.napcat.interfaces.MessageData;
import icu.wenxin.napcat.message.data.*;
import lombok.Getter;

@Getter
public enum MessageType {

    TEXT("text", Text.class),
    FACE("face", Face.class),
    IMAGE("image", Image.class),
    FILE("file", File.class),
    MUSIC("music", Music.class),
    MFACE("mface", MFace.class),
    NODE("node", Node.class),
    AT("at", At.class),
    RPS("rps", Rps.class),
    DICE("dice", Dice.class),
    CONTACT("contact", Contact.class),
    FORWARD("forward", Forward.class),
    REPLY("reply", Reply.class),
    RECORD("record", Record.class),
    VIDEO("video", Video.class);

    private final String type;
    private final Class<? extends MessageData> dataClass;

    MessageType(String type, Class<? extends MessageData> dataClass) {
        this.type = type;
        this.dataClass = dataClass;
    }

    public static MessageType getMessageTypeByName(String type) {
        for (MessageType messageType : values()) {
            if (messageType.type.equals(type)) {
                return messageType;
            }
        }
        return null;
    }

}
