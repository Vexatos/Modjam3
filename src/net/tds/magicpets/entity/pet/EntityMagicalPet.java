package net.tds.magicpets.entity.pet;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMagicalPet extends EntityTameable {
	
	public EntityMagicalPet(World world) {
		
		super(world);
		this.experienceValue = 0;
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		super.writeEntityToNBT(compound);
		
	}
	
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		super.readEntityFromNBT(compound);
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