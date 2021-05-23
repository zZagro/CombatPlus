package eu.zzagro.combatplus.stats;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Mana {

    private final CombatPlus plugin;

    public Mana(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public ArrayList<UUID> manaRecoverList = new ArrayList<>();
    public HashMap<UUID, Integer> manaMap = new HashMap<>();
    public HashMap<UUID, Integer> maxManaMap = new HashMap<>();

    public void setMaxMana(Player player, int amount) {
        manaMap.put(player.getUniqueId(), amount);
        maxManaMap.put(player.getUniqueId(), amount);
    }

    public int getMaxMana(Player player) {
        return maxManaMap.get(player.getUniqueId());
    }

    public void setCurrentMana(Player player, int amount) {
        manaMap.put(player.getUniqueId(), amount);
    }

    public int getCurrentMana(Player player) {
        return manaMap.get(player.getUniqueId());
    }

    public void recoverMana(Player player) {
        int maxMana = getMaxMana(player);
        final int[] currentMana = {getCurrentMana(player)};
        int recover = (int) (getMaxMana(player) * (5.0f/100.0f));
        manaRecoverList.add(player.getUniqueId());

        Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                if (currentMana[0] < maxMana) {
                    currentMana[0] = getCurrentMana(player) + recover;
                    setCurrentMana(player, currentMana[0]);
                    if (currentMana[0] > maxMana) {
                        setCurrentMana(player, maxMana);
                        manaRecoverList.remove(player.getUniqueId());

                    } else if (currentMana[0] == maxMana) {
                        manaRecoverList.remove(player.getUniqueId());
                    }
                }
            }
        }, 20, 20);

        if (currentMana[0] > maxMana) {
            setCurrentMana(player, maxMana);
        }
    }
}
