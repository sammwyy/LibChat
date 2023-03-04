package dev._2lstudios.fish.tests;

import org.junit.Test;

import dev._2lstudios.fish.chat.Component;
import dev._2lstudios.fish.chat.TextComponent;

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
