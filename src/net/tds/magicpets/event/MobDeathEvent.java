package net.tds.magicpets.event;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.entity.pet.EntityMagicalPet;
import net.tds.magicpets.item.ItemSpawningCrystal;

public class MobDeathEvent {
	
	ItemStack correctCrystal;
	
	@ForgeSubscribe
	public void onMobDeath(LivingDeathEvent event) {
		
		if (event.entity instanceof EntityLiving && !(event.entity instanceof EntityMagicalPet)) {
			
			if (event.source.getEntity() != null) {
				
				Entity source = event.source.getEntity();
				
				if (event.entity instanceof EntityMagicalPet) {
					
					EntityMagicalPet pet = (EntityMagicalPet) event.entity;
					
					PlayerPetProperties.get(pet.getEntityPetOwner()).setCurrentPet(0, 0);
				}
				
				if (source instanceof EntityPlayer) {
					
					EntityPlayer player = (EntityPlayer) source;
					
					checkPlayerForCrystal(player);
					
					if (!(PlayerPetProperties.get(player).getCurrentPet().equals(new UUID(0,0)))) {
						
						EntityMagicalPet pet = (EntityMagicalPet) PlayerPetProperties.get(player).getEntityByUUID();
						
						if(this.correctCrystal != null) {
							
							addExpToPet(999, this.correctCrystal);
						}
					}
				}
				
				if (source instanceof EntityMagicalPet) {
					
					EntityMagicalPet pet = (EntityMagicalPet) source;
					
					checkPlayerForCrystal(pet.getEntityPetOwner());
					
					if(this.correctCrystal != null) {
						
						addExpToPet(15, this.correctCrystal);						
					}
				}
			}
		}
	}
	
	/**
	 * Attempts to add experience points to the pet mob. 
	 * @param exp: The ammount of exp to add.
	 * @param stack: The stack of the crystal.
	 */
	public void addExpToPet(int exp, ItemStack stack) {
		
		if (stack != null && stack.getItem() instanceof ItemSpawningCrystal) {
			
			ItemSpawningCrystal crystal = (ItemSpawningCrystal) stack.getItem();
			
			if (crystal.getExperience(stack) + exp > crystal.getMaxExperience(stack)) {
				
				crystal.setExperience(stack, crystal.getExperience(stack) + exp);
				System.out.println("It is working" + exp);
			}
			
			else {
				
				crystal.setLevel(stack, crystal.getLevel(stack) + 1);
				addExpToPet(crystal.getExperience(stack) + exp - crystal.getMaxExperience(stack), stack);
				System.out.println("It is working" + exp);
			}
		}
	}
	
	/**
	 * Checks a players inventory for a crystal with the same 
	 * UUID as the pet to receive EXP.
	 * @param player: Player who should own the pet.
	 * @return: Correct crystal or gold apple as null.
	 */
	public ItemStack checkPlayerForCrystal(EntityPlayer player) {
		
		this.correctCrystal = null;
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			
			ItemStack stack = player.inventory.mainInventory[i];
			
			if (stack != null && stack.getItem() instanceof ItemSpawningCrystal) {
				
				if(!stack.hasTagCompound()) {
					
					stack.setTagCompound(new NBTTagCompound());
				}
				
				if(stack.stackTagCompound.hasKey("Most")) {
					
					if(stack.stackTagCompound.getLong("Most") == PlayerPetProperties.get(player).getCurrentPet().getMostSignificantBits()) {
						
						if(stack.stackTagCompound.getLong("Least") == PlayerPetProperties.get(player).getCurrentPet().getLeastSignificantBits()) {
							
							this.correctCrystal = stack;
							System.out.println("we has stack");
							break;
						}
					}
				}
			}
		}
		
		System.out.println("nope");
		return null;
	}
}