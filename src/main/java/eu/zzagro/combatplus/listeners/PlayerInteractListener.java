package eu.zzagro.combatplus.listeners;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {

    private final CombatPlus plugin;

    public PlayerInteractListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().hasItemMeta()) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&9Aspect of the End"))) {
                        int currentMana = plugin.mana.getCurrentMana(player);
                        if (currentMana >= 50) {
                            Location playerLoc1 = player.getEyeLocation();
                            Location playerLoc2 = player.getEyeLocation();
                            Location playerLoc3 = player.getEyeLocation();
                            Location playerLoc4 = player.getEyeLocation();
                            Location playerLoc5 = player.getEyeLocation();
                            Location playerLoc6 = player.getEyeLocation();
                            Location playerLoc7 = player.getEyeLocation();
                            Location playerLoc8 = player.getEyeLocation();
                            Vector vector1 = player.getLocation().getDirection();
                            Vector vector2 = player.getLocation().getDirection();
                            Vector vector3 = player.getLocation().getDirection();
                            Vector vector4 = player.getLocation().getDirection();
                            Vector vector5 = player.getLocation().getDirection();
                            Vector vector6 = player.getLocation().getDirection();
                            Vector vector7 = player.getLocation().getDirection();
                            Vector vector8 = player.getLocation().getDirection();
                            vector2.multiply(2);
                            vector3.multiply(3);
                            vector4.multiply(4);
                            vector5.multiply(5);
                            vector6.multiply(6);
                            vector7.multiply(7);
                            vector8.multiply(8);
                            Location teleport1 = playerLoc1.add(vector1);
                            Location teleport2 = playerLoc2.add(vector2);
                            Location teleport3 = playerLoc3.add(vector3);
                            Location teleport4 = playerLoc4.add(vector4);
                            Location teleport5 = playerLoc5.add(vector5);
                            Location teleport6 = playerLoc6.add(vector6);
                            Location teleport7 = playerLoc7.add(vector7);
                            Location teleport8 = playerLoc8.add(vector8);

                            if (teleport1.getBlock().getType() == Material.AIR) {
                                if (teleport2.getBlock().getType() == Material.AIR) {
                                    if (teleport3.getBlock().getType() == Material.AIR) {
                                        if (teleport4.getBlock().getType() == Material.AIR) {
                                            if (teleport5.getBlock().getType() == Material.AIR) {
                                                if (teleport6.getBlock().getType() == Material.AIR) {
                                                    if (teleport7.getBlock().getType() == Material.AIR) {
                                                        if (teleport8.getBlock().getType() == Material.AIR) {
                                                            player.teleport(teleport8);
                                                            player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                                            plugin.mana.setCurrentMana(player, currentMana - 50);
                                                            if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                                plugin.mana.recoverMana(player);
                                                            }
                                                        } else {
                                                            player.teleport(teleport7);
                                                            player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                                            plugin.mana.setCurrentMana(player, currentMana - 50);
                                                            if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                                plugin.mana.recoverMana(player);
                                                            }
                                                        }
                                                    } else {
                                                        player.teleport(teleport6);
                                                        player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                                        plugin.mana.setCurrentMana(player, currentMana - 50);
                                                        if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                            plugin.mana.recoverMana(player);
                                                        }
                                                    }
                                                } else {
                                                    player.teleport(teleport5);
                                                    player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                                    plugin.mana.setCurrentMana(player, currentMana - 50);
                                                    if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                        plugin.mana.recoverMana(player);
                                                    }
                                                }
                                            } else {
                                                player.teleport(teleport4);
                                                player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                                plugin.mana.setCurrentMana(player, currentMana - 50);
                                                if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                    plugin.mana.recoverMana(player);
                                                }
                                            }
                                        } else {
                                            player.teleport(teleport3);
                                            player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                            plugin.mana.setCurrentMana(player, currentMana - 50);
                                            if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                                plugin.mana.recoverMana(player);
                                            }
                                        }
                                    } else {
                                        player.teleport(teleport2);
                                        player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                        plugin.mana.setCurrentMana(player, currentMana - 50);
                                        if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                            plugin.mana.recoverMana(player);
                                        }
                                    }
                                    } else {
                                    player.teleport(teleport1);
                                    player.sendMessage(plugin.color("&aUsed Instant Transmission for &350 Mana!"));
                                    plugin.mana.setCurrentMana(player, currentMana - 50);
                                    if (!(plugin.mana.manaRecoverList.contains(player.getUniqueId()))) {
                                        plugin.mana.recoverMana(player);
                                    }
                                }
                            } else {
                                player.sendMessage(plugin.prefix + plugin.color("&cThere are blocks in front of you!"));
                            }
                        } else {
                            player.sendMessage(plugin.prefix + plugin.color("&cYou don't have enough Mana!"));
                        }
                    } else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(plugin.color("&5Reforge Anvil"))) {
                        plugin.reforgeInv.openReforge(player);
                    }
                }
            }
        }
    }
}
