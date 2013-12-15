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
	
	@ForgeSubscribe
	public void onMobDeath(LivingDeathEvent event) {
		
		if (event.source.getEntity() != null) {
			
			Entity source = event.source.getEntity();
			
			if (event.entity instanceof EntityMagicalPet) {
				
				EntityMagicalPet pet = (EntityMagicalPet) event.entity;
				
				PlayerPetProperties.get(pet.getEntityPetOwner()).setCurrentPet(0, 0);
			}
			
			if (source instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) source;
				
				if (!(PlayerPetProperties.get(player).getCurrentPet().equals(new UUID(0,0)))) {
					
					EntityMagicalPet pet = (EntityMagicalPet) PlayerPetProperties.get(player).getEntityByUUID();
					
					addExpToPet(15, pet, checkPlayerForCrystal(player));
				}
			}
			
			if (source instanceof EntityMagicalPet) {
				
				EntityMagicalPet pet = (EntityMagicalPet) source;
				
				addExpToPet(15, pet, checkPlayerForCrystal(pet.getEntityPetOwner()));
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
	
	public ItemStack checkPlayerForCrystal(EntityPlayer player) {
		
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			
			ItemStack stack = player.inventory.mainInventory[i];
			
			if (stack.getItem() != null && stack.getItem() instanceof ItemSpawningCrystal) {
				
				ItemSpawningCrystal crystal = (ItemSpawningCrystal) stack.getItem();
				
				if (!stack.hasTagCompound()) {
					
					stack.stackTagCompound = new NBTTagCompound();
				}
				
				if (stack.stackTagCompound.hasKey("Most") && stack.stackTagCompound.hasKey("Least")) {
					
					if(crystal.getUUIDFromStack(stack).equals(PlayerPetProperties.get(player).getCurrentPet())) {
						
						return stack;
					}
				}			
			}
		}
		
		return new ItemStack(Item.appleGold); //basically null
	}
}