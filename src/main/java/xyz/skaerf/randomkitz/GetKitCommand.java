package xyz.skaerf.randomkitz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class GetKitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Please rerun with args");
            for (Kit kit : RandomKitz.kits.values()) {
                System.out.println(Arrays.toString(kit.getMainInv()));
            }
        }
        else {
            String kit = args[0];
            Kit kitkat = RandomKitz.kits.get(kit.toLowerCase());
            RandomKitz.giveKit(kitkat, (Player) sender);
        }
        return true;
    }
}
