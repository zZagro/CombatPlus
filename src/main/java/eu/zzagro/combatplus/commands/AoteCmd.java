package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AoteCmd implements CommandExecutor {

    private final CombatPlus plugin;

    public AoteCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(plugin.getConfig().getString("Permissions.Aote"))) {
                if (args.length == 0) {
                    ItemStack aote = plugin.metaManager.aoteItem;
                    ItemMeta aoteMeta = plugin.metaManager.getAoteMeta();
                    aote.setItemMeta(aoteMeta);
                    player.getInventory().addItem(aote);
                }
            } else {
                player.sendMessage(plugin.noPerms);
            }
        }
        return false;
    }
}
