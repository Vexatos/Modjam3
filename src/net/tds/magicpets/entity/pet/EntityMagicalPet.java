package net.tds.magicpets.entity.pet;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMagicalPet extends EntityTameable {
	
	public static int dataOwner = 25;
	public static int dataName = 26;
	public static int dataLevel = 27;
	public static int dataExperience = 28;
	
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
		this.tasks.addTask(5, new EntityAIWander(this, 1.0d));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
		this.setTamed(true);
		this.setOwner(getPetOwner());
	}
	
    public boolean isAIEnabled() {
    	
        return true;
    }
	
	protected void entityInit() {
		
		super.entityInit();
		this.dataWatcher.addObject(dataOwner, "");
		this.dataWatcher.addObject(dataName, "");
		this.dataWatcher.addObject(dataLevel, 0);
		this.dataWatcher.addObject(dataExperience, 0);
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
	
	public void setPetOwner(String owner) {
		
		this.dataWatcher.updateObject(dataOwner, owner);
	}
	
	public void setName(String name) {
		
		this.dataWatcher.updateObject(dataName, name);
	}
	
	public void setLevel(int level) {
		
		this.dataWatcher.updateObject(dataLevel, level);
	}
	
	public void setExperience(int experience) {
		
		this.dataWatcher.updateObject(dataExperience, experience);
	}
	
	public String getPetOwner() {
		
		return this.dataWatcher.getWatchableObjectString(dataOwner);
	}
	
	public String getName() {
		
		return this.dataWatcher.getWatchableObjectString(dataName);
	}
	
	public int getLevel() {
		
		return this.dataWatcher.getWatchableObjectInt(dataLevel);
	}
	
	public int getExperience() {
		
		return this.dataWatcher.getWatchableObjectInt(dataExperience);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		
		return null;
	}
}