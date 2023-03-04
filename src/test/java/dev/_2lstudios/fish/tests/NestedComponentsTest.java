package dev._2lstudios.fish.tests;

import org.junit.Test;

import dev._2lstudios.fish.chat.Component;
import dev._2lstudios.fish.chat.TextComponent;

import static org.junit.Assert.assertEquals;

public class NestedComponentsTest {
    private static String RAW_JSON = "{\"extra\":[{\"text\":\"hello\"},{\"bold\":true}]}";

    @Test
    public void derializeTextComponent() {
        Component component = Component.fromJSON(RAW_JSON);
        assertEquals(component.getChildren().size(), 2);
    }

    @Test
    public void serializeTextComponent() {
        Component component = new Component();
        component.addChild(new TextComponent("hello"));
        component.addChild(new Component().bold());
        assertEquals(component.toJSON(), RAW_JSON);
    }
}
