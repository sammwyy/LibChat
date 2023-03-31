package com.sammwy.libchat.chat;

import javax.annotation.Nonnull;

import com.sammwy.libchat.LibChatBukkit;

public class Serializable {
    @Nonnull
    public String toJSON() {
        String json = LibChatBukkit.GSON.toJson(this);
        return json == null ? "{}" : json;
    }
}
