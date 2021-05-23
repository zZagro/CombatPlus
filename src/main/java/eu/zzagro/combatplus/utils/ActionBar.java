package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;

public class ActionBar {

    private final CombatPlus plugin;

    public ActionBar(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public void sendActionbarMessage(Player player, String text) {
        new Timer(player.getUniqueId().toString()).schedule(new TimerTask() {
            @Override
            public void run() {
                PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
                if (Bukkit.getPlayer(player.getUniqueId()) != null) this.cancel();
            }
        }, 20, 20);
    }
}