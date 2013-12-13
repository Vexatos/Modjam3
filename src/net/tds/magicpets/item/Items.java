package net.tds.magicpets.item;

import net.minecraft.item.Item;
import net.tds.magicpets.lib.Config;


public class Items {

    public static Item spawnCrystal;
    public static Item essence;

    public Items() {

        init();
    }

    private void init() {

        spawnCrystal = new ItemSpawningCrystal(Config.crystalID).setTextureName("quartz");
        essence = new ItemEssence(Config.essenceID);
    }
}
