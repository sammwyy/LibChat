package dev._2lstudios.fish.api.events;

public enum HoverEventType {
    /**
     * Display a text. Requires a {@link dev._2lstudios.fish.api.TextComponent
     * TextComponent} as value.
     */
    SHOW_TEXT,

    /**
     * Display an item. Requires an {@link dev._2lstudios.fish.api.nbt.ItemNBT
     * ItemNBT} as value.
     */
    SHOW_ITEM,

    /**
     * Display an entity. Requires an {@link dev._2lstudios.fish.api.nbt.EntityNBT
     * ItemNBT} as value.
     */
    SHOW_ENTITY,

    /**
     * @deprecated Since 1.12, this no longer exists; advancements instead simply
     *             use show_text
     */
    @Deprecated
    SHOW_ACHIEVEMENT
}
