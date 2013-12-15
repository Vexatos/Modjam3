package net.tds.magicpets.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEssence extends ItemModjamBase {

    public ItemEssence(int id) {

        super(id);
        this.setUnlocalizedName("essence");
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
    	
        return true;
    }
}