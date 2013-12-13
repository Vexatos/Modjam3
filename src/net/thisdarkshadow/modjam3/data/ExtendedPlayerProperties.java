package net.thisdarkshadow.modjam3.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {

	public static final String PET_PROPS = "PetProperties";
	
	private final EntityPlayer player;
	
	private boolean petOut;
	
	public ExtendedPlayerProperties(EntityPlayer player) {
		
		this.player = player;
		this.petOut = false;
	}
	
	public static final void register(EntityPlayer player) {
		
		player.registerExtendedProperties(ExtendedPlayerProperties.PET_PROPS, new ExtendedPlayerProperties(player));
	}
	
	public static final ExtendedPlayerProperties get(EntityPlayer player) {
		
		return (ExtendedPlayerProperties) player.getExtendedProperties(PET_PROPS);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = new NBTTagCompound();
		properties.setBoolean("PetSummoned", this.petOut);
		
		compound.setTag(PET_PROPS, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {

		NBTTagCompound properties = (NBTTagCompound) compound.getTag(PET_PROPS);
		
		this.petOut = properties.getBoolean("PetSummoned");
	}

	@Override
	public void init(Entity entity, World world) {

	}
	
	public void setPetOut(boolean petOut) {
		
		this.petOut = petOut;
	}

	public boolean isPetOut() {
		
		return this.petOut;
	}
}