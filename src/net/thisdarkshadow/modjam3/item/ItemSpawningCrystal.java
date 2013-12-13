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
			
			setOwner(stack, player.username);
			setType(stack, "Fire");
			setName(stack, player.username + "'s Secret");
			setLevel(stack, 1);
			setExperience(stack, 0);
		}
		
		return stack;	
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean smt) {
		
		if (!stack.hasTagCompound()) {
			
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (stack.stackTagCompound.hasKey("owner")) {
			list.add("Owner: " + getOwner(stack));
			list.add("Type: " + getType(stack));
			list.add("Name: " + getName(stack));
			list.add("Level: " + getLevel(stack));
			list.add("Experience: " + getExperience(stack) + "/" +  getMaxExperience(stack));
		}
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
	
	public static int getMaxExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return getLevel(stack) * 250;
		}
		
		return 9999999;
	}
	
	public static void setOwner(ItemStack stack, String owner) {

		if (stack.getItem() instanceof ItemSpawningCrystal && stack.stackTagCompound.hasKey("owner")) {
			
			stack.stackTagCompound.setString("owner", owner);
		}
	}
	
	public static void setType(ItemStack stack, String type) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal && stack.stackTagCompound.hasKey("type")) {
			
			stack.stackTagCompound.setString("type", type);
		}
	}
	
	public static void setName(ItemStack stack, String name) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal && stack.stackTagCompound.hasKey("name")) {
			
			stack.stackTagCompound.setString("name", name);
		}
	}
	
	public static void setLevel(ItemStack stack, int level) {

		if (stack.getItem() instanceof ItemSpawningCrystal && stack.stackTagCompound.hasKey("level")) {
			
			stack.stackTagCompound.setInteger("level", level);
		}
	}
	
	public static void setExperience(ItemStack stack, int exp) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal && stack.stackTagCompound.hasKey("experience")) {
			
			stack.stackTagCompound.setInteger("experience", exp);
		}
	}
}