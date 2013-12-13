package net.thisdarkshadow.modjam3.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemSpawningCrystal extends Item {
	
	public ItemSpawningCrystal(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.hasSubtypes = true;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("modjam3.spawnCrystal");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!stack.hasTagCompound()) {
		
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (!stack.stackTagCompound.hasKey("owner")) {
			
			stack.stackTagCompound.setString("owner", player.username);
			stack.stackTagCompound.setString("type", player.username);
			stack.stackTagCompound.setString("name", player.username);
			stack.stackTagCompound.setInteger("level", 1);
			stack.stackTagCompound.setInteger("experience", 0);
		}
		
		return stack;	
	}
	
	public static String getOwner(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.stackTagCompound.getString("owner");
		}
		
		return "Failure";
	}
	
	public static String getType(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.stackTagCompound.getString("type");
		}
		
		return "Failure";
	}
	
	public static String getName(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.stackTagCompound.getString("name");
		}
		
		return "Failure";
	}
	
	public static int getLevel(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.stackTagCompound.getInteger("level");
		}
		
		return 0;
	}
	
	public static int getExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.stackTagCompound.getInteger("experience");
		}
		
		return 9999999;
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean smt) {
		
		if (stack.stackTagCompound.hasKey("owner")) {
			list.add("");
		}
	}
}