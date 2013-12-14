package net.tds.magicpets.entity.pet;

import net.minecraft.world.World;

public class EntityBabyWaterFish extends EntityMagicalPet{

	public EntityBabyWaterFish(World world) {
		
		super(world);
		this.setSize(1.0f, 2.0f);
		this.noClip = true;
	}
}
