package eu.zzagro.combatplus.reforgeutils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReforgeInv {

    private final CombatPlus plugin;

    public ReforgeInv(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public void openReforge(Player player) {
        Inventory reforgeAnvil = Bukkit.createInventory(player, 27, plugin.color("&8Reforge Item"));

        ItemStack empty = plugin.metaManager.empty;
        ItemMeta emptyMeta = plugin.metaManager.getEmptyMeta();
        empty.setItemMeta(emptyMeta);
        for (int i = 0; i < reforgeAnvil.getSize(); i++) {
            reforgeAnvil.setItem(i, empty);
        }

        ItemStack air = plugin.metaManager.air;
        reforgeAnvil.setItem(11, air);

        ItemStack reforgeItem = plugin.metaManager.reforgeItem;
        ItemMeta reforgeMeta = plugin.metaManager.getReforgeMeta();
        reforgeItem.setItemMeta(reforgeMeta);
        reforgeAnvil.setItem(15, reforgeItem);

        player.openInventory(reforgeAnvil);
    }
}
