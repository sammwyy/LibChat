package dev._2lstudios.fish.tests;

import org.junit.Test;

import dev._2lstudios.fish.api.Component;
import dev._2lstudios.fish.api.TextComponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StylishedComponentTest {
    private static String RAW_JSON = "{\"bold\":true,\"italic\":true,\"strikethrough\":true,\"obfuscated\":true}";

    @Test
    public void derializeTextComponent() {
        Component component = TextComponent.fromJSON(RAW_JSON);
        assertTrue(component.isBold());
        assertTrue(component.isItalic());
        assertTrue(component.isStrikeThrough());
        assertTrue(component.isObfuscated());
        assertFalse(component.isUnderlined());
    }

    @Test
    public void serializeTextComponent() {
        Component component = new Component().bold().italic().obfuscate().strikethrough();
        assertEquals(component.toJSON(), RAW_JSON);
    }
}
