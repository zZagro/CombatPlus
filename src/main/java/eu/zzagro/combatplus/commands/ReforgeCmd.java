package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReforgeCmd implements CommandExecutor {

    private final CombatPlus plugin;

    public ReforgeCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (plugin.getConfig().getBoolean("ReforgeCommand")) {
                if (player.hasPermission(plugin.getConfig().getString("Permissions.Reforge"))) {
                    if (args.length == 0) {
                        plugin.reforgeInv.openReforge(player);
                    }
                } else {
                    player.sendMessage(plugin.noPerms);
                }
            } else {
                player.sendMessage(plugin.prefix + ChatColor.RED + "You have to use the Reforge Anvil to reforge an item!");
            }
        }
        return false;
    }
}
