package com.sammwy.libchat;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.sammwy.libchat.adapters.BooleanTypeAdapter;
import com.sammwy.libchat.chat.ChatType;
import com.sammwy.libchat.chat.Component;
import com.sammwy.libchat.chat.ComponentBuilder;
import com.sammwy.libchat.utils.PacketUtils;
import com.sammwy.libchat.utils.ServerUtils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.chat.ComponentSerializer;

public class LibChatBukkit {
    public final static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Boolean.class, new BooleanTypeAdapter())
            .create();

    public static void sendRaw(@Nonnull Player player, @Nonnull String json, ChatType type) {
        try {
            if (ServerUtils.hasChatComponentAPI()) {
                ChatMessageType messageType = ChatMessageType.valueOf(type.name());
                player.spigot().sendMessage(messageType, ComponentSerializer.parse(json));
            } else {
                PacketUtils.sendJSON(player, json, type.toByte());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendActionbar(@Nonnull Player player, @Nonnull Component component) {
        LibChatBukkit.sendRaw(player, component.toJSON(), ChatType.ACTION_BAR);
    }

    public static void sendActionbar(@Nonnull Player player, @Nonnull String text) {
        Component json = ComponentBuilder.fromString(text);
        if (json != null) {
            LibChatBukkit.sendActionbar(player, json);
        }
    }

    public static void sendMessage(@Nonnull Player player, @Nonnull Component component) {
        LibChatBukkit.sendRaw(player, component.toJSON(), ChatType.CHAT);
    }

    public static void sendMessage(@Nonnull Player player, @Nonnull String text) {
        Component json = ComponentBuilder.fromString(text);
        if (json != null) {
            LibChatBukkit.sendMessage(player, json);
        }
    }
}
