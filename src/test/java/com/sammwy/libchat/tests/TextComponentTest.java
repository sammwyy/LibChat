package com.sammwy.libchat.tests;

import org.junit.Test;

import com.sammwy.libchat.chat.Component;
import com.sammwy.libchat.chat.TextComponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextComponentTest {
    private static String RAW_JSON = "{\"text\":\"Hello World\",\"bold\":true}";

    @Test
    public void derializeTextComponent() {
        TextComponent component = TextComponent.fromJSON(RAW_JSON);
        assertEquals(component.getText(), "Hello World");
        assertTrue(component.isBold());
    }

    @Test
    public void serializeTextComponent() {
        Component component = new TextComponent("Hello World").bold();
        assertEquals(component.toJSON(), RAW_JSON);
    }
}
