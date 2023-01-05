package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InvClickListener implements Listener {

    private final CombatPlus plugin;

    public InvClickListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase(plugin.color("&8Reforge Item"))) {
            if (e.getInventory() == null || e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&aClick to Reforge"))) {
                    if (e.getInventory().getItem(11) != null) {
                        ItemStack item = e.getInventory().getItem(11);
                        plugin.reforgeManager.addReforge(item, player);
                    }
                }
            }
        }
    }
}
