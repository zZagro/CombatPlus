package eu.zzagro.combatplus.listeners;

import de.ancash.yaml.configuration.file.YamlFile;
import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {

    private final CombatPlus plugin;

    public PlayerJoinListener(CombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        //YamlFile mana = plugin.manaFile;

        /*if (!(mana.contains(player.getUniqueId().toString()))) {
            mana.set(player.getUniqueId().toString() + ".Max_Mana", 100);
            try {
                mana.save();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        mana.set(player.getUniqueId().toString() + ".Current_Mana", mana.getInt(player.getUniqueId().toString() + ".Max_Mana"));
        try {
            mana.save();
        } catch (IOException io) {
            io.printStackTrace();
        }*/
        plugin.mana.setMaxMana(player, 100);
        plugin.mana.setCurrentMana(player, 100);
        plugin.actionBar.sendActionbarMessage(player, plugin.color("&3Mana: " + plugin.mana.getCurrentMana(player)));
    }
}
