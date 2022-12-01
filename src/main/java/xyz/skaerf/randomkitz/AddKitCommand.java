package xyz.skaerf.randomkitz;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;


public class AddKitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("randomkitz.addkit")) {
                if (args.length != 0) {
                    String kitName = args[0];
                    if (player.getInventory().isEmpty()) {
                        player.sendMessage(ChatColor.RED+"Your inventory is empty! Please put the kit you want in your inventory for the command to function.");
                    }
                    else {
                        Kit kit = new Kit(kitName.toLowerCase());
                        kit.setHelmet(player.getInventory().getHelmet());
                        kit.setChestplate(player.getInventory().getChestplate());
                        kit.setLeggings(player.getInventory().getLeggings());
                        kit.setBoots(player.getInventory().getBoots());
                        kit.setOffHand(player.getInventory().getItemInOffHand());

                        ItemStack[] mainInv = player.getInventory().getContents();
                        kit.setMainInv(mainInv);
                        System.out.println(Arrays.toString(kit.getMainInv()));
                        kit.saveKit();
                        RandomKitz.kits.put(kitName.toLowerCase(), kit);
                        player.sendMessage(ChatColor.GREEN+"New kit saved!");
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED+"Please add what you want the name of the kit to be! /addkit <name>");
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
