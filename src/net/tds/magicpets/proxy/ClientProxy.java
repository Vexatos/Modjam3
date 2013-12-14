package net.tds.magicpets.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.tds.magicpets.client.model.ModelBabyEarthTurtle;
import net.tds.magicpets.client.model.ModelBabyFireGolem;
import net.tds.magicpets.client.render.entity.RenderBabyEarthTurtle;
import net.tds.magicpets.client.render.entity.RenderBabyFireGolem;
import net.tds.magicpets.client.render.item.CrystalItemRenderer;
import net.tds.magicpets.entity.pet.EntityBabyEarthTurtle;
import net.tds.magicpets.entity.pet.EntityBabyFireGolem;
import net.tds.magicpets.event.IconEventHandler;
import net.tds.magicpets.item.Items;

;
;
;

public class ClientProxy extends CommonProxy {

	public void sendChatToPlayer(EntityPlayer player, String message) {
		
		if (player.worldObj.isRemote) {
			
			player.sendChatToPlayer(ChatMessageComponent.createFromText(message));
		}
	}
	
	public void registerRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyFireGolem.class, new RenderBabyFireGolem(new ModelBabyFireGolem(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyEarthTurtle.class, new RenderBabyEarthTurtle(new ModelBabyEarthTurtle(), 1.0F));
		
		MinecraftForgeClient.registerItemRenderer(Items.spawnCrystal.itemID, new CrystalItemRenderer());

        MinecraftForge.EVENT_BUS.register(new IconEventHandler());
	}
}