package net.tds.magicpets.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.tds.elementals.Elementals;
import net.tds.magicpets.entity.passive.EntityMagicalPet;
import net.tds.magicpets.lib.Format;
import net.tds.magicpets.proxy.ClientProxy;

public class MobHurtEvent {

	@ForgeSubscribe
	public void onMobHurt(LivingHurtEvent event) {
		System.out.println(1);
		if (event.entity instanceof EntityMagicalPet) {
			
			System.out.println(2);
			EntityMagicalPet pet = (EntityMagicalPet) event.entity;
			
			System.out.println(3);
			if (event.source.getEntity() instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer)event.source.getEntity();
				
				System.out.println(pet.getPetOwner());
				System.out.println(4);
				if (pet.getPetOwner().equalsIgnoreCase(player.username)) {
					
					System.out.println(5);
					event.ammount = 0.0f;
				}
			}
		}
	}
}
