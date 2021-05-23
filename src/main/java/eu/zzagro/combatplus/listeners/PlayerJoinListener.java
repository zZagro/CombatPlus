package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
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
        plugin.mana.setCurrentMana(player, plugin.mana.getMaxMana(player));
        plugin.health.setMaxHealth(player, 200);
        plugin.health.setCurrentHealth(player, plugin.health.getMaxHealth(player));
        plugin.defense.setDefense(player, 250);

        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                int currentMana = plugin.mana.getCurrentMana(player);
                int maxMana = plugin.mana.getMaxMana(player);
                int currentHealth = plugin.health.getCurrentHealth(player);
                int maxHealth = plugin.health.getMaxHealth(player);
                int defense = plugin.defense.getDefense(player);

                plugin.actionBar.sendActionbarMessage(player, plugin.color("&c" + currentHealth + "/" + maxHealth + "❤  " + "  &a" + defense + "❈ Defense  " + "  &b" + currentMana + "/" + maxMana +"✎ Mana"));
            }
        }, 5, 5);
    }
}
