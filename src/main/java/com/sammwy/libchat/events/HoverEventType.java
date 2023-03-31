package com.sammwy.libchat.events;

public enum HoverEventType {
    /**
     * Display a text. Requires a {@link com.sammwy.libchat.api.TextComponent
     * TextComponent} as value.
     */
    SHOW_TEXT,

    /**
     * Display an item. Requires an {@link com.sammwy.libchat.api.nbt.ItemNBT
     * ItemNBT} as value.
     */
    SHOW_ITEM,

    /**
     * Display an entity. Requires an
     * {@link com.sammwy.libchat.api.nbt.EntityNBT
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
