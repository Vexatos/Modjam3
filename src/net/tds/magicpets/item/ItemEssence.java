package net.tds.magicpets.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEssence extends ItemModjamBase {

    public ItemEssence(int id) {

        super(id);
    }
    
    //test method planned for spawning the bosses and other mobs.
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    	
		return stack;
    }
}
