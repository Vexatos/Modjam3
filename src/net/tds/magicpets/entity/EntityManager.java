package net.tds.magicpets.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.tds.magicpets.entity.pet.EntityBabyEarthTurtle;
import net.tds.magicpets.entity.pet.EntityBabyFireGolem;
import net.tds.magicpets.entity.pet.EntityBabyWaterFish;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager {
	
	final Object mod;
	
	public EntityManager(Object mod) {
		
		this.mod = mod;
		
		//pets
		registerEntity(EntityBabyFireGolem.class, "baby.fireGolem", 1, 0xF03330);
		registerEntity(EntityBabyEarthTurtle.class, "baby.earthTurtle", 2, 0x298A17);
		registerEntity(EntityBabyWaterFish.class, "baby.waterfish", 3, 0x2EAADB);
		//4
		//5
		//6
		
		//elementals
	}
	
	public void registerEntity(Class<? extends Entity> entity, String name, int id, int color) {
		
		EntityRegistry.registerModEntity(entity, name, id, this.mod, 30, 5, true);
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, 0x947216, color));
	}
}