package eu.zzagro.combatplus.reforgeutils;

import eu.zzagro.combatplus.CombatPlus;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ReforgeManager {

    private final CombatPlus plugin;

    public ReforgeManager(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public void addReforge(ItemStack item, Player player) {
        if (item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.IRON_SWORD || item.getType() == Material.GOLD_SWORD || item.getType() == Material.STONE_SWORD || item.getType() == Material.WOOD_SWORD) {
            Random swordReforge = new Random();
            boolean gentle = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean odd = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean fast = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean fair = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean epic = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean sharp = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean heroic = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean spicy = swordReforge.nextDouble() <= 1.0 / 9.0;
            boolean legendary = swordReforge.nextDouble() <= 1.0 / 9.0;

            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
            NBTTagList modifiers = new NBTTagList();
            if (gentle) {

            }
            if (odd) {

            }
            if (fast) {

            }
            if (fair) {

            }
            if (epic) {

            }
            if (sharp) {

            }
            if (heroic) {

            }
            if (spicy) {

            }
            if (legendary) {

            }
        }
    }
}
