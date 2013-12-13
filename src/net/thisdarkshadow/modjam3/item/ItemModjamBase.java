package net.thisdarkshadow.modjam3.item;

import net.minecraft.item.Item;

public class ItemModjamBase extends Item {

	public ItemModjamBase(int id) {
		super(id);
	}

	/**
	 * FOR DARKHAX:
	 * this sets the unlocalized name with the prefix "modjam3"
	 * so that we do not have to do it in every item class
	 */
	@Override
	public Item setUnlocalizedName(String unlocalized) {
		
		super.setUnlocalizedName("modjam3." + unlocalized);
		return this;
	}
}
