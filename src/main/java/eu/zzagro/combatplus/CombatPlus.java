package eu.zzagro.combatplus;

import eu.zzagro.combatplus.commands.*;
import eu.zzagro.combatplus.listeners.*;
import eu.zzagro.combatplus.reforgeutils.ReforgeInv;
import eu.zzagro.combatplus.reforgeutils.ReforgeManager;
import eu.zzagro.combatplus.stats.*;
import eu.zzagro.combatplus.utils.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class CombatPlus extends JavaPlugin {

    //Plugin with custom mobs, weapons, enchants and damage indicator

    public HashMap<UUID, Double> defenseMap = new HashMap<>();

    public String prefix = color(this.getConfig().getString("Prefix") + " ");
    public String noPerms = color(prefix + this.getConfig().getString("NoPermission"));

    public MetaManager metaManager = new MetaManager(this);
    public ReforgeInv reforgeInv = new ReforgeInv(this);
    public RecipeManager recipeManager = new RecipeManager(this);
    public EnchantmentInv eInv = new EnchantmentInv(this);
    public ActionBar actionBar = new ActionBar(this);
    public ReforgeManager reforgeManager = new ReforgeManager(this);

    public Mana mana = new Mana(this);
    public Health health = new Health(this);
    public Defense defense = new Defense(this);
    public Strength strength = new Strength();
    public CritDamage critDamage = new CritDamage();
    public CritChance critChance = new CritChance();
    public AttackSpeed attackSpeed = new AttackSpeed();

    @Override
    public void onEnable() {
        getCommand("aote").setExecutor(new AoteCmd(this));
        getCommand("reforge").setExecutor(new ReforgeCmd(this));
        getCommand("viewrecipe").setExecutor(new ViewRecipeCmd(this));
        getCommand("setmaxmana").setExecutor(new SetMaxManaCmd(this));
        getCommand("setmana").setExecutor(new SetManaCmd(this));
        getCommand("combatplus").setExecutor(new CombatPlusCmd(this));

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getServer().getPluginManager().registerEvents(new InvClickListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new EnchantmentListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new ViewRecipeCmd(this), this);
        getServer().getPluginManager().registerEvents(new DamageIndicator(this), this);
        getServer().getPluginManager().registerEvents(new Defense(this), this);
        getServer().getPluginManager().registerEvents(new FoodListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(this), this);
        getServer().getPluginManager().registerEvents(new Health(this), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);

        getServer().addRecipe(recipeManager.reforgeAnvilRecipe());
        getServer().addRecipe(recipeManager.aoteRecipe());

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
