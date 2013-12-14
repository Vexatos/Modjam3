package net.tds.magicpets.entity.pet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;

public class EntityBabyFirePet extends EntityMagicalPet {

	public EntityBabyFirePet(World world) {
		
		super(world);
		this.setSize(1.0f, 1.0f);
		this.noClip = false;
	}
	
	public void onLivingUpdate() {
		
		generateParticles();
		super.onLivingUpdate();
	}
	
	@SideOnly(Side.CLIENT)
	public void generateParticles() {	
		int i;

		for (i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0d, 0.0d, 0.0d);
		}
	}
}