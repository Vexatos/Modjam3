package net.tds.magicpets.entity.pet;

import net.minecraft.world.World;

public class EntityBabyEarthTurtle extends EntityMagicalPet {

	public EntityBabyEarthTurtle(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = false;
	}
}