package eu.zzagro.combatplus.enchantments;

import eu.zzagro.combatplus.enums.ItemType;
import eu.zzagro.combatplus.enums.Rarity;

import java.util.List;

public class Enchantment {
    public String name;
    public List<String> description;
    public int maxLevel;
    public List<ItemType> applicable;
    public Rarity rarity;
}