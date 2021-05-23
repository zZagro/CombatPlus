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
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
