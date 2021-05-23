package eu.zzagro.combatplus.utils;

import eu.zzagro.combatplus.CombatPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

    private final CombatPlus plugin;

    public RecipeManager(CombatPlus plugin) {
        this.plugin = plugin;
    }

    public Recipe reforgeAnvilRecipe() {

        ItemStack reforgeAnvil = plugin.metaManager.reforgeAnvil;
        reforgeAnvil.setItemMeta(plugin.metaManager.getReforgeAnvilMeta());

        ShapedRecipe reforgeAnvilRecipe = new ShapedRecipe(reforgeAnvil);

        reforgeAnvilRecipe.shape(" i ", "iai", " i ");
        reforgeAnvilRecipe.setIngredient('i', Material.IRON_INGOT);
        reforgeAnvilRecipe.setIngredient('a', Material.ANVIL);

        return reforgeAnvilRecipe;
    }

    public Recipe aoteRecipe() {
        ItemStack aote = plugin.metaManager.aoteItem;
        aote.setItemMeta(plugin.metaManager.getAoteMeta());

        ShapedRecipe aoteRecipe = new ShapedRecipe(aote);

        aoteRecipe.shape(" e ", " e ", " d ");
        aoteRecipe.setIngredient('e', Material.ENDER_PEARL);
        aoteRecipe.setIngredient('d', Material.DIAMOND_SWORD);

        return aoteRecipe;
    }
}
