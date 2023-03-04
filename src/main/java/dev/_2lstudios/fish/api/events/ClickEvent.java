package dev._2lstudios.fish.api.events;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.api.Serializable;

public class ClickEvent extends Serializable {
    @Expose
    private String action;
    @Expose
    private String value;

    private ClickEventType type;

    public ClickEvent(ClickEventType type, String value) {
        this.setType(type);
        this.setValue(value);
    }

    public ClickEventType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public ClickEvent setType(ClickEventType type) {
        this.action = type.name().toLowerCase();
        this.type = type;
        return this;
    }

    public ClickEvent setValue(String value) {
        this.value = value;
        return this;
    }
}
