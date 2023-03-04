package dev._2lstudios.fish.api;

public class ComponentBuilder {
    public final static char ALT_COLOR_CHAR = '&';
    public final static char COLOR_CHAR = '§';

    private TextComponent root;
    private TextComponent parent;
    private TextComponent child;

    public ComponentBuilder() {
        this.root = new TextComponent("");
        this.parent = new TextComponent("");
        this.child = new TextComponent("");
    }

    public TextComponent pushChild() {
        if (this.child != null) {
            this.parent.addChild(this.child);
            this.child = new TextComponent("");
        }

        return this.child;
    }

    public TextComponent pushChildIfNotEmpty() {
        if (!this.child.getText().isEmpty()) {
            this.pushChild();
        }

        return this.child;
    }

    public TextComponent pushParent() {
        if (this.parent != null) {
            this.pushChild();
            this.root.addChild(this.parent);
        }

        this.parent = new TextComponent("");
        return this.parent;
    }

    public TextComponent pushParentIfNotEmpty() {
        if (this.parent.getChildrenCount() > 1) {
            this.pushParent();
        }

        return this.parent;
    }

    public ComponentBuilder appendText(String text) {
        this.child.setText(this.child.getText() + text);
        return this;
    }

    public ComponentBuilder appendChar(char chr) {
        return this.appendText(String.valueOf(chr));
    }

    public TextComponent reset() {
        return this.pushParent();
    }

    public TextComponent resetIfEmpty() {
        return this.pushParentIfNotEmpty();
    }

    public ComponentBuilder bold() {
        this.resetIfEmpty().bold();
        return this;
    }

    public ComponentBuilder italic() {
        this.resetIfEmpty().italic();
        return this;
    }

    public ComponentBuilder underlined() {
        this.resetIfEmpty().underlined();
        return this;
    }

    public ComponentBuilder strikethrough() {
        this.resetIfEmpty().strikethrough();
        return this;
    }

    public ComponentBuilder obfuscate() {
        this.resetIfEmpty().obfuscate();
        return this;
    }

    public ComponentBuilder setColor(String color) {
        this.pushChildIfNotEmpty();
        this.child.color(color);
        return this;
    }

    public ComponentBuilder setColor(char color) {
        return this.setColor(String.valueOf(color));
    }

    public ComponentBuilder setDecoration(char decoration) {
        if (decoration == 'l') {
            this.bold();
        } else if (decoration == 'o') {
            this.italic();
        } else if (decoration == 'n') {
            this.underlined();
        } else if (decoration == 'm') {
            this.strikethrough();
        } else if (decoration == 'k') {
            this.obfuscate();
        } else if (decoration == 'r') {
            this.reset();
        }

        return this;
    }

    public Component build() {
        // Remove child if is unnecessary.
        if (this.child != null) {
            if (this.parent.getChildrenCount() == 0 && !this.parent.hasStyle()) {
                this.parent = this.child;
            } else {
                this.parent.addChild(this.child);
            }
            this.child = null;
        }

        // Remove parent if is unnecessary.
        if (this.parent != null) {
            if (this.root.getChildrenCount() == 0 && !this.root.hasStyle()) {
                this.root = this.parent;
            } else {
                this.root.addChild(this.parent);
            }
            this.parent = null;
        }

        return this.root;
    }

    public static Component fromString(String raw) {
        ComponentBuilder builder = new ComponentBuilder();
        boolean selecting_color = false;

        for (char chr : raw.toCharArray()) {
            if (selecting_color) {
                char lower = Character.toLowerCase(chr);
                if (lower >= '0' && lower <= 'f') {
                    builder.setColor(lower);
                } else if (lower >= 'k' && lower <= 'r') {
                    builder.setDecoration(lower);
                }

                selecting_color = false;
                continue;
            }

            if (chr == COLOR_CHAR) {
                selecting_color = true;
                continue;
            }

            builder.appendChar(chr);
        }

        return builder.build();
    }
}
