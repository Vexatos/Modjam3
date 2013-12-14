package net.tds.magicpets.packet;

import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;


/**
 * Author: ShadowChild.
 */
public abstract class PacketMP extends Packet250CustomPayload {

    public abstract void execute(INetworkManager manager, Player player);
}
