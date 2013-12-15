package net.tds.magicpets.entity.boss;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class EntityWaterBoss extends EntityMagicalBoss {
	
	public EntityWaterBoss(World world) {
		
		super(world);
		this.setSize(2.5f, 1f);
	}

    public boolean isInWater() {
    	
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }
    
    public void onLivingUpdate() {
    	
    	if (!this.worldObj.isRemote) {
        
            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY > this.posY) {
            	
                this.motionY = (0.40000001192092896D - this.motionY) * 0.40000001192092896D;
                this.moveEntity(this.getEntityToAttack().posX, this.posY, this.getEntityToAttack().posZ);
                System.out.println(this.getEntityToAttack().getEyeHeight() + " : " + this.getEyeHeight());
            }
    	}
        
    	this.setAir(20);
    	super.onLivingUpdate();
    }
}