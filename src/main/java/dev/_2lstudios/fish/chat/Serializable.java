package dev._2lstudios.fish.chat;

import dev._2lstudios.fish.FishAPI;

public class Serializable {
    public String toJSON() {
        return FishAPI.GSON.toJson(this);
    }
}
