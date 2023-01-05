package eu.zzagro.combatplus.stats;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CritDamage {

    public Map<UUID, Integer> critDamageMap = new HashMap<>();

    public void setCritDamage(Player player, int amount) {
        critDamageMap.put(player.getUniqueId(), amount);
    }

    public int getCritDamage(Player player) {
        return critDamageMap.get(player.getUniqueId());
    }
}
