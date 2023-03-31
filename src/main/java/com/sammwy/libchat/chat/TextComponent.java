package com.sammwy.libchat.chat;

import com.google.gson.annotations.Expose;

import com.sammwy.libchat.LibChatBukkit;

public class TextComponent extends Component {
    @Expose
    private String text;

    public TextComponent(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public TextComponent setText(String text) {
        this.text = text;
        return this;
    }

    public static TextComponent fromJSON(String json) {
        return LibChatBukkit.GSON.fromJson(json, TextComponent.class);
    }
}
