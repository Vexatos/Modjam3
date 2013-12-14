package net.tds.magicpets.entity.pet;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMagicalPet extends EntityTameable {
	
	public EntityMagicalPet(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = true;
		this.experienceValue = 0;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
		this.setTamed(true);
	}
	
    public boolean isAIEnabled() {
    	
        return true;
    }
	
	protected void entityInit() {
		
		super.entityInit();
		this.dataWatcher.addObject(22, "");
		this.dataWatcher.addObject(23, "");
		this.dataWatcher.addObject(24, 0);
		this.dataWatcher.addObject(25, 0);
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		super.writeEntityToNBT(compound);
		compound.setString("Owner", this.getPetOwner());
		compound.setString("Name", this.getName());
		compound.setInteger("Level", this.getLevel());
		compound.setInteger("Experience", this.getExperience());
	}
	
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		super.readEntityFromNBT(compound);
		this.setOwner(compound.getString("Owner"));
		this.setName(compound.getString("Name"));
		this.setLevel(compound.getInteger("Level"));
		this.setExperience(compound.getInteger("Experience"));	
	}
	
    public void onLivingUpdate() {
    	
        super.onLivingUpdate();
        
        System.out.println("I am Here " + this.posX + " " + this.posY + " " + this.posZ);
    }
	
	public void setOwner(String owner) {
		
		this.dataWatcher.updateObject(22, owner);
	}
	
	public void setName(String name) {
		
		this.dataWatcher.updateObject(23, name);
	}
	
	public void setLevel(int level) {
		
		this.dataWatcher.updateObject(24, level);
	}
	
	public void setExperience(int experience) {
		
		this.dataWatcher.updateObject(25, experience);
	}
	
	public String getPetOwner() {
		
		return this.dataWatcher.getWatchableObjectString(22);
	}
	
	public String getName() {
		
		return this.dataWatcher.getWatchableObjectString(23);
	}
	
	public int getLevel() {
		
		return this.dataWatcher.getWatchableObjectInt(24);
	}
	
	public int getExperience() {
		
		return this.dataWatcher.getWatchableObjectInt(25);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		
		return null;
	}
}