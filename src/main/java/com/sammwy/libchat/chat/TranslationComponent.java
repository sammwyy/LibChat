package com.sammwy.libchat.chat;

import com.google.gson.annotations.Expose;

import com.sammwy.libchat.LibChatBukkit;

public class TranslationComponent extends Component {
    @Expose
    private String translate;

    public TranslationComponent(String translateKey) {
        this.translate = translateKey;
    }

    public String getTranslateKey() {
        return this.translate;
    }

    public TranslationComponent setTranslateKey(String translateKey) {
        this.translate = translateKey;
        return this;
    }

    public static TranslationComponent fromJSON(String json) {
        return LibChatBukkit.GSON.fromJson(json, TranslationComponent.class);
    }
}
