package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RecipeManager {

    private final CombatPlus plugin;

    public RecipeManager(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public Recipe reforgeAnvilRecipe() {

        ArrayList<String> lore = new ArrayList<>();
        lore.add(plugin.color("&7Right click to open the"));
        lore.add(plugin.color("&7Reforge Anvil"));

        ItemStack reforgeAnvil = new ItemStack(Material.ANVIL);
        ItemMeta reforgeAnvilMeta = reforgeAnvil.getItemMeta();
        reforgeAnvilMeta.setDisplayName(ChatColor.YELLOW + "Reforge Anvil");
        reforgeAnvilMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        reforgeAnvilMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        reforgeAnvilMeta.setLore(lore);
        reforgeAnvil.setItemMeta(reforgeAnvilMeta);

        ShapedRecipe reforgeAnvilRecipe = new ShapedRecipe(reforgeAnvil);

        reforgeAnvilRecipe.shape(" i ", "iai", " i ");
        reforgeAnvilRecipe.setIngredient('i', Material.IRON_INGOT);
        reforgeAnvilRecipe.setIngredient('a', Material.ANVIL);

        return reforgeAnvilRecipe;
    }
}
