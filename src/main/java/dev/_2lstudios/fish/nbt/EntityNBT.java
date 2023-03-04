package dev._2lstudios.fish.nbt;

import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.chat.Serializable;

public class EntityNBT extends Serializable implements NBT {
    @Expose
    private String id;
    @Expose
    private String type;
    @Expose
    private String name;

    private EntityType entityType;
    private UUID uuid;

    public EntityNBT(UUID uuid, EntityType type, String name) {
        this.setUUID(uuid);
        this.setType(type);
        this.setName(name);
    }

    public EntityNBT(Entity entity) {
        this(entity.getUniqueId(), entity.getType(), entity.getName());
    }

    public String getName() {
        return this.name;
    }

    public EntityType getType() {
        return this.entityType;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public EntityNBT setName(String name) {
        this.name = name;
        return this;
    }

    public EntityNBT setType(EntityType type) {
        this.type = "minecraft:" + type.name().toLowerCase();
        this.entityType = type;
        return this;
    }

    public EntityNBT setUUID(UUID uuid) {
        this.id = uuid.toString();
        this.uuid = uuid;
        return this;
    }
}
