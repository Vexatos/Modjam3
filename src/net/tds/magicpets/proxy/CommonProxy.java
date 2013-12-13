package net.tds.magicpets.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.tds.magicpets.lib.Config;
import net.tds.magicpets.lib.Reference;

public class CommonProxy {

	public void sendChatToPlayer(EntityPlayer Player, String message) {
		
		if (Config.playerMessage) {
			
			Reference.logger.info(message);
		}
	}
	
	public void registerRenders() {
		
	}
}
