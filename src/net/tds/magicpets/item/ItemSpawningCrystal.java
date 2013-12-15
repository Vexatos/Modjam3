package net.tds.magicpets.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.tds.magicpets.ModJam;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.entity.pet.EntityBabyEatrhPet;
import net.tds.magicpets.entity.pet.EntityBabyFirePet;
import net.tds.magicpets.entity.pet.EntityMagicalPet;
import net.tds.magicpets.enums.EnumElement;
import net.tds.magicpets.lib.Format;

import java.util.List;
import java.util.UUID;

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
			setType(stack, element.type);
			setName(stack, "Fire Elemental");
			setLevel(stack, 1);
			setExperience(stack, 0);
		}
		
		if (!getOwner(stack).equalsIgnoreCase(player.username)) {
			
			ModJam.proxy.sendChatToPlayer(player, Format.RED + "[Warning]: This is not your crystal");
		}
		
		else {
			
			if (PlayerPetProperties.get(player).isPetOut()) {
				
				PlayerPetProperties.get(player).setPetOut(false);
				
				if(getEntityByUUID(stack, world) != null) {
					
					getEntityByUUID(stack, world).setDead();
				}
			}
			
			else {
				
				EntityBabyFirePet entity = new EntityBabyFirePet(world);
				entity.setPetOwner(getOwner(stack));
				entity.setPetName(getName(stack));
				entity.setPetLevel(getLevel(stack));
				entity.setPetExperience(getExperience(stack));
				entity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
				
				if (!world.isRemote){
					
					world.spawnEntityInWorld(entity);
					setUUIDToStack(stack, entity);
					PlayerPetProperties.get(player).setPetOut(true);
					PlayerPetProperties.get(player).setCurrentPet(getUUIDFromStack(stack).getMostSignificantBits(), getUUIDFromStack(stack).getLeastSignificantBits());
				}	
			}		
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
			list.add(player.posX);
		}
	}
	
	/**
	 * Get the owner of the pet from item nbt.
	 * @param stack: Stack to check nbt of.
	 * @return the name of the pet's owner.
	 */
	public static String getOwner(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getString("Owner");
		}
		
		return "Failure";
	}
	
	/**
	 * Get the type of pet this is from an enum using item nbt.
	 * @param stack: Stack to check nbt of.
	 * @return: the type of pet this is.
	 */
	public static String getType(ItemStack stack) {
		
		if (!stack.hasTagCompound()) {

			stack.setTagCompound(new NBTTagCompound());
		}
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {

            String type = stack.getTagCompound().getString("Type");
            EnumElement element = EnumElement.getType(type);

            if(element != null) {

                return element.type;
            }
		}
		
		return "Failure";
	}
	
	/**
	 * Get the name of the pet from item nbt. 
	 * @param stack: stack to check nbt of.
	 * @return: the name of the pet.
	 */
	public static String getName(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getString("Name");
		}
		
		return "Failure";
	}
	
	/**
	 * Get the current level of the pet from item nbt.
	 * @param stack: the stack to check nbt of.
	 * @return: the pets level in int form.
	 */
	public static int getLevel(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getInteger("Level");
		}
		
		return 0;
	}
	
	/**
	 * Get the pets current amount experience points from item nbt.
	 * @param stack: stack to check nbt of.
	 * @return: the pets current amount of experience.
	 */
	public static int getExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return stack.getTagCompound().getInteger("Experience");
		}
		
		return -1;
	}

	/**
	 * Get the max amount of experience points based on level from item nbt.
	 * @param stack: stack to check nbt of.
	 * @return: the current max amount of experience points.
	 */
	public static int getMaxExperience(ItemStack stack) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			return getLevel(stack) * 250;
		}
		
		return -1;
	}
	
	/**
	 * Get the pets enum type.
	 * @return: the pets enum.
	 */
    public EnumElement getElement() {

        return element;
    }
    
    /**
     * Get the uuid of the syncronized mob from item stack.
     * @param stack: stack to check nbt of.
     * @return: the uuid for the syncronized mob.
     */
    public UUID getUUIDFromStack(ItemStack stack) {
    	
		return new UUID(stack.stackTagCompound.getLong("MostID"), stack.stackTagCompound.getLong("LeastID"));	
    }
    
    /**
     * Get the entity associated with teh uuid by checking the worlds loaded entities.
     * @param stack: stack to check nbt of.
     * @param world: world to get entities from.
     * @return: the entity synced with the crystal.
     */
    public Entity getEntityByUUID(ItemStack stack, World world) {
		
    	for(int i = 0; i < world.loadedEntityList.size(); i++) {
    		
    		if (world.loadedEntityList.get(i) != null && world.loadedEntityList.get(i) instanceof Entity) {
    			
    			Entity currentEntity = (Entity) world.loadedEntityList.get(i);
    			
    			if (currentEntity.getUniqueID().equals(this.getUUIDFromStack(stack))) {
    				
    				return currentEntity;
    			}
    		}
    	}
    	
    	return null;
    }
    
    /**
     * Gets the uuid of an entity from the players properties.
     * @param player: player to check properties of.
     * @return: uuid of the players current synced mob.
     */
    public UUID getUUIDFromPlayer(EntityPlayer player) {
    	
    	return PlayerPetProperties.get(player).getCurrentPet();
    }
	
    /**
     * Sets the owner of the pet in items nbt.
     * @param stack: stack to set nbt to.
     * @param owner: the owner to add.
     */
	public static void setOwner(ItemStack stack, String owner) {

		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Owner", owner);
		}
	}
	
	/**
	 * Set the mobs type in the items nbt.
	 * @param stack: stack to set nbt to.
	 * @param type: the type to set.
	 */
	public static void setType(ItemStack stack, String type) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Type", type);
		}
	}
	
	/**
	 * Set the name of the mob in items nbt.
	 * @param stack: stack to set nbt to.
	 * @param name: the name to set.
	 */
	public static void setName(ItemStack stack, String name) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setString("Name", name);
		}
	}
	
	/**
	 * Set the mobs current level.
	 * @param stack: stack to set nbt to.
	 * @param level: level to set the value to.
	 */
	public static void setLevel(ItemStack stack, int level) {

		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setInteger("Level", level);
		}
	}
	
	/**
	 * Sets the mobs current experience in item nbt.
	 * @param stack: stack to set the nbt to.
	 * @param exp: the value of exp being set.
	 */
	public static void setExperience(ItemStack stack, int exp) {
		
		if (stack.getItem() instanceof ItemSpawningCrystal) {
			
			stack.getTagCompound().setInteger("Experience", exp);
		}
	}

	/**
	 * Sets the mobs enum type.
	 * @param element: enum type to set mob to.
	 */
    public void setElement(EnumElement element) {

        this.element = element;
    }
    
    /**
     * Saves the instance of the synced mob to the item by
     * splitting the uuid into longs and saving them in nbt.
     * @param stack: stact to save the uuid to.
     * @param pet: Pet to get the uuid of.
     */
    public void setUUIDToStack(ItemStack stack, EntityMagicalPet pet) {
    	
    	if (stack.getItem() instanceof ItemSpawningCrystal) {
    		
    		stack.stackTagCompound.setLong("LeastID", pet.getUniqueID().getLeastSignificantBits());
    		stack.stackTagCompound.setLong("MostID", pet.getUniqueID().getMostSignificantBits());
    	}
    }
    
    /**
     * Saves the instance of the synced mob to the player properties
     * by splitting it into longs and saving them to the nbt.
     * @param player: player to save the uuid to.
     * @param pet: Pet to get the uuid of.
     */
    public void setUUIDToPlayer(EntityPlayer player, EntityMagicalPet pet) {
    	
    	PlayerPetProperties.get(player).setCurrentPet(pet.getUniqueID().getMostSignificantBits(), pet.getUniqueID().getLeastSignificantBits());
    }
}