package net.tds.magicpets.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.tds.magicpets.entity.boss.EntityAirBoss;
import net.tds.magicpets.entity.boss.EntityEarthBoss;
import net.tds.magicpets.entity.boss.EntityFireBoss;
import net.tds.magicpets.entity.boss.EntityLightBoss;
import net.tds.magicpets.entity.boss.EntityUndeadBoss;
import net.tds.magicpets.entity.boss.EntityWaterBoss;
import net.tds.magicpets.entity.passive.EntityBabyAirPet;
import net.tds.magicpets.entity.passive.EntityBabyEarthPet;
import net.tds.magicpets.entity.passive.EntityBabyFirePet;
import net.tds.magicpets.entity.passive.EntityBabyLightPet;
import net.tds.magicpets.entity.passive.EntityBabyUndeadPet;
import net.tds.magicpets.entity.passive.EntityBabyWaterPet;
import net.tds.magicpets.lib.Config;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityManager {
	
	final Object mod;
	
	public EntityManager(Object mod) {
		
		this.mod = mod;

		//pets
		registerEntity(EntityBabyAirPet.class, "baby.airPet", Config.airPetID, 0x66CCFF, false);
		registerEntity(EntityBabyEarthPet.class, "baby.earthPet", Config.earthPetID, 0x336600, false);
		registerEntity(EntityBabyFirePet.class, "baby.firePet", Config.firePetID, 0x680000, false);
		registerEntity(EntityBabyLightPet.class, "baby.lightPet", Config.lightPetID, 0xFFFF33, false);
		registerEntity(EntityBabyUndeadPet.class, "baby.undeadPet", Config.undeadPetID, 0x606060, false);
		registerEntity(EntityBabyWaterPet.class, "baby.waterPet", Config.waterPetID, 0x0066FF, false);
		
		//elementals
		registerEntity(EntityAirBoss.class, "boss.airBoss", Config.airBossID, 0x66CCFF, true);
		registerEntity(EntityEarthBoss.class, "boss.earthBoss", Config.earthBossID, 0x336600, true);
		registerEntity(EntityFireBoss.class, "boss.fireBoss", Config.fireBossID, 0x680000, true);
		registerEntity(EntityLightBoss.class, "boss.lightBoss", Config.lightBossID, 0xFFFF33, true);
		registerEntity(EntityUndeadBoss.class, "boss.undeadBoss", Config.undeadBossID, 0x606060, true);
		registerEntity(EntityWaterBoss.class, "boss.waterBoss", Config.waterBossID, 0x0066FF, true);
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