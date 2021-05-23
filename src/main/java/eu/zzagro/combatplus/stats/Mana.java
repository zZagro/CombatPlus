package eu.zzagro.combatplus.stats;

import de.ancash.yaml.configuration.file.YamlFile;
import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Mana {

    private final CombatPlus plugin;

    public Mana(CombatPlus plugin) {
        this.plugin = plugin;
    }

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
        int recover = (int) (getMaxMana(player) * (5.0f/100.0f));
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
            int currentMana = getCurrentMana(player);
            int maxMana = getMaxMana(player);

            @Override
            public void run() {
                if (currentMana >= maxMana) {
                    currentMana = maxMana;
                } else {
                    do {
                        setCurrentMana(player, currentMana + recover);
                    } while (currentMana < maxMana);
                    if (currentMana > maxMana) {
                        currentMana = maxMana;
                    }
                }
            }
        }, 20, 1);
    }

    /*public int getMaxMana(Player player) {
        YamlFile mana = plugin.manaFile;
        return mana.getInt(player.getUniqueId().toString() + ".Max_Mana");
    }

    public int getCurrentMana(Player player) {
        YamlFile mana = plugin.manaFile;
        return mana.getInt(player.getUniqueId().toString() + ".Current_Mana");
    }

    public void recoverMana(Player player) {
        YamlFile mana = plugin.manaFile;
        int recover = (int) (getMaxMana(player) * (5.0f/100.0f));
        if (getCurrentMana(player) < getMaxMana(player)) {
            Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
                int currentMana = mana.getInt(player.getUniqueId().toString() + ".Current_Mana");

                @Override
                public void run() {
                    if (getCurrentMana(player) >= getMaxMana(player)) {
                        mana.set(player.getUniqueId().toString() + ".Current_Mana", getMaxMana(player));
                        try {
                            mana.save();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        do {
                            mana.set(player.getUniqueId().toString() + ".Current_Mana", getCurrentMana(player) + recover);
                            try {
                                mana.save();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } while (currentMana < getMaxMana(player));
                        if (getCurrentMana(player) >= getMaxMana(player)) {
                            mana.set(player.getUniqueId().toString() + ".Current_Mana", getMaxMana(player));
                            try {
                                mana.save();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 20, 20);
        }
    }*/
}
