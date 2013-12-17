package net.tds.magicpets.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityFireBoss extends EntityMagicalBoss {

	public EntityFireBoss(World par1World) {

		super(par1World);
		this.setSize(2.0f, 2.7f);
	}
	
    public boolean attackEntityAsMob(Entity entity) {
    	
    	if(super.attackEntityAsMob(entity)){
    		
    		double rand = Math.random();
    		
    		if(rand < 0.13D) {
    			
    			entity.setFire(3);
    		}
    	}
    	
		return true;	
    }
}