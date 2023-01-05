package eu.zzagro.combatplus.stats;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Strength {

    public HashMap<UUID, Integer> strengthMap = new HashMap<>();

    public void setStrength(Player player, int amount) {
        strengthMap.put(player.getUniqueId(), amount);
    }

    public int getStrength(Player player) {
        return strengthMap.get(player.getUniqueId());
    }
}
