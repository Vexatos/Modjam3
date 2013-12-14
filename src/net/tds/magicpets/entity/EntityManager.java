package net.tds.magicpets.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.tds.magicpets.entity.boss.EntityFireBoss;
import net.tds.magicpets.entity.pet.EntityBabyAirPet;
import net.tds.magicpets.entity.pet.EntityBabyEatrhPet;
import net.tds.magicpets.entity.pet.EntityBabyFirePet;
import net.tds.magicpets.entity.pet.EntityBabyLightPet;
import net.tds.magicpets.entity.pet.EntityBabyUndeadPet;
import net.tds.magicpets.entity.pet.EntityBabyWaterPet;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager {
	
	final Object mod;
	
	public EntityManager(Object mod) {
		
		this.mod = mod;

		//pets
		registerEntity(EntityBabyAirPet.class, "baby.airPet", 300, 0x66CCFF, false);
		registerEntity(EntityBabyEatrhPet.class, "baby.earthPet", 301, 0x336600, false);
		registerEntity(EntityBabyFirePet.class, "baby.firePet", 302, 0x680000, false);
		registerEntity(EntityBabyLightPet.class, "baby.lightPet", 303, 0xFFFF33, false);
		registerEntity(EntityBabyUndeadPet.class, "baby.undeadPet", 304, 0x606060, false);
		registerEntity(EntityBabyWaterPet.class, "baby.waterPet", 305, 0x0066FF, false);
		
		//elementals
		registerEntity(EntityFireBoss.class, "boss.firePet", 352, 0x680000, true);
	}
	
	public void registerEntity(Class<? extends Entity> entity, String name, int id, int color, boolean boss) {
		
		EntityRegistry.registerModEntity(entity, name, id, this.mod, 30, 5, true);
		EntityList.IDtoClassMapping.put(id, entity);
		
		if(boss) {
			
			EntityList.entityEggs.put(id, new EntityEggInfo(id, 0xCBD0D1, color));
		}
		
		else {
			
			EntityList.entityEggs.put(id, new EntityEggInfo(id, 0x947216, color));
		}
	}
}