package net.tds.magicpets.entity.pet;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;

public class EntityBabyFireGolem extends EntityMagicalPet {

	public EntityBabyFireGolem(World world) {
		
		super(world);
		this.setSize(1.0f, 1.0f);
		this.noClip = false;
		
	}
}