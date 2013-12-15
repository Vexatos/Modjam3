package net.tds.magicpets.entity.boss;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class EntityWaterBoss extends EntityMagicalBoss {

	private float heightOffset = 0.5f;
	private int heightUpdate;
	
	public EntityWaterBoss(World world) {
		
		super(world);
		this.setSize(2.5f, 1f);
	}

    public boolean isInWater() {
    	
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }
    
    public void onLivingUpdate() {
    	
    	if (this.worldObj.isRemote) {
    		
    		--this.heightUpdate;

            if (this.heightUpdate <= 0)
            {
                this.heightUpdate = 100;
                this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
            }
            
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
            {
                this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            }
    	}
        
    	this.setAir(20);
    	super.onLivingUpdate();
    }
}