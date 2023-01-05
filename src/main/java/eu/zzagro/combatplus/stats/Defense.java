package eu.zzagro.combatplus.stats;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Defense implements Listener {

    private final CombatPlus plugin;

    public Defense(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public void setDefense(Player player, double amount) {
        plugin.defenseMap.put(player.getUniqueId(), amount);
    }

    public double getDefense(Player player) {
        return plugin.defenseMap.get(player.getUniqueId());
    }
}
