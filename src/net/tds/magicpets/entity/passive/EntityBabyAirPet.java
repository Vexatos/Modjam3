package net.tds.magicpets.entity.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityBabyAirPet extends EntityMagicalPet {

	public EntityBabyAirPet(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = false;
	}
}