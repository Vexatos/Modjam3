package net.tds.magicpets.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.tds.magicpets.ModJam;
import net.tds.magicpets.entity.pet.EntityBabyFireGolem;
import net.tds.magicpets.enums.EnumElement;
import net.tds.magicpets.lib.Format;

import java.util.List;

public class ItemSpawningCrystal extends ItemModjamBase {

    public EnumElement element;
	
	public ItemSpawningCrystal(int id) {
		
		super(id);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.hasSubtypes = true;
		this.setMaxStackSize(1);
		this.setUnlocalizedName("spawnCrystal");
	}

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

        if(getElement() == null) {

            setElement(EnumElement.FIRE);
        }
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!stack.hasTagCompound()) {
		
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (!stack.getTagCompound().hasKey("Owner")) {
			
			setOwner(stack, player.username);
			setType(stack, element.name);
			setName(stack, player.username + "'s Secret");
			setLevel(stack, 1);
			setExperience(stack, 0);
		}
		
		if (!getOwner(stack).equalsIgnoreCase(player.username)) {
			
			ModJam.proxy.sendChatToPlayer(player, Format.RED + "[Warning]: This is not your crystal");
		}
		
		else {
			
			EntityBabyFireGolem entity = new EntityBabyFireGolem(world);
			entity.setOwner(getOwner(stack));
			entity.setName(getName(stack));
			entity.setLevel(getLevel(stack));
			entity.setExperience(getExperience(stack));
			entity.posX = player.posX;
			entity.posY = player.posY;
			entity.posZ = player.posZ;
			world.spawnEntityInWorld(entity);
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
		
		if (!stack.hasTagCompound()) {

			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {

            String type = stack.getTagCompound().getString("Type");
            EnumElement element = EnumElement.getElement(type);

            if(element != null) {

                return element.name;
            }
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
	
	public static int getExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getInteger("Experience");
		}
		
		return -1;
	}

	public static int getMaxExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return getLevel(stack) * 250;
		}
		
		return -1;
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

    public EnumElement getElement() {

        return element;
    }

    public void setElement(EnumElement element) {

        this.element = element;
    }
}