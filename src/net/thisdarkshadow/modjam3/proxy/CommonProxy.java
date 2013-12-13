package net.thisdarkshadow.modjam3.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.thisdarkshadow.modjam3.lib.Config;
import net.thisdarkshadow.modjam3.lib.Reference;
import cpw.mods.fml.client.FMLClientHandler;

public class CommonProxy {

	public void sendChatToPlayer(EntityPlayer Player, String message) {
		
		if (Config.playerMessage) {
			
			Reference.logger.info(message);
		}
	}
}
