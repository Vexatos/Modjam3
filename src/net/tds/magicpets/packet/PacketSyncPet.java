package net.tds.magicpets.packet;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.tds.magicpets.data.PlayerPetProperties;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;


/**
 * Author: ShadowChild.
 */
public class PacketSyncPet extends PacketMP {

    public PacketSyncPet(byte[] data) {

        super(data);
    }

    @Override
    public void execute(INetworkManager manager, Player player) {

        DataInputStream inStream = new DataInputStream(new ByteArrayInputStream(data));

        EntityPlayer thePlayer = (EntityPlayer)player;

        PlayerPetProperties props = PlayerPetProperties.get(thePlayer);

        try {

            boolean isPetOut = inStream.readBoolean();

            props.setPetOut(isPetOut);
        } catch(IOException e) {

            e.printStackTrace();
        }
    }
}
