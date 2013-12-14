package net.tds.magicpets.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.item.ItemSpawningCrystal;
import net.tds.magicpets.item.Items;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerTracker implements IPlayerTracker {

	@Override
	public void onPlayerLogin(EntityPlayer player) {

	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		
		if (player.inventory.hasItem(Items.spawnCrystal.itemID)) {
			
		}
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {

	}
	
	public void getCrystalAndDespawn(EntityPlayer player) {
		
		for(int i = 0; i < player.inventory.mainInventory.length; i++) {
			
			if (player.inventory.mainInventory[i].getItem() instanceof ItemSpawningCrystal) {
				
				ItemSpawningCrystal crystal = (ItemSpawningCrystal) player.inventory.mainInventory[i].getItem();
				
				if (crystal.getInstanceOfPet() != null) {
					
					crystal.euthanizePet();
					PlayerPetProperties.get(player).setPetOut(false);
					break;
				}
			}
		}
	}
}