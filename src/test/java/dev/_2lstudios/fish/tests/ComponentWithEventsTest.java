package dev._2lstudios.fish.tests;

import org.junit.Test;

import dev._2lstudios.fish.chat.Component;
import dev._2lstudios.fish.chat.TextComponent;
import dev._2lstudios.fish.events.ClickEvent;
import dev._2lstudios.fish.events.ClickEventType;
import dev._2lstudios.fish.events.HoverEvent;
import dev._2lstudios.fish.events.HoverEventType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComponentWithEventsTest {
    private static String RAW_JSON = "{\"text\":\"Hello World\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/command\",\"type\":\"RUN_COMMAND\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"foobar\"},\"type\":\"SHOW_TEXT\"},\"bold\":true}";

    @Test
    public void derializeTextComponent() {
        TextComponent component = TextComponent.fromJSON(RAW_JSON);
        assertEquals(component.getText(), "Hello World");
        assertEquals(component.getClickEvent().getType(), ClickEventType.RUN_COMMAND);
        assertEquals(component.getClickEvent().getValue(), "/command");
        assertEquals(component.getHoverEvent().getType(), HoverEventType.SHOW_TEXT);
        assertTrue(component.isBold());
    }

    @Test
    public void serializeTextComponent() {
        Component component = new TextComponent("Hello World").bold();
        component.setClickEvent(new ClickEvent(ClickEventType.RUN_COMMAND, "/command"));
        component.setHoverEvent(new HoverEvent(HoverEventType.SHOW_TEXT, new TextComponent("foobar")));
        assertEquals(component.toJSON(), RAW_JSON);
    }
}
