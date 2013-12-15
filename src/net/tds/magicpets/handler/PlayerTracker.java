package net.tds.magicpets.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.tds.magicpets.data.PlayerPetProperties;
import net.tds.magicpets.entity.pet.EntityMagicalPet;
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
			
			getCrystalAndDespawn(player);
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
			
			if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem()  instanceof ItemSpawningCrystal) {
				
				ItemSpawningCrystal crystal = (ItemSpawningCrystal) player.inventory.mainInventory[i].getItem();
				PlayerPetProperties.get(player).setPetOut(false);
			}
		}
	}
}