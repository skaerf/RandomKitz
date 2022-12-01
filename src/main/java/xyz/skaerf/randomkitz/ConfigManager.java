package xyz.skaerf.randomkitz;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ConfigManager {

    static HashMap<Kit, FileConfiguration> kitFileList = new HashMap<>();

    public static void createKitFile(Kit kit) {
        File kitFile = new File(RandomKitz.getPlugin(RandomKitz.class).getDataFolder(), kit.getKitName()+".yml");
        FileConfiguration kitCFG;
        if (!kitFile.exists()) {
            try {
                if (kitFile.createNewFile()) {
                    System.out.println(kitFile+" created successfully");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            kitCFG = YamlConfiguration.loadConfiguration(kitFile);
            kitFileList.put(kit, kitCFG);
            addThingsToKitFile(kit);
        }
        else {
            kitCFG = YamlConfiguration.loadConfiguration(kitFile);
            kitFileList.put(kit, kitCFG);
            saveKitFile(kit);
        }
    }

    private static void addThingsToKitFile(Kit kit) {
        FileConfiguration kitCFG = getKitFile(kit);
        List<String> enchantments = new ArrayList<>();
        kitCFG.set("armor.helmet.material", kit.getHelmet().getType().toString());
        kitCFG.set("armor.helmet.meta.name", kit.getHelmet().getItemMeta().getDisplayName());
        kitCFG.set("armor.helmet.meta.lore", kit.getHelmet().getItemMeta().getLore());
        if (!kit.getHelmet().getItemMeta().getEnchants().isEmpty()) {
            for (Map.Entry<Enchantment, Integer> set : kit.getHelmet().getItemMeta().getEnchants().entrySet()) {
                enchantments.add(set.getKey().getKey().getKey()+":"+set.getValue().toString());
            }
        }
        kitCFG.set("armor.helmet.meta.enchantments", enchantments);
        enchantments.clear();
        kitCFG.set("armor.chestplate.material", kit.getChestplate().getType().toString());
        kitCFG.set("armor.chestplate.meta.name", kit.getChestplate().getItemMeta().getDisplayName());
        kitCFG.set("armor.chestplate.meta.lore", kit.getChestplate().getItemMeta().getLore());
        if (!kit.getChestplate().getItemMeta().getEnchants().isEmpty()) {
            for (Map.Entry<Enchantment, Integer> set : kit.getChestplate().getItemMeta().getEnchants().entrySet()) {
                enchantments.add(set.getKey().getKey().getKey()+":"+set.getValue().toString());
            }
        }
        kitCFG.set("armor.chestplate.meta.enchantments", enchantments);
        enchantments.clear();
        kitCFG.set("armor.leggings.material", kit.getLeggings().getType().toString());
        kitCFG.set("armor.leggings.meta.name", kit.getLeggings().getItemMeta().getDisplayName());
        kitCFG.set("armor.leggings.meta.lore", kit.getLeggings().getItemMeta().getLore());
        if (!kit.getLeggings().getItemMeta().getEnchants().isEmpty()) {
            for (Map.Entry<Enchantment, Integer> set : kit.getLeggings().getItemMeta().getEnchants().entrySet()) {
                enchantments.add(set.getKey().getKey().getKey()+":"+set.getValue().toString());
            }
        }
        kitCFG.set("armor.leggings.meta.enchantments", enchantments);
        enchantments.clear();
        kitCFG.set("armor.boots.material", kit.getBoots().getType().toString());
        kitCFG.set("armor.boots.meta.name", kit.getBoots().getItemMeta().getDisplayName());
        kitCFG.set("armor.boots.meta.lore", kit.getBoots().getItemMeta().getLore());
        if (!kit.getBoots().getItemMeta().getEnchants().isEmpty()) {
            for (Map.Entry<Enchantment, Integer> set : kit.getBoots().getItemMeta().getEnchants().entrySet()) {
                enchantments.add(set.getKey().getKey().getKey()+":"+set.getValue().toString());
            }
        }
        kitCFG.set("armor.boots.meta.enchantments", enchantments);
        enchantments.clear();
        kitCFG.set("offhand.material", kit.getOffHand().getType().toString());
        kitCFG.set("offhand.meta.name", kit.getOffHand().getItemMeta().getDisplayName());
        kitCFG.set("offhand.meta.lore", kit.getOffHand().getItemMeta().getLore());
        if (!kit.getOffHand().getItemMeta().getEnchants().isEmpty()) {
            for (Map.Entry<Enchantment, Integer> set : kit.getOffHand().getItemMeta().getEnchants().entrySet()) {
                enchantments.add(set.getKey().getKey().getKey()+":"+set.getValue().toString());
            }
        }
        kitCFG.set("offhand.meta.enchantments", enchantments);
        for (ItemStack i : kit.getMainInv()) {

        }
        saveKitFile(kit);
        reloadKitFile(kit);
    }

    public static FileConfiguration getKitFile(Kit kit) {
        File kitFile = new File(RandomKitz.getPlugin(RandomKitz.class).getDataFolder(), kit.getKitName()+".yml");
        if (!kitFile.exists()) {
            System.out.println(kit.getKitName()+".yml does not exist - cannot be called");
        }
        else {
            FileConfiguration thing = YamlConfiguration.loadConfiguration(kitFile);
            kitFileList.put(kit, thing);
            return thing;
        }
        return null;
    }

    public static void saveKitFile(Kit kit) {
        File kitFile = new File(RandomKitz.getPlugin(RandomKitz.class).getDataFolder(), kit.getKitName()+".yml");
        if (kitFileList.get(kit) != null) {
            try {
                kitFileList.get(kit).save(kitFile);
                System.out.println(kit.getKitName()+".yml file saved successfully");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(kit.getKitName()+".yml does not exist, cannot be saved");
        }
    }

    public static void reloadKitFile(Kit kit) {
        File kitFile = new File(RandomKitz.getPlugin(RandomKitz.class).getDataFolder(), kit.getKitName()+".yml");
        if (kitFileList.get(kit) != null) {
            kitFileList.remove(kit);
            kitFileList.put(kit, YamlConfiguration.loadConfiguration(kitFile));
        }
        else {
            System.out.println(kit.getKitName()+".yml does not exist, cannot be reloaded");
        }
    }

}
