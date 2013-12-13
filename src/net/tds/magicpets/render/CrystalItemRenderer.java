package net.tds.magicpets.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;


/**
 * Author: ShadowChild.
 */
public class CrystalItemRenderer implements IItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {

        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

        return type == ItemRenderType.ENTITY && (helper == ItemRendererHelper.ENTITY_BOBBING || helper == ItemRendererHelper.ENTITY_ROTATION);
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch(type) {

            case EQUIPPED: {

                RenderHelper.drawIconIn3D(item, item.getIconIndex());
                break;
            }

            case EQUIPPED_FIRST_PERSON: {

                RenderHelper.drawIconIn3D(item, item.getIconIndex());
                break;
            }

            case INVENTORY: {

                RenderHelper.renderIconInInventory(item.getIconIndex(), 1f, 1f, 1f);
                break;
            }

            // TODO: Find vanilla code
            case ENTITY: {

                RenderHelper.drawIconIn3D(item, item.getIconIndex(), true);
                break;
            }

            default: {

                break;
            }
        }
    }
}
