package xyz.skaerf.randomkitz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetKitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args == null) {
            sender.sendMessage("Please rerun with args");
        }
        else {
            String kit = args[0];
            Kit kitkat = RandomKitz.kits.get(kit);
            RandomKitz.giveKit(kitkat, (Player) sender);
        }
        return true;
    }
}
