package dev._2lstudios.fish.api;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.FishAPI;

public class TextComponent extends StylishedComponent {
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
        return FishAPI.GSON.fromJson(json, TextComponent.class);
    }
}
