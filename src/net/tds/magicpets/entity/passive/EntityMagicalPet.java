package net.tds.magicpets.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
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
	
	public static int damageModifier = 0;
	public static int healthModifier = 0;
	public static int SpeedModifier = 0;
	
	public EntityMagicalPet(World world) {
		
		super(world);
		this.setSize(1.0F, 1.0F);
		this.noClip = false;
		this.experienceValue = 0;
		this.ignoreFrustumCheck = true;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 0.3D, 10.0F, 2.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 0.3d));
		this.tasks.addTask(6, new EntityAILookIdle(this));
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
		this.dataWatcher.addObject(dataOwner, "defaultOwner");
		this.dataWatcher.addObject(dataName, "defaultName");
		this.dataWatcher.addObject(dataLevel, 0);
		this.dataWatcher.addObject(dataExperience, 0);
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		super.writeEntityToNBT(compound);
		compound.setString("Owner", this.getPetOwner());
		compound.setString("Name", this.getPetName());
		compound.setInteger("Level", this.getPetLevel());
		compound.setInteger("Experience", this.getPetExperience());
	}
	
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		super.readEntityFromNBT(compound);
		this.setPetOwner(compound.getString("Owner"));
		this.setPetName(compound.getString("Name"));
		this.setPetLevel(compound.getInteger("Level"));
		this.setPetExperience(compound.getInteger("Experience"));	
	}
	
	public void onLivingUpdate() {
		
		super.onLivingUpdate();
		this.setCustomNameTag(getPetOwner() + "'s " + getPetName() + " LV:" + getPetLevel());
		
	}
	
	/**
	 * Sets the owner of the pet.
	 * @param owner: name of the owner being set.
	 */
	public void setPetOwner(String owner) {
		
		this.dataWatcher.updateObject(dataOwner, owner);
	}
	
	/**
	 * Sets the name of the pet name.
	 * @param name: name of the pet being set.
	 */
	public void setPetName(String name) {
		
		this.dataWatcher.updateObject(dataName, name);
	}
	
	/**
	 * Sets the pets current level.
	 * @param level: level being set.
	 */
	public void setPetLevel(int level) {
		
		this.dataWatcher.updateObject(dataLevel, level);
	}
	
	/**
	 * Sets the pets current experience
	 * @param experience: amount experience being set.
	 */
	public void setPetExperience(int experience) {
		
		this.dataWatcher.updateObject(dataExperience, experience);
	}
	
	/**
	 * Gets the pets owner.
	 * @return: name of pets owner.
	 */
	public String getPetOwner() {
		
		return this.dataWatcher.getWatchableObjectString(dataOwner);
	}
	
	/**
	 * Gets the pets name.
	 * @return: name of pet.
	 */
	public String getPetName() {
		
		return this.dataWatcher.getWatchableObjectString(dataName);
	}
	
	/**
	 * Gets the level of the pet.
	 * @return: the pets level.
	 */
	public int getPetLevel() {
		
		return this.dataWatcher.getWatchableObjectInt(dataLevel);
	}
	
	/**
	 * Gets the pets current experience.
	 * @return: amount of exp the pet has.
	 */
	public int getPetExperience() {
		
		return this.dataWatcher.getWatchableObjectInt(dataExperience);
	}

	/**
	 * Attempts to get an entity instance for the pets owner.
	 * @return: entity instance of the pets owner.
	 */
	public EntityPlayer getEntityPetOwner() {
		
		for(int i = 0; i < this.worldObj.playerEntities.size(); i++) {
			
			EntityPlayer player = (EntityPlayer) this.worldObj.playerEntities.get(i); 
			
			if (player != null && isPetOwner(player)) {
				
				return player;
			}
		}
		
		return null;
	}
	
	/**
	 * Checks if someone is the pets owner.
	 * @param player: player being checked.
	 * @return: if the person is the pets owner or not.
	 */
	public boolean isPetOwner(EntityPlayer player) {
		
		if(getPetOwner().equalsIgnoreCase(player.username)) {
			
			return true;
		}
		
		else return false;
	}
	
	/**
	 * Special method called on level up. Can be overridden.
	 * @param pet: pet being leveled.
	 */
	public void levelUp(EntityMagicalPet pet) {
		
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		
		return null;
	}
}