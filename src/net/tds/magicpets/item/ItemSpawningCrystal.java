package net.tds.magicpets.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.tds.magicpets.ModJam;
import net.tds.magicpets.lib.Format;

public class ItemSpawningCrystal extends ItemModjamBase {
	
	public ItemSpawningCrystal(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.hasSubtypes = true;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("spawnCrystal");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!stack.hasTagCompound()) {
		
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (!stack.getTagCompound().hasKey("Owner")) {
			
			setOwner(stack, player.username);
			setType(stack, "Fire");
			setName(stack, player.username + "'s Secret");
			setLevel(stack, 1);
			setExperience(stack, 0);
		}
		
		if (!getOwner(stack).equalsIgnoreCase(player.username)) {
			
			ModJam.proxy.sendChatToPlayer(player, Format.RED + "[Warning]: This is not your crystal");
		}
		
		return stack;	
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean smt) {
		
		if (!stack.hasTagCompound()) {
			
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (stack.getTagCompound().hasKey("Owner")) {
			list.add("Owner: " + getOwner(stack));
			list.add("Type: " + getType(stack));
			list.add("Name: " + getName(stack));
			list.add("Level: " + getLevel(stack));
			list.add("Experience: " + getExperience(stack) + "/" +  getMaxExperience(stack));
		}
	}
	
	public static String getOwner(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getString("Owner");
		}
		
		return "Failure";
	}
	
	public static String getType(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getString("Type");
		}
		
		return "Failure";
	}
	
	public static String getName(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getString("Name");
		}
		
		return "Failure";
	}
	
	public static int getLevel(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getInteger("Level");
		}
		
		return 0;
	}
	
	// For Darkhax:
	// You should return -1 if it fails
	public static int getExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getInteger("Experience");
		}
		
		return 9999999;
	}
	
	// For Darkhax:
	// You should return -1 if it fails
	public static int getMaxExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return getLevel(stack) * 250;
		}
		
		return 9999999;
	}
	
	public static void setOwner(ItemStack stack, String owner) {

		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Owner", owner);
		}
	}
	
	public static void setType(ItemStack stack, String type) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Type", type);
		}
	}
	
	public static void setName(ItemStack stack, String name) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Name", name);
		}
	}
	
	public static void setLevel(ItemStack stack, int level) {

		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setInteger("Level", level);
		}
	}
	
	public static void setExperience(ItemStack stack, int exp) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setInteger("Experience", exp);
		}
	}
}