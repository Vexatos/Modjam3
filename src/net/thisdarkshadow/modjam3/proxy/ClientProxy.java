package net.thisdarkshadow.modjam3.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;

public class ClientProxy extends CommonProxy {

	public void sendChatToPlayer(EntityPlayer player, String message) {
		
		player.sendChatToPlayer(new ChatMessageComponent().createFromText(message));
	}
}
