package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickListener implements Listener {

    private final CombatPlus plugin;

    public InvClickListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase(plugin.color("&8Reforge Item"))) {
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
            }
        }
    }
}
