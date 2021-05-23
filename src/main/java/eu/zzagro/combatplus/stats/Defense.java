package eu.zzagro.combatplus.stats;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Defense {

    private final CombatPlus plugin;

    public Defense(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public HashMap<UUID, Integer> defenseMap = new HashMap<>();

    public void setDefense(Player player, int amount) {
        defenseMap.put(player.getUniqueId(), amount);
    }

    public int getDefense(Player player) {
        return defenseMap.get(player.getUniqueId());
    }
}
