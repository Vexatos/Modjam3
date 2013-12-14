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
		registerEntity(EntityBabyAirPet.class, "baby.airPet", 0, 0x66CCFF);
		registerEntity(EntityBabyEatrhPet.class, "baby.earthPet", 1, 0x336600);
		registerEntity(EntityBabyFirePet.class, "baby.firePet", 2, 0x680000);
		registerEntity(EntityBabyLightPet.class, "baby.lightPet", 3, 0xFFFF33);
		registerEntity(EntityBabyUndeadPet.class, "baby.undeadPet", 4, 0x606060);
		registerEntity(EntityBabyWaterPet.class, "baby.waterPet", 5, 0x0066FF);
		
		//elementals
		registerEntity(EntityFireBoss.class, "boss.firePet", 52, 0x680000);
	}
	
	public void registerEntity(Class<? extends Entity> entity, String name, int id, int color) {
		
		EntityRegistry.registerModEntity(entity, name, id, this.mod, 30, 5, true);
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, 0x947216, color));
	}
}