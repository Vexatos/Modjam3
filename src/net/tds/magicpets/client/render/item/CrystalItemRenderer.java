package net.tds.magicpets.client.render.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;
import net.tds.magicpets.client.render.RenderHelper;
import net.tds.magicpets.event.IconEventHandler;


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

        Icon icon = IconEventHandler.getCrystalIconFromItem(item);

        switch(type) {

            case EQUIPPED: {

                RenderHelper.drawIconIn3D(item, icon);
                break;
            }

            case EQUIPPED_FIRST_PERSON: {

                RenderHelper.drawIconIn3D(item, icon);
                break;
            }

            case INVENTORY: {

                RenderHelper.renderIconInInventory(icon, 1f, 1f, 1f);
                break;
            }

            case ENTITY: {

                RenderHelper.drawIconIn3D(item, icon, true);
                break;
            }

            default: {

                break;
            }
        }
    }
}
