package dev._2lstudios.fish.api.nbt;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.google.gson.annotations.Expose;

import dev._2lstudios.fish.api.Serializable;

public class ItemNBT extends Serializable implements NBT {
    @Expose
    private String id;
    @Expose
    private int count;
    @Expose
    private String tag;

    private ItemTag itemTag;
    private Material material;

    public ItemNBT(Material material, int amount, ItemTag tag) {
        this.setMaterial(material);
        this.count = amount;
        this.setTag(tag);
    }

    public ItemNBT(Material material, int amount) {
        this(material, amount, new ItemTag());
    }

    public ItemNBT(Material material, int amount, String displayName) {
        this(material, amount);
        this.setName(displayName);
    }

    public ItemNBT(ItemStack item) {
        this(item.getType(), item.getAmount(), item.getItemMeta().getDisplayName());
    }

    public int getAmount() {
        return this.count;
    }

    public Material getMaterial() {
        return this.material;
    }

    public String getName() {
        return this.itemTag.getName();
    }

    public ItemTag getTag() {
        return this.itemTag;
    }

    public ItemNBT setAmount(int amount) {
        this.count = amount;
        return this;
    }

    public ItemNBT setMaterial(Material material) {
        this.id = "minecraft:" + material.name().toLowerCase();
        this.material = material;
        return this;
    }

    public ItemNBT setName(String name) {
        this.setTag(this.getTag().setName(name));
        return this;
    }

    public ItemNBT setTag(ItemTag tag) {
        this.itemTag = tag;
        this.tag = tag.toString();
        return this;
    }
}
