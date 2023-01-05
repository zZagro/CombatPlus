package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CombatPlusCmd implements CommandExecutor {

    private final CombatPlus plugin;

    public CombatPlusCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    File config = new File("plugins/CombatPlus/config.yml");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("combatplus")) {
                if (player.hasPermission(plugin.getConfig().getString("Permissions.CombatPlus"))) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("reload")) {
                            try {
                                plugin.getConfig().load(config);
                            } catch (IOException | InvalidConfigurationException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
