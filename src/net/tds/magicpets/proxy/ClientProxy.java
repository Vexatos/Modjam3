package net.tds.magicpets.proxy;

import java.util.Arrays;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.tds.magicpets.client.model.ModelBabyEarthPet;
import net.tds.magicpets.client.model.ModelBabyFirePet;
import net.tds.magicpets.client.model.ModelBabyWaterPet;
import net.tds.magicpets.client.model.ModelFireBoss;
import net.tds.magicpets.client.model.ModelWaterBoss;
import net.tds.magicpets.client.render.entity.RenderBabyEarthPet;
import net.tds.magicpets.client.render.entity.RenderBabyFirePet;
import net.tds.magicpets.client.render.entity.RenderBabyWaterPet;
import net.tds.magicpets.client.render.entity.RenderFireBoss;
import net.tds.magicpets.client.render.entity.RenderWaterBoss;
import net.tds.magicpets.client.render.item.CrystalItemRenderer;
import net.tds.magicpets.entity.boss.EntityFireBoss;
import net.tds.magicpets.entity.boss.EntityWaterBoss;
import net.tds.magicpets.entity.passive.EntityBabyEarthPet;
import net.tds.magicpets.entity.passive.EntityBabyFirePet;
import net.tds.magicpets.entity.passive.EntityBabyWaterPet;
import net.tds.magicpets.event.IconEventHandler;
import net.tds.magicpets.handler.CapeHandler;
import net.tds.magicpets.item.Items;


public class ClientProxy extends CommonProxy {

	public static void sendChatToPlayer(EntityPlayer player, String message) {
		
		if (player.worldObj.isRemote) {
			
			player.sendChatToPlayer(ChatMessageComponent.createFromText(message));
		}
	}
	
	public void registerRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyFirePet.class, new RenderBabyFirePet(new ModelBabyFirePet(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyEarthPet.class, new RenderBabyEarthPet(new ModelBabyEarthPet(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyWaterPet.class, new RenderBabyWaterPet(new ModelBabyWaterPet(), 0.8F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBoss.class, new RenderFireBoss(new ModelFireBoss(), 0.7f));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterBoss.class, new RenderWaterBoss(new ModelWaterBoss(), 0.5f));
		
		MinecraftForgeClient.registerItemRenderer(Items.spawnCrystal.itemID, new CrystalItemRenderer());

        MinecraftForge.EVENT_BUS.register(new IconEventHandler());
	}
	
	public void registerCapes() {
		
		String[] team = {"darkhax", "viper283", "darkhax1"};
		
		CapeHandler.registerCapesFromList(team, "http://i.imgur.com/cM5tpAs.png");
	}
}