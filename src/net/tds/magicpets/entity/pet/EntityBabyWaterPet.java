package net.tds.magicpets.entity.pet;

import net.minecraft.world.World;

public class EntityBabyWaterPet extends EntityMagicalPet{

	public EntityBabyWaterPet(World world) {
		
		super(world);
		this.setSize(1.0f, 2.0f);
		this.noClip = false;
	}
}