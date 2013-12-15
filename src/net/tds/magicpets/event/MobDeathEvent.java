package net.tds.magicpets.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.entity.pet.EntityMagicalPet;

public class MobDeathEvent {
	
	@ForgeSubscribe
	public void onMobDeath(LivingDeathEvent event) {
		
		if (event.source.getEntity() != null) {
			
			Entity source = event.source.getEntity();
			
			if (source instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) source;
				
				PlayerPetProperties.get(player).getCurrentPet();
			}
			
			if (source instanceof EntityMagicalPet) {
				
				EntityMagicalPet pet = (EntityMagicalPet) source;
			}
		}
	}
}