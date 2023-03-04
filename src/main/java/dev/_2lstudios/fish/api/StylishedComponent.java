package dev._2lstudios.fish.api;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.FishAPI;

public class StylishedComponent extends Component {
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

    public StylishedComponent setBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public StylishedComponent setItalic(boolean italic) {
        this.italic = italic;
        return this;
    }

    public StylishedComponent setUnderlined(boolean underlined) {
        this.underlined = underlined;
        return this;
    }

    public StylishedComponent setStrikeThrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public StylishedComponent setObfuscated(boolean obfuscated) {
        this.obfuscated = obfuscated;
        return this;
    }

    public StylishedComponent setColor(String color) {
        this.color = color;
        return this;
    }

    public StylishedComponent setFont(Font font) {
        this.font = font;
        return this;
    }

    public StylishedComponent bold() {
        return this.setBold(true);
    }

    public StylishedComponent italic() {
        return this.setItalic(true);
    }

    public StylishedComponent underlined() {
        return this.setUnderlined(true);
    }

    public StylishedComponent strikethrough() {
        return this.setStrikeThrough(true);
    }

    public StylishedComponent obfuscate() {
        return this.setObfuscated(true);
    }

    public static StylishedComponent fromJSON(String json) {
        return FishAPI.GSON.fromJson(json, StylishedComponent.class);
    }
}
