package net.tds.magicpets.item;

import net.minecraft.item.Item;

public class ItemModjamBase extends Item {

	public ItemModjamBase(int id) {
		
		super(id);
	}

	@Override
	public Item setUnlocalizedName(String unlocalized) {
		
		super.setUnlocalizedName("magicpets." + unlocalized);
		return this;
	}
}
