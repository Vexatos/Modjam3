package net.tds.magicpets.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.tds.magicpets.client.model.ModelBabyEarthPet;
import net.tds.magicpets.client.model.ModelBabyFirePet;
import net.tds.magicpets.client.render.entity.RenderBabyEarthPet;
import net.tds.magicpets.client.render.entity.RenderBabyFirePet;
import net.tds.magicpets.client.render.item.CrystalItemRenderer;
import net.tds.magicpets.entity.pet.EntityBabyEatrhPet;
import net.tds.magicpets.entity.pet.EntityBabyFirePet;
import net.tds.magicpets.event.IconEventHandler;
import net.tds.magicpets.item.Items;


public class ClientProxy extends CommonProxy {

	public void sendChatToPlayer(EntityPlayer player, String message) {
		
		if (player.worldObj.isRemote) {
			
			player.sendChatToPlayer(ChatMessageComponent.createFromText(message));
		}
	}
	
	public void registerRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyFirePet.class, new RenderBabyFirePet(new ModelBabyFirePet(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyEatrhPet.class, new RenderBabyEarthPet(new ModelBabyEarthPet(), 1.4F));
		
		MinecraftForgeClient.registerItemRenderer(Items.spawnCrystal.itemID, new CrystalItemRenderer());

        MinecraftForge.EVENT_BUS.register(new IconEventHandler());
	}
}