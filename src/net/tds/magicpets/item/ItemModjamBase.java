package net.tds.magicpets.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemModjamBase extends Item {

	public ItemModjamBase(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public Item setUnlocalizedName(String unlocalized) {
		
		super.setUnlocalizedName("magicpets." + unlocalized);
		return this;
	}
}
