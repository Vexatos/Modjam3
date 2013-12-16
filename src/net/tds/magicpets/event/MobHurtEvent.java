package net.tds.magicpets.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.tds.magicpets.entity.passive.EntityMagicalPet;

public class MobHurtEvent {

	@ForgeSubscribe
	public void onMobHurt(LivingHurtEvent event) {
		
		if (event.entity instanceof EntityMagicalPet) {
			
			EntityMagicalPet pet = (EntityMagicalPet) event.entity;
			
			if (event.source.getEntity() instanceof EntityPlayer) {
				
				
			}
		}
	}
}
