package xyz.skaerf.randomkitz;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Kit {

    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private List<ItemStack> hotbar;

    public Kit() {

    }

    void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    void setBoots(ItemStack boots) {
        this.boots = boots;
    }

    void setHotbar(List<ItemStack> hotbar) {
        this.hotbar = hotbar;
    }

    ItemStack getHelmet() {
        return helmet;
    }

    ItemStack getChestplate() {
        return chestplate;
    }

    ItemStack getLeggings() {
        return leggings;
    }

    ItemStack getBoots() {
        return boots;
    }

    List<ItemStack> getHotbar() {
        return hotbar;
    }

    void saveKit() {

    }
}
