package net.tds.magicpets.entity.pet;

import net.minecraft.world.World;

public class EntityBabyFireGolem extends EntityMagicalPet {

	public EntityBabyFireGolem(World world) {
		
		super(world);
		this.noClip = false;
		this.setSize(1.0f, 1.0f);
	}
}