package com.sammwy.libchat.chat;

public enum Font {
    UNICODE("minecraft:uniform"),
    ENCHANTING_TABLE("minecraft:alt"),
    DEFAULT("minecraft:default");

    private String name;

    Font(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
