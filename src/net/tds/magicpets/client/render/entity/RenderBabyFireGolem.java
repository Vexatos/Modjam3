package net.tds.magicpets.client.render.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.tds.magicpets.ModJam;
import net.tds.magicpets.client.model.ModelBabyFireGolem;
import net.tds.magicpets.entity.pet.EntityBabyFireGolem;

public class RenderBabyFireGolem extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("magicpets", "textures/entity/fireElement.png");
	
	private final ModelBabyFireGolem modelGolem;
	
	private double height = 0.0d;
	
	private boolean goingUp = true;
	
	public RenderBabyFireGolem(ModelBase par1ModelBase, float par2) {
		
		super(par1ModelBase, par2);
		this.modelGolem = (ModelBabyFireGolem) this.mainModel;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}
	
	public void renderGolem(EntityBabyFireGolem golem, double par2, double par3, double par4, float par5, float par6) {
		
		if (goingUp) {
			
			if(height < 0.4d) {
				
				height = height + 0.01d;
			}
			
			else {
				
				goingUp = false;
			}
		}
		
		else {
			
			if(!goingUp) {
				
				if(height > 0.2d) {
					
					height = height - 0.01d;
				}
				
				else {
					
					goingUp = true;
				}
			}
		}

		System.out.println(height);
		super.doRenderLiving(golem, par2, par3 + height / 10, par4, par5, par6);
	}
	
	public void doRender(Entity entity, double par2, double par3, double par4, float par5, float par6) {
		
		this.renderGolem((EntityBabyFireGolem) entity, par2, par3, par4, par5, par6);
	}
}
