package eu.zzagro.combatplus.commands;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ViewRecipeCmd implements CommandExecutor, Listener {

    private final CombatPlus plugin;

    public ViewRecipeCmd(CombatPlus plugin) {
        this.plugin = plugin;
    }

    Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("viewrecipe")) {
                if (player.hasPermission(plugin.getConfig().getString("Permissions.Viewrecipe"))) {
                    if (args.length != 1) {
                        player.sendMessage(plugin.prefix + plugin.color("&cInvalid format!\n&cUsage: /viewrecipe <ITEM>"));
                    } else {
                        if (args[0].equalsIgnoreCase("ASPECT_OF_THE_END")) {
                            inv.getName().replace(ChatColor.DARK_GRAY + "Item", ChatColor.DARK_GRAY + "Aspect of the End");
                            ItemStack aote = plugin.metaManager.aoteItem;
                            aote.setItemMeta(plugin.metaManager.getAoteMeta());
                            inv.setItem(9, aote);
                            player.openInventory(inv);
                        } else if (args[0].equalsIgnoreCase("REFORGE_ANVIL")) {
                            reforgeAnvilRecipeInv(player);
                        }
                    }
                }
            }
        }
        return false;
    }

    public void reforgeAnvilRecipeInv(Player player) {
        inv = Bukkit.createInventory(player, 54, ChatColor.DARK_GRAY + "Reforge Anvil Recipe");

        ItemStack empty = plugin.metaManager.empty;
        empty.setItemMeta(plugin.metaManager.getEmptyMeta());
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, empty);
        }

        ItemStack close = plugin.metaManager.barrier;
        close.setItemMeta(plugin.metaManager.getBarrierMeta());
        inv.setItem(49, close);

        ItemStack craftingTable = plugin.metaManager.craftingTable;
        craftingTable.setItemMeta(plugin.metaManager.getCraftingTableMeta());
        inv.setItem(23, craftingTable);

        ItemStack air = new ItemStack(Material.AIR);
        inv.setItem(10, air);
        inv.setItem(12, air);
        inv.setItem(28, air);
        inv.setItem(30, air);

        ItemStack reforgeAnvil = plugin.metaManager.reforgeAnvil;
        reforgeAnvil.setItemMeta(plugin.metaManager.getReforgeAnvilMeta());
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        inv.setItem(11, iron);
        inv.setItem(19, iron);
        inv.setItem(21, iron);
        inv.setItem(29, iron);
        inv.setItem(20, anvil);
        inv.setItem(25, reforgeAnvil);

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Reforge Anvil Recipe")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
            }
        }
    }
}
