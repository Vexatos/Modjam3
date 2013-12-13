package net.thisdarkshadow.modjam3.item;

import net.minecraft.item.Item;

public class ItemModjamBase extends Item {

	public ItemModjamBase(int id) {
		
		super(id);
	}

	@Override
	public Item setUnlocalizedName(String unlocalized) {
		
		super.setUnlocalizedName("modjam3." + unlocalized);
		return this;
	}
}
