package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EnchantmentInv {

    private final CombatPlus plugin;

    public EnchantmentInv(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public void customTable(Player player) {
        Inventory enchTable = Bukkit.createInventory(player, 54, ChatColor.BLACK + "Enchant Item");

        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName(" ");
        empty.setItemMeta(emptyMeta);
        for (int i = 0; i <= 53; i++) {
            enchTable.setItem(i, empty);
        }

        ItemStack air = new ItemStack(Material.AIR);
        ItemMeta airMeta = air.getItemMeta();
        air.setItemMeta(airMeta);
        enchTable.setItem(19, air);

        ItemStack enchantmentTable = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
        ItemMeta tableMeta = enchantmentTable.getItemMeta();
        tableMeta.setDisplayName(ChatColor.GREEN + "Enchant Item");
        ArrayList<String> eTablelore = new ArrayList<>();
        eTablelore.add(ChatColor.GRAY + "Add an item to the slot above to");
        eTablelore.add(ChatColor.GRAY + "view enchantment options!");
        tableMeta.setLore(eTablelore);
        enchantmentTable.setItemMeta(tableMeta);
        enchTable.setItem(28, enchantmentTable);

        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        ItemMeta barrierMeta = barrier.getItemMeta();
        barrierMeta.setDisplayName(ChatColor.RED + "Close");
        barrier.setItemMeta(barrierMeta);
        enchTable.setItem(49, barrier);

        ItemStack grayDye = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta grayDyeMeta = grayDye.getItemMeta();
        grayDyeMeta.setDisplayName(ChatColor.RED + "Enchant Item");
        ArrayList<String> dyeLore = new ArrayList<>();
        dyeLore.add(ChatColor.GRAY + "Place an item in the open slot");
        dyeLore.add(ChatColor.GRAY + "to enchant it!");
        grayDyeMeta.setLore(dyeLore);
        grayDye.setItemMeta(grayDyeMeta);
        enchTable.setItem(23, grayDye);

        player.openInventory(enchTable);
    }
}
