package net.tds.magicpets.entity.boss;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class EntityWaterBoss extends EntityMagicalBoss {

	public EntityWaterBoss(World par1World) {
		
		super(par1World);
	}

    public boolean isInWater() {
    	
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }
    
    public void onLivingUpdate() {
    	
    	super.onLivingUpdate();
    	if (this.inWater) {
    		
    	}
    }
}