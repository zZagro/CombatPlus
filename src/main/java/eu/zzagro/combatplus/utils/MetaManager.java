package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MetaManager {

    private final CombatPlus plugin;

    public ItemStack aoteItem = new ItemStack(Material.DIAMOND_SWORD);
    public ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    public ItemStack air = new ItemStack(Material.AIR);
    public ItemStack reforgeItem = new ItemStack(Material.ANVIL);

    private ItemMeta aoteMeta;
    private ItemMeta emptyMeta;
    private ItemMeta reforgeMeta;

    public MetaManager(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public ItemMeta getAoteMeta() {
        if (aoteMeta == null) {
            aoteMeta = aoteItem.getItemMeta();
            aoteMeta.setDisplayName(plugin.color("&9Aspect of the End"));
            aoteMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ArrayList<String> aoteLore = new ArrayList<>();
            aoteLore.add(plugin.color("&7Damage: &c+100"));
            aoteLore.add(plugin.color("&7Strength: &c+100"));
            aoteLore.add(" ");
            aoteLore.add(plugin.color("&6Item Ability: Instant Transmission &e&lRIGHT CLICK"));
            aoteLore.add(plugin.color("&7Teleport &a8 blocks &7ahead of"));
            aoteLore.add(plugin.color("&7you and gain +50 &f✦ Speed"));
            aoteLore.add(plugin.color("&7for &a3 seconds&7."));
            aoteLore.add(plugin.color("&8Mana Cost: &350"));
            aoteLore.add(" ");
            aoteLore.add(plugin.color("&8This item can be reforged!"));
            aoteLore.add(plugin.color("&9&lRARE SWORD"));
            aoteMeta.setLore(aoteLore);
            aoteItem.setItemMeta(aoteMeta);
        }
        return aoteMeta;
    }

    public ItemMeta getEmptyMeta() {
        if (emptyMeta == null) {
            emptyMeta = empty.getItemMeta();
            emptyMeta.setDisplayName(" ");
            empty.setItemMeta(emptyMeta);
        }
        return emptyMeta;
    }

    public ItemMeta getReforgeMeta() {
        if (reforgeMeta == null) {
            reforgeMeta = reforgeItem.getItemMeta();
            reforgeMeta.setDisplayName(plugin.color("&aClick to Reforge"));
            ArrayList<String> reforgeLore = new ArrayList<>();
            reforgeLore.add(plugin.color("&7Place an item in the empty slot"));
            reforgeLore.add(plugin.color("&7to apply a random reforge to it!"));
            reforgeLore.add(plugin.color("&7Reforges boost different stats"));
            reforgeLore.add(plugin.color("&7from your item depending on the"));
            reforgeLore.add(plugin.color("&7reforge."));
            reforgeMeta.setLore(reforgeLore);
            reforgeItem.setItemMeta(reforgeMeta);
        }
        return reforgeMeta;
    }
}
