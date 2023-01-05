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

        plugin.mana.setMaxMana(player, 1000);
        plugin.mana.setCurrentMana(player, plugin.mana.getMaxMana(player));
        plugin.health.setMaxHealth(player, 2000);
        plugin.health.setCurrentHealth(player, plugin.health.getMaxHealth(player));
        plugin.defense.setDefense(player, 100);

        player.setMaxHealth(plugin.health.getMaxHealth(player));
        player.setHealthScale(20 + (plugin.health.getMaxHealth(player) / 100));
        player.setHealth(player.getMaxHealth());

        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            int currentMana = plugin.mana.getCurrentMana(player);
            int maxMana = plugin.mana.getMaxMana(player);
            int currentHealth = (int) plugin.health.getCurrentHealth(player);
            int maxHealth = (int) plugin.health.getMaxHealth(player);
            int defense = (int) plugin.defense.getDefense(player);

            plugin.actionBar.sendActionbarMessage(player, plugin.color("&c" + currentHealth + "/" + maxHealth + "❤  " + "  &a" + defense + "❈ Defense  " + "  &b" + currentMana + "/" + maxMana +"✎ Mana"));
        }, 0, 5);
    }
}
