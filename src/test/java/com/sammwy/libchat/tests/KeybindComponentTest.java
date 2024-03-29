package com.sammwy.libchat.tests;

import org.junit.Test;

import com.sammwy.libchat.chat.KeybindComponent;

import static org.junit.Assert.assertEquals;

public class KeybindComponentTest {
    private static String RAW_JSON = "{\"keybind\":\"example.key\"}";

    @Test
    public void derializeKeybindComponent() {
        KeybindComponent component = KeybindComponent.fromJSON(RAW_JSON);
        assertEquals(component.getKeybind(), "example.key");
    }

    @Test
    public void serializeKeybindComponent() {
        KeybindComponent component = new KeybindComponent("example.key");
        assertEquals(component.toJSON(), RAW_JSON);
    }
}
