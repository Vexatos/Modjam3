package net.tds.magicpets.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityEarthBoss extends EntityMagicalBoss {

	public EntityEarthBoss(World par1World) {
		
		super(par1World);
	}
	
    public boolean attackEntityAsMob(Entity entity) {
    	
    	if(super.attackEntityAsMob(entity)){
    		
    		double rand = Math.random();
    		
    		if(rand < 0.13D) {
    			
    			EntityLiving living = (EntityLiving) entity;
    			
    			living.addPotionEffect(new PotionEffect(Potion.weakness.id, 1200, 1));
    		}
    	}
    	
		return true;	
    }
}