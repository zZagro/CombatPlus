package eu.zzagro.combatplus;

import eu.zzagro.combatplus.commands.AoteCmd;
import eu.zzagro.combatplus.commands.ReforgeCmd;
import eu.zzagro.combatplus.listeners.*;
import eu.zzagro.combatplus.stats.Mana;
import eu.zzagro.combatplus.utils.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatPlus extends JavaPlugin {

    //Plugin with custom mobs, weapons, enchants and damage indicator

    public String prefix = color(this.getConfig().getString("Prefix") + " ");
    public String noPerms = color(prefix + this.getConfig().getString("NoPermission"));

    public MetaManager metaManager = new MetaManager(this);
    public ReforgeInv reforgeInv = new ReforgeInv(this);
    public RecipeManager recipeManager = new RecipeManager(this);
    public EnchantmentInv eInv = new EnchantmentInv(this);
    public Mana mana = new Mana(this);
    public ActionBar actionBar = new ActionBar(this);

    @Override
    public void onEnable() {
        getCommand("aote").setExecutor(new AoteCmd(this));
        getCommand("reforge").setExecutor(new ReforgeCmd(this));

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new InvClickListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new EnchantmentListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        getServer().addRecipe(recipeManager.reforgeAnvilRecipe());

        createConfig();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public void createConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
