package dev._2lstudios.fish.api;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.FishAPI;

public class Component extends Serializable {
    @Expose
    private String insertion;

    @Expose
    private List<Component> extra;

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

    public List<Component> getChildren() {
        return this.extra;
    }

    public String getInsertion() {
        return this.insertion;
    }

    public Component setInsertion(String insertion) {
        this.insertion = insertion;
        return this;
    }

    public static Component fromJSON(String json) {
        return FishAPI.GSON.fromJson(json, Component.class);
    }
}
