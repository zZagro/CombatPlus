package eu.zzagro.combatplus.stats;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Health implements Listener {

    private final CombatPlus plugin;

    public Health(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public HashMap<UUID, Double> healthMap = new HashMap<>();
    public HashMap<UUID, Double> maxHealthMap = new HashMap<>();
    public ArrayList<Player> healthRecoverList = new ArrayList<>();

    private BukkitTask taskId;

    public void setMaxHealth(Player player, double amount) {
        maxHealthMap.put(player.getUniqueId(), amount);
    }

    public double getMaxHealth(Player player) {
        return maxHealthMap.get(player.getUniqueId());
    }

    public void setCurrentHealth(Player player, double amount) {
        healthMap.put(player.getUniqueId(), amount);
    }

    public double getCurrentHealth(Player player) {
        return healthMap.get(player.getUniqueId());
    }

    public void recoverHealth(Player player) {
        double maxHealth = getMaxHealth(player);
        double[] currentHealth = {getCurrentHealth(player)};
        double recover = (getMaxHealth(player) * (1.0/100.0));
        double recoverVanillaHealth = (player.getMaxHealth() * (1.0/100.0));
        healthRecoverList.add(player);

        taskId = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            if (currentHealth[0] < maxHealth || player.getHealth() < player.getMaxHealth()) {
                currentHealth[0] = getCurrentHealth(player) + recover;
                setCurrentHealth(player, currentHealth[0]);
                if (player.getHealth() + recoverVanillaHealth >= player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                    healthRecoverList.remove(player);
                    Bukkit.getScheduler().cancelTask(taskId.getTaskId());
                } else {
                    player.setHealth(player.getHealth() + recoverVanillaHealth);
                }
                if (currentHealth[0] > maxHealth) {
                    setCurrentHealth(player, maxHealth);
                    healthRecoverList.remove(player);
                    Bukkit.getScheduler().cancelTask(taskId.getTaskId());
                } else if (currentHealth[0] == maxHealth) {
                    healthRecoverList.remove(player);
                    Bukkit.getScheduler().cancelTask(taskId.getTaskId());
                }
            }
        }, 20, 20);

        if (currentHealth[0] > maxHealth) {
            setCurrentHealth(player, maxHealth);
        }
    }

    @EventHandler
    public void onHealthRegen(EntityRegainHealthEvent e) {
        e.setCancelled(true);
    }
}
