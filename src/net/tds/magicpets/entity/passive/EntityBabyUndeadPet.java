package net.tds.magicpets.entity.passive;

import net.minecraft.world.World;

public class EntityBabyUndeadPet extends EntityMagicalPet {

	public EntityBabyUndeadPet(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = false;
	}
}