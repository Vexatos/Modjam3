package net.tds.magicpets.proxy;

import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.tds.magicpets.client.render.entity.RenderBabyFireGolem;
import net.tds.magicpets.entity.EntityBabyFireGolem;
import cpw.mods.fml.client.registry.RenderingRegistry;;;;

public class ClientProxy extends CommonProxy {

	public void sendChatToPlayer(EntityPlayer player, String message) {
		
		if (player.worldObj.isRemote) {
			
			player.sendChatToPlayer(new ChatMessageComponent().createFromText(message));		
		}
	}
	
	public void registerRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyFireGolem.class, new RenderBabyFireGolem(new ModelPig(), 1.0F));
	}
}