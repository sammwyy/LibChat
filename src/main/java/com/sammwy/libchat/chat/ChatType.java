package com.sammwy.libchat.chat;

public enum ChatType {
    CHAT((byte) 0),
    SYSTEM((byte) 1),
    ACTION_BAR((byte) 2);

    private byte b;

    private ChatType(byte b) {
        this.b = b;
    }

    public byte toByte() {
        return this.b;
    }

    public static ChatType fromByte(byte b) {
        switch (b) {
            case 0:
                return CHAT;
            case 1:
                return SYSTEM;
            case 2:
                return ACTION_BAR;
            default:
                return CHAT;
        }
    }
}
