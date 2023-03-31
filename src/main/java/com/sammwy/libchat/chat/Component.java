package com.sammwy.libchat.chat;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.annotations.Expose;

import com.sammwy.libchat.LibChatBukkit;
import com.sammwy.libchat.events.ClickEvent;
import com.sammwy.libchat.events.HoverEvent;

public class Component extends Serializable {
    @Expose
    private List<Component> extra;

    // Events
    @Expose
    private ClickEvent clickEvent;
    @Expose
    private HoverEvent hoverEvent;
    @Expose
    private String insertion;

    // Styles
    @Expose
    private boolean bold;
    @Expose
    private boolean italic;
    @Expose
    private boolean underlined;
    @Expose
    private boolean strikethrough;
    @Expose
    private boolean obfuscated;
    @Expose
    private Font font;
    @Expose
    private ChatColor color;

    @Nonnull
    public Component addChild(Component child) {
        if (this.extra == null) {
            this.extra = new ArrayList<>();
        }

        this.extra.add(child);
        return this;
    }

    public Component getChild(int index) {
        return this.extra.get(index);
    }

    public ClickEvent getClickEvent() {
        return this.clickEvent;
    }

    public HoverEvent getHoverEvent() {
        return this.hoverEvent;
    }

    public List<Component> getChildren() {
        return this.extra;
    }

    public int getChildrenCount() {
        return this.extra == null ? 0 : this.extra.size();
    }

    public String getInsertion() {
        return this.insertion;
    }

    public boolean isBold() {
        return this.bold;
    }

    public boolean isItalic() {
        return this.italic;
    }

    public boolean isUnderlined() {
        return this.underlined;
    }

    public boolean isStrikeThrough() {
        return this.strikethrough;
    }

    public boolean isObfuscated() {
        return this.obfuscated;
    }

    public String getColor() {
        if (this.color != null) {
            return this.color.name();
        } else {
            return null;
        }
    }

    public Font getFont() {
        return this.font;
    }

    @Nonnull
    public Component bold() {
        this.bold = !this.bold;
        return this;
    }

    @Nonnull
    public Component color(ChatColor color) {
        this.color = color;
        return this;
    }

    @Nonnull
    public Component italic() {
        this.italic = !this.italic;
        return this;
    }

    @Nonnull
    public Component underlined() {
        this.underlined = !this.underlined;
        return this;
    }

    @Nonnull
    public Component strikethrough() {
        this.strikethrough = !this.strikethrough;
        return this;
    }

    @Nonnull
    public Component obfuscate() {
        this.obfuscated = !this.obfuscated;
        return this;
    }

    @Nonnull
    public Component setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    @Nonnull
    public Component setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    @Nonnull
    public Component setInsertion(String insertion) {
        this.insertion = insertion;
        return this;
    }

    public boolean hasStyle() {
        return this.color != null
                || this.bold
                || this.italic
                || this.obfuscated
                || this.strikethrough
                || this.underlined;
    }

    public static Component fromJSON(String json) {
        return LibChatBukkit.GSON.fromJson(json, Component.class);
    }
}
