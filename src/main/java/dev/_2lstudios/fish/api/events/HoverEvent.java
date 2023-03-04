package dev._2lstudios.fish.api.events;

import org.bukkit.entity.Entity;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.api.Serializable;
import dev._2lstudios.fish.api.nbt.EntityNBT;

public class HoverEvent extends Serializable {
    @Expose
    private String action;
    @Expose
    private Serializable value;

    private HoverEventType type;

    public HoverEvent(HoverEventType type, Serializable value) {
        this.setType(type);
        this.setValue(value);
    }

    public HoverEventType getType() {
        return this.type;
    }

    public Serializable getValue() {
        return this.value;
    }

    public HoverEvent setType(HoverEventType type) {
        this.action = type.name().toLowerCase();
        this.type = type;
        return this;
    }

    public HoverEvent setValue(Serializable value) {
        this.value = value;
        return this;
    }

    public HoverEvent setValue(Entity entity) {
        return this.setValue(new EntityNBT(entity));
    }
}
