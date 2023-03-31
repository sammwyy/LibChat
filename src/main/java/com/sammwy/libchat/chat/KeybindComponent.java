package com.sammwy.libchat.chat;

import com.google.gson.annotations.Expose;

import com.sammwy.libchat.LibChatBukkit;

public class KeybindComponent extends Component {
    @Expose
    private String keybind;

    public KeybindComponent(String keybind) {
        this.keybind = keybind;
    }

    public String getKeybind() {
        return this.keybind;
    }

    public KeybindComponent setKeybind(String keybind) {
        this.keybind = keybind;
        return this;
    }

    public static KeybindComponent fromJSON(String json) {
        return LibChatBukkit.GSON.fromJson(json, KeybindComponent.class);
    }
}
