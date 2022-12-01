package xyz.skaerf.randomkitz;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class RandomKitz extends JavaPlugin implements Listener {

    List<String> playerList;
    static HashMap<String, Kit> kits = new HashMap<>();
    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        logger.info("Starting RandomKitz");
        saveConfig();
        playerList = getConfig().getStringList("players");
        for (String i : getConfig().getStringList("kits")) {
            // TODO parse config StringLists into kits
        }
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("addkit").setExecutor(new AddKitCommand());
        getCommand("getkit").setExecutor(new GetKitCommand());
    }

    @Override
    public void onDisable() {
        saveConfig();
        logger.info("Quitting RandomKitz");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!playerList.contains(player.getUniqueId().toString())) {
            giveRandomKit(player);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        giveRandomKit(event.getEntity().getPlayer());
    }

    public void giveRandomKit(Player player) {
        List<String> keySet = new ArrayList<>(kits.keySet());
        String kitOption = keySet.get(new Random().nextInt(keySet.size()));
        Kit kit = kits.get(kitOption);
        giveKit(kit, player);
    }

    public static void giveKit(Kit kit, Player player) {
        player.getInventory().setItemInOffHand(kit.getOffHand());
        player.updateInventory();
        List<ItemStack> temp = new ArrayList<>();
        ItemStack[] contents = kit.getMainInv();
        for (ItemStack it : contents) {
            if ( it != null ) temp.add(it.clone());
            else temp.add(null);
        }
        player.getInventory().setContents(temp.toArray(new ItemStack[0]));
        player.updateInventory();
        player.sendMessage(ChatColor.GREEN+"Kit given!");
    }
}
