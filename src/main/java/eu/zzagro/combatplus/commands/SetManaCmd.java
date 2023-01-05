package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetManaCmd implements CommandExecutor {

    private final CombatPlus plugin;

    public SetManaCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("setmana")) {
                if (player.hasPermission(plugin.getConfig().getString("Permissions.SetMana"))) {
                    if (args.length == 1 && isInt(args[0])) {
                        int mana = Integer.parseInt(args[0]);
                        if (mana > 0 && mana <= plugin.mana.getMaxMana(player)) {
                            plugin.mana.setCurrentMana(player, mana);
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cThe amount has to be greater or equal to 1 and cannot be greater than you max Mana amount!"));
                        }
                    } else if (args.length == 2 && isInt(args[0])) {
                        int mana = Integer.parseInt(args[0]);
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target == null) {
                            player.sendMessage(plugin.prefix + plugin.color("&cPlayer not found!"));
                        }
                        if (mana > 0 && mana <= plugin.mana.getMaxMana(target)) {
                            plugin.mana.setCurrentMana(target, mana);
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cThe amount has to be greater or equal to 1 and cannot be greater than you max Mana amount!"));
                        }
                    } else {
                        player.sendMessage(plugin.prefix + plugin.color("&cUsage: /setmana <amount> <player>"));
                    }
                } else {
                    player.sendMessage(plugin.noPerms);
                }
            }
        }
        return false;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
