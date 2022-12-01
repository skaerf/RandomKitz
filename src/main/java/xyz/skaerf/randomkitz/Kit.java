package xyz.skaerf.randomkitz;

import org.bukkit.inventory.ItemStack;


public class Kit {

    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private ItemStack offhand;
    private ItemStack[] mainInv;
    private final String kitName;

    public Kit(String kitName) {
        this.kitName = kitName;
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

    void setOffHand(ItemStack offhand) {
        this.offhand = offhand;
    }
    void setMainInv(ItemStack[] mainInv) {
        this.mainInv = mainInv;
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

    ItemStack getOffHand() {
        return offhand;
    }

    ItemStack[] getMainInv() {
        return mainInv;
    }

    String getKitName() {
        return this.kitName;
    }

    void saveKit() {
        ConfigManager.createKitFile(this);
    }
}
