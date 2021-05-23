package eu.zzagro.combatplus.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if (e.getItemInHand().getType() == Material.ANVIL) {
            if (e.getItemInHand() != null) {
                if (e.getItemInHand().hasItemMeta()) {
                    if (e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Reforge Anvil")) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
