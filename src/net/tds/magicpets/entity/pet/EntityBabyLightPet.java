package net.tds.magicpets.entity.pet;

import net.minecraft.world.World;

public class EntityBabyLightPet extends EntityMagicalPet {

	public EntityBabyLightPet(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = false;
	}
}