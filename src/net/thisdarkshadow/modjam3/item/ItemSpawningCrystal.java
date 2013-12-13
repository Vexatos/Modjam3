package net.thisdarkshadow.modjam3.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSpawningCrystal extends Item {

	public ItemSpawningCrystal(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.hasSubtypes = true;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("modjam3.spawnCrystal");
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean smt) {
		
		list.add("Test");
	}
}
