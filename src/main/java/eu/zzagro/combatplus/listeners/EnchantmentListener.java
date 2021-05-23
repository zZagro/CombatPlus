package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EnchantmentListener implements Listener {

    private final CombatPlus plugin;

    public EnchantmentListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
                e.setCancelled(true);
                plugin.eInv.customTable(player);
            }
        }
    }

    @EventHandler
    public void onInvInteract(InventoryInteractEvent e) {
        Player player = (Player) e.getWhoClicked();
    }

    @EventHandler
    public void onClickUpdate(InventoryClickEvent e) {
        new BukkitRunnable() {

            @Override
            public void run() {
                onClick(e);
            }
        }.runTaskLaterAsynchronously(plugin, 2);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
    }
}
