package net.tds.magicpets.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.tds.magicpets.data.PlayerPetProperties;

public class EntityConstructionEvent {

	@ForgeSubscribe
	public void onEntityConstruction(EntityConstructing event) {
		
		if (event.entity instanceof EntityPlayer && PlayerPetProperties.get((EntityPlayer) event.entity) == null) {
			
			PlayerPetProperties.register((EntityPlayer) event.entity);
		}
		
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerPetProperties.PET_PROPS) == null) {
			
			event.entity.registerExtendedProperties(PlayerPetProperties.PET_PROPS, new PlayerPetProperties((EntityPlayer) event.entity));
		}
	}
}
