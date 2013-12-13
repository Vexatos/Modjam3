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