package net.thisdarkshadow.modjam3.handler;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.thisdarkshadow.modjam3.ModJam;
import net.thisdarkshadow.modjam3.lib.Format;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {

		String message1 = "<EVENT>: There is currently an event for this mod. Join either #Modjam or #ThisDarkShadow on ";
		String message2 = " esper.net and send a special command to the user named Umbreon you will be added to the list of";
		String message3 = " users who will get a special cape. This event is only around for the duration of modjam!";
		String message4 = "The command to send is !activate-modjam3-yourInGameName If you have any issues please contact Darkhax or ShadowChild";
		String space = "                              ";
		netHandler.getPlayer().sendChatToPlayer(new ChatMessageComponent().createFromText(Format.DARK_YELLOW + message1 + message2 + message3 + space + message4));
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {

	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {

	}

	@Override
	public void connectionClosed(INetworkManager manager) {

	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {

	}
}
