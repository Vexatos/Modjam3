package net.tds.magicpets.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.tds.magicpets.Elementals;
import net.tds.magicpets.entity.passive.EntityMagicalPet;
import net.tds.magicpets.lib.Format;
import net.tds.magicpets.proxy.ClientProxy;

public class MobHurtEvent {

	@ForgeSubscribe
	public void onMobHurt(LivingHurtEvent event) {

		if (event.entity instanceof EntityMagicalPet) {
			

			EntityMagicalPet pet = (EntityMagicalPet) event.entity;
			

			if (event.source.getEntity() instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer)event.source.getEntity();
				
				System.out.println(pet.getPetOwner());
				if (pet.getPetOwner().equalsIgnoreCase(player.username)) {

					event.ammount = 0.0f;
				}
			}
		}
	}
}
