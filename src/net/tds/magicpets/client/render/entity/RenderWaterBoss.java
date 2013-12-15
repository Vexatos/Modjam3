package net.tds.magicpets.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.tds.magicpets.entity.boss.EntityWaterBoss;

public class RenderWaterBoss extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("magicpets", "textures/entity/waterBoss.png");
	
	public RenderWaterBoss(ModelBase par1ModelBase, float par2) {
		
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}
	
	public void renderBoss(EntityWaterBoss turtle, double par2, double par3, double par4, float par5, float par6) {
		
		super.doRenderLiving(turtle, par2, par3, par4, par5, par6);
	}
	
	public void doRender(Entity entity, double par2, double par3, double par4, float par5, float par6) {
		
		this.renderBoss((EntityWaterBoss)entity, par2, par3, par4, par5, par6);
	}
}