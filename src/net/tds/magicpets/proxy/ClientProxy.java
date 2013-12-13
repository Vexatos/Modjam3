package net.tds.magicpets.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.tds.magicpets.client.render.entity.RenderBabyFireGolem;
import net.tds.magicpets.entity.EntityBabyFireGolem;
import net.tds.magicpets.item.Items;
import net.tds.magicpets.render.CrystalItemRenderer;

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
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBabyFireGolem.class, new RenderBabyFireGolem(new ModelPig(), 1.0F));
        MinecraftForgeClient.registerItemRenderer(Items.spawnCrystal.itemID, new CrystalItemRenderer());
	}
}