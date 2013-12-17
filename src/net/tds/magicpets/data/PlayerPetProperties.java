package net.tds.magicpets.data;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.tds.magicpets.packet.PacketMP;
import net.tds.magicpets.packet.PacketSyncPet;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;


public class PlayerPetProperties implements IExtendedEntityProperties {

	public static final String PET_PROPS = "PetProperties";
	
	private final EntityPlayer player;
	
	private boolean petOut;
	private long petMost;
	private long petLeast;
	
	public PlayerPetProperties(EntityPlayer player) {
		
		this.player = player;
		this.petOut = false;	
		this.petMost = 0;
		this.petLeast = 0;
	}
	
	public static final void register(EntityPlayer player) {
		
		player.registerExtendedProperties(PlayerPetProperties.PET_PROPS, new PlayerPetProperties(player));
	}
	
	public static final PlayerPetProperties get(EntityPlayer player) {
		
		return (PlayerPetProperties) player.getExtendedProperties(PET_PROPS);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = new NBTTagCompound();
		properties.setBoolean("PetSummoned", this.petOut);
		properties.setLong("Least", this.petLeast);
		properties.setLong("Most", this.petMost);
		
		compound.setTag(PET_PROPS, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = (NBTTagCompound) compound.getTag(PET_PROPS);
		
		this.petOut = properties.getBoolean("PetSummoned");
		this.petLeast = properties.getLong("Least");
		this.petMost = properties.getLong("Most");
	}

	@Override
	public void init(Entity entity, World world) {

	}
	
	/**
	 * Sets a pet as being out.
	 * @param petOut: the status of the pets position.
	 */
	public void setPetOut(boolean petOut) {
		
		this.petOut = petOut;
        //this.syncExtendedProperties();
	}
	
	/**
	 * Uses two longs to save the current pet's uuid into the players nbt.
	 * @param most: UUID Most Significant.
	 * @param least UUID Least Significant.
	 */
	public void setCurrentPet(long most, long least) {
		
		this.petMost = most;
		this.petLeast = least;
	}
	
	/**
	 * @return: returns the UUID of the current pet sent out.
	 */
	public UUID getCurrentPet() {
		
		return new UUID(this.petMost, this.petLeast);
	}

	/**
	 * @return: Entity instance based on lookup in a list of loaded entities.
	 */
    public Entity getEntityByUUID() {
		
    	for(int i = 0; i < player.worldObj.loadedEntityList.size(); i++) {
    		
    		if (player.worldObj.loadedEntityList.get(i) != null && player.worldObj.loadedEntityList.get(i) instanceof Entity) {
    			
    			Entity currentEntity = (Entity) player.worldObj.loadedEntityList.get(i);
    			
    			if (currentEntity.getUniqueID().equals(this.getCurrentPet())) {
    				
    				return currentEntity;
    			}
    		}
    	}
    	
    	return null;
    }

    /**
     * @return: true if player has a pet out.
     */
	public boolean isPetOut() {
		
		return this.petOut;
	}

    public void syncExtendedProperties() {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {

            dos.writeBoolean(isPetOut()); // isPetOut
            PacketMP packet = new PacketSyncPet(bos.toByteArray());
            PacketDispatcher.sendPacketToPlayer(packet, (Player)player);
        } catch(IOException e) {

            e.printStackTrace();
        }
        
    } 
}