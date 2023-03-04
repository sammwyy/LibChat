package dev._2lstudios.fish.api;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.FishAPI;

public class KeybindComponent extends Component {
    @Expose
    private String keybind;

    public KeybindComponent(String keybind) {
        this.keybind = keybind;
    }

    public String getKeybind() {
        return this.keybind;
    }

    public KeybindComponent setKeybind(String keybind) {
        this.keybind = keybind;
        return this;
    }

    public static KeybindComponent fromJSON(String json) {
        return FishAPI.GSON.fromJson(json, KeybindComponent.class);
    }
}
