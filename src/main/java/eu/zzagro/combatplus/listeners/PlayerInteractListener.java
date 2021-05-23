package eu.zzagro.combatplus.listeners;

import de.ancash.yaml.configuration.file.YamlFile;
import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.io.IOException;

public class PlayerInteractListener implements Listener {

    private final CombatPlus plugin;

    public PlayerInteractListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().hasItemMeta()) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&9Aspect of the End"))) {
                        int currentMana = plugin.mana.getCurrentMana(player);
                        if (currentMana >= 50) {
                            Location playerLoc = player.getLocation().add(0, player.getEyeHeight(), 0);
                            Vector vector = player.getLocation().getDirection();
                            vector.multiply(8);
                            Location teleport = playerLoc.add(vector);
                            player.teleport(teleport);
                            player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                            plugin.mana.setCurrentMana(player, currentMana - 50);
                            plugin.mana.recoverMana(player);
                            //player.sendMessage(plugin.prefix + plugin.color("&aYou have &3" + currentMana + " Mana"));
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cYou don't have enough Mana!"));
                        }
                    } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&5Reforge Anvil"))) {
                        plugin.reforgeInv.openReforge(player);
                    }
                }
            }
        }
    }
}
