package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DamageIndicator implements Listener {

    private final CombatPlus plugin;

    public DamageIndicator(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public static ArrayList<ArmorStand> asList = new ArrayList<>();
    public static HashMap<UUID, Double> crits = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();

            if (e.getEntity().getType().equals(EntityType.DROPPED_ITEM) || e.getEntity().getType().equals(EntityType.ARMOR_STAND)) {
                return;
            }
            double dmg = e.getDamage();
            String damage = String.valueOf(dmg);
            damage = damage.replace(".0", "");
            double randomX = Math.random();
            double randomY = Math.random();
            double randomZ = Math.random();
            randomX += -0.5D;
            randomY += -0.5D;
            randomZ += -0.5D;
            final ArmorStand as = (ArmorStand) e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(randomX, randomY, randomZ), EntityType.ARMOR_STAND);
            as.setMarker(true);
            as.setCustomName(plugin.color("&7%dmg%").replace("%dmg%", String.valueOf(Math.round(e.getDamage())).replace(".0", "")));
            if (e.getDamager() instanceof Player) {
                crits.put(player.getUniqueId(), Double.valueOf(player.getLocation().getY()));
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        if (((Double) crits.get(player.getUniqueId())).doubleValue() > player.getLocation().getY() || (((Double) crits.get(player.getUniqueId())).doubleValue() >= player.getLocation().getY() && !e.getDamager().isOnGround())) {
                            as.setCustomName(plugin.color("&6%dmg%").replace("%dmg%", String.valueOf(Math.round(e.getDamage())).replace(".0", "0")));
                        } else {
                            as.setCustomName(plugin.color("&7%dmg%").replace("%dmg%", String.valueOf(Math.round(e.getDamage())).replace(".0", "")));
                        }
                    }
                }, 1);
            }

            as.setCustomNameVisible(true);
            as.setVisible(false);
            as.setGravity(false);
            asList.add(as);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    as.remove();
                    if (as.isDead()) {
                        asList.remove(as);
                    }
                }
            }, 20);
        }
    }
}
