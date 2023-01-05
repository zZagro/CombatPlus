package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {

    private final CombatPlus plugin;

    public PlayerInteractListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public int aoteMana = 50;
    public int aoteTeleportRange = 8;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().hasItemMeta()) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&9Aspect of the End"))) {
                        aoteTeleport(player);
                    } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&5Reforge Anvil"))) {
                        plugin.reforgeInv.openReforge(player);
                    }
                }
            }
        }
    }

    private void aoteTeleport(Player player) {
        int currentMana = plugin.mana.getCurrentMana(player);
        if (currentMana >= aoteMana) {
            for (int i = aoteTeleportRange; i >= 0; i--) {
                if (i == 0) {
                    player.sendMessage(plugin.prefix + plugin.color("&cThere are blocks in front of you!"));
                    break;
                }
                Location playerLoc = player.getEyeLocation();
                Vector vector = player.getLocation().getDirection();
                vector.multiply(i);
                Location tpLocation = playerLoc.add(vector);
                if (tpLocation.getBlock().getType() == Material.AIR) {
                    player.teleport(tpLocation);
                    player.sendMessage(plugin.color("&aUsed Instant Transmission for &3" + aoteMana + " Mana!"));
                    plugin.mana.setCurrentMana(player, currentMana - 50);
                    if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                        plugin.mana.recoverMana(player);
                    }
                    break;
                }
            }
        }
    }
}
