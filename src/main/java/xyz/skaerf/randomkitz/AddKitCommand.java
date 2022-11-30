package xyz.skaerf.randomkitz;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AddKitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("randomkitz.addkit")) {
                if (player.getInventory().isEmpty()) {
                    player.sendMessage(ChatColor.RED+"Your inventory is empty! Please put the kit you want in your inventory for the command to function.");
                }
                else {
                    Kit kit = new Kit();
                    kit.setHelmet(player.getInventory().getHelmet());
                    kit.setChestplate(player.getInventory().getChestplate());
                    kit.setLeggings(player.getInventory().getLeggings());
                    kit.setBoots(player.getInventory().getBoots());

                    List<ItemStack> hotbar = new ArrayList<>();
                    for (int i = 0; i <= 8; i++) {
                        hotbar.add(player.getInventory().getItem(i));
                    }
                    kit.saveKit();
                    player.sendMessage(ChatColor.GREEN+"New kit saved!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED+"You do not have permission to perform this command!");
            }
        }
        else {
            sender.sendMessage("[RandomKitz] Only a player can perform this command as the plugin must read the items that are in the player's inventory.");
        }
        return true;
    }
}
