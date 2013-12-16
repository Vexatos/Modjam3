package net.tds.magicpets.entity.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityBabyWaterPet extends EntityMagicalPet{

	public EntityBabyWaterPet(World world) {
		
		super(world);
		this.setSize(1.0f, 2.0f);
		this.noClip = false;
		this.healthModifier = 1;
		this.damageModifier = (int) 1;
		this.SpeedModifier = (int) 0.001;
	}
	
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10 + (getPetLevel() * this.healthModifier));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2 + (getPetLevel() * this.damageModifier));
	}
}