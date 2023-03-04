package dev._2lstudios.fish.chat;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.FishAPI;
import dev._2lstudios.fish.events.ClickEvent;
import dev._2lstudios.fish.events.HoverEvent;

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
    private String color;

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
        return this.color;
    }

    public Font getFont() {
        return this.font;
    }

    public Component bold() {
        this.bold = !this.bold;
        return this;
    }

    public Component color(String color) {
        this.color = color;
        return this;
    }

    public Component italic() {
        this.italic = !this.italic;
        return this;
    }

    public Component underlined() {
        this.underlined = !this.underlined;
        return this;
    }

    public Component strikethrough() {
        this.strikethrough = !this.strikethrough;
        return this;
    }

    public Component obfuscate() {
        this.obfuscated = !this.obfuscated;
        return this;
    }

    public Component setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    public Component setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

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
        return FishAPI.GSON.fromJson(json, Component.class);
    }
}
