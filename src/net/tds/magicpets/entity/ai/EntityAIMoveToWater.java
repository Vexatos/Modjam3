package net.tds.magicpets.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

//NotImplemented
public class EntityAIMoveToWater extends EntityAIBase{

	public EntityAIMoveToWater() {
		
	}
	
	@Override
	public boolean shouldExecute() {

		return false;
	}
	
	@Override
	public boolean continueExecuting() {
		
		return false;
	}
	
	@Override
	public void startExecuting() {
		
	}
	
	private Vec3 findBodyOfWater() {
		
		return null;	
	}
}