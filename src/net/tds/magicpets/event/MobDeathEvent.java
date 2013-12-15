package net.tds.magicpets.event;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.entity.pet.EntityMagicalPet;
import net.tds.magicpets.item.ItemSpawningCrystal;

public class MobDeathEvent {
	
	@ForgeSubscribe
	public void onMobDeath(LivingDeathEvent event) {
		
		if (event.source.getEntity() != null) {
			
			Entity source = event.source.getEntity();
			
			if (source instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) source;
				
				if (!(PlayerPetProperties.get(player).getCurrentPet().equals(new UUID(0,0)))) {
					
					EntityMagicalPet pet = (EntityMagicalPet) PlayerPetProperties.get(player).getEntityByUUID();
					
					addExpToPet(15, pet, checkPlayerForCrystal(player, PlayerPetProperties.get(player).getCurrentPet()));
				}
			}
			
			if (source instanceof EntityMagicalPet) {
				
				EntityMagicalPet pet = (EntityMagicalPet) source;
				
				addExpToPet(15, pet, checkPlayerForCrystal(pet.getEntityPetOwner(), PlayerPetProperties.get(pet.getEntityPetOwner()).getCurrentPet()));
			}
		}
	}
	
	public void addExpToPet(int exp, EntityMagicalPet pet, ItemStack stack) {
		
		if (stack.getItem() != null && stack.getItem() instanceof ItemSpawningCrystal) {
			
			ItemSpawningCrystal crystal = (ItemSpawningCrystal) stack.getItem();
			
			if (pet.getPetExperience() + exp > crystal.getMaxExperience(stack)) {
				
				pet.setPetExperience(pet.getPetExperience() + exp);
				crystal.setExperience(stack, crystal.getExperience(stack) + exp);
			}
			
			else {
				
				crystal.setLevel(stack, crystal.getLevel(stack) + 1);
				pet.setPetLevel(pet.getPetLevel() + 1);
				addExpToPet(crystal.getExperience(stack) + exp - crystal.getMaxExperience(stack), pet, stack);
			}
		}
	}
	
	public ItemStack checkPlayerForCrystal(EntityPlayer player, UUID uuid) {
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			
			ItemStack stack = player.inventory.mainInventory[i];
			
			if (stack.getItem() != null && stack.getItem() instanceof ItemSpawningCrystal) {
				
				if (!stack.hasTagCompound()) {
					
					stack.stackTagCompound = new NBTTagCompound();
				}
				
				if (stack.stackTagCompound.hasKey("Most") && stack.stackTagCompound.hasKey("Least")) {
					
					if (stack.stackTagCompound.getLong("Most") == uuid.getMostSignificantBits() && stack.stackTagCompound.getLong("Least") == uuid.getLeastSignificantBits()) {
						
						return stack;
					}
				}			
			}
		}
		
		return null;
	}
}