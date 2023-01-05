package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMaxManaCmd implements CommandExecutor {

    private final CombatPlus plugin;

    public SetMaxManaCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("setmaxmana")) {
                if (player.hasPermission(plugin.getConfig().getString("Permissions.SetMaxMana"))) {
                    if (args.length == 1 && isInt(args[0])) {
                        int maxMana = Integer.parseInt(args[0]);
                        if (maxMana > 0) {
                            plugin.mana.setMaxMana(player, maxMana);
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cThe amount has to be greater or equal to 1!"));
                        }
                    } else if (args.length == 2 && isInt(args[0])) {
                        int maxMana = Integer.parseInt(args[0]);
                        Player target = Bukkit.getPlayerExact(args[1]);
                        if (target == null) {
                            player.sendMessage(plugin.prefix + plugin.color("&cPlayer not found!"));
                        }
                        if (maxMana > 0) {
                            plugin.mana.setMaxMana(target, maxMana);
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cThe amount has to be greater or equal to 1!"));
                        }
                    } else {
                        player.sendMessage(plugin.prefix + plugin.color("&cUsage: /setmaxmana <amount> <player>"));
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
