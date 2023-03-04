package dev._2lstudios.fish.nbt;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;

class ItemTagDisplay {
    @Expose
    public String name;
}

public class ItemTag extends JsonElement {
    @Expose
    private ItemTagDisplay display;

    public ItemTag() {
        this.display = new ItemTagDisplay();
    }

    public String getName() {
        return this.display.name;
    }

    public ItemTag setName(String name) {
        this.display.name = name;
        return this;
    }

    @Override
    public JsonElement deepCopy() {
        throw new UnsupportedOperationException("Unimplemented method 'deepCopy'");
    }

    public String toString() {
        return this.getAsJsonPrimitive().getAsString();
    }
}
