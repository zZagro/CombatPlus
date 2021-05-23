package eu.zzagro.combatplus.stats;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Health {

    private final CombatPlus plugin;

    public Health(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public HashMap<UUID, Integer> healthMap = new HashMap<>();
    public HashMap<UUID, Integer> maxHealthMap = new HashMap<>();

    public void setMaxHealth(Player player, int amount) {
        maxHealthMap.put(player.getUniqueId(), amount);
    }

    public int getMaxHealth(Player player) {
        return maxHealthMap.get(player.getUniqueId());
    }

    public void setCurrentHealth(Player player, int amount) {
        healthMap.put(player.getUniqueId(), amount);
    }

    public int getCurrentHealth(Player player) {
        return healthMap.get(player.getUniqueId());
    }

    public void recoverHealth(Player player) {

    }
}
