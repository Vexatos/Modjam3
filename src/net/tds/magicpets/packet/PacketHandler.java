package net.tds.magicpets.packet;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;


/**
 * Author: ShadowChild.
 */
public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

        if(packet.channel.equals("magicpets")) {

            ((PacketMP)packet).execute(manager, player);
        }
    }
}
