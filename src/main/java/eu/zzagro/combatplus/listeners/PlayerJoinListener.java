package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final CombatPlus plugin;

    public PlayerJoinListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        plugin.mana.setMaxMana(player, 100);
        plugin.mana.setCurrentMana(player, 100);
        plugin.actionBar.sendActionbarMessage(player, plugin.color("&3Mana: " + plugin.mana.getCurrentMana(player)));
    }
}
