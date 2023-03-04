package dev._2lstudios.fish.tests;

import org.junit.Test;

import dev._2lstudios.fish.chat.Component;
import dev._2lstudios.fish.chat.ComponentBuilder;

import static org.junit.Assert.assertEquals;

public class ComponentBuilderTest {
    @Test
    public void parsePlain() {
        Component component = ComponentBuilder.fromString("Hello World");
        assertEquals(component.toJSON(), "{\"text\":\"Hello World\"}");
    }

    @Test
    public void parseSingleColor() {
        Component component = ComponentBuilder.fromString("§aHello World");
        assertEquals(component.toJSON(), "{\"text\":\"Hello World\",\"color\":\"a\"}");
    }

    @Test
    public void parseMultipleColors() {
        Component component = ComponentBuilder.fromString("§aHello §bWorld");
        assertEquals(component.toJSON(),
                "{\"text\":\"\",\"extra\":[{\"text\":\"Hello \",\"color\":\"a\"},{\"text\":\"World\",\"color\":\"b\"}]}");
    }

    @Test
    public void parseDecoration() {
        Component component = ComponentBuilder.fromString("§lHello World");
        assertEquals(component.toJSON(), "{\"text\":\"\",\"extra\":[{\"text\":\"Hello World\"}],\"bold\":true}");
    }
}
