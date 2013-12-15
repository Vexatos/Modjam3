package net.tds.magicpets.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBabyWaterPet extends ModelBase {

	public static ModelRenderer Tail1;
	public static ModelRenderer Tail2;
	public static ModelRenderer Tail3;
	public static ModelRenderer Tail4;
	public static ModelRenderer Tail5;
	public static ModelRenderer Leg1;
	public static ModelRenderer Leg2;
	public static ModelRenderer Leg3;
	public static ModelRenderer Leg4;
	public static ModelRenderer Leg5;
	public static ModelRenderer Leg6;
	public static ModelRenderer Leg7;
	public static ModelRenderer Leg8;
	public static ModelRenderer Leg9;
	public static ModelRenderer Leg11;
	public static ModelRenderer Leg12;
	public static ModelRenderer Head1;
	public static ModelRenderer Head_2;
	public static ModelRenderer Head2;
	public static ModelRenderer Head3;
	public static ModelRenderer Head4;
	public static ModelRenderer Head_5;
	public static ModelRenderer Mouth;
	public static ModelRenderer Neck;
	public static ModelRenderer Body;
	public static ModelRenderer Fin;
	public static ModelRenderer Leg13;

	public ModelBabyWaterPet() {
		
		textureWidth = 58;
		textureHeight = 59;

		Tail1 = new ModelRenderer(this, 0, 17);
		Tail1.addBox(-2F, -1F, 0F, 5, 3, 5);
		Tail1.setRotationPoint(-0.5F, 17F, 6F);
		Tail1.setTextureSize(58, 59);
		Tail1.mirror = true;
		setRotation(Tail1, 0F, 0F, 0F);
		Tail2 = new ModelRenderer(this, 0, 25);
		Tail2.addBox(-1.5F, -0.5F, 4F, 4, 2, 6);
		Tail2.setRotationPoint(-0.5F, 17F, 6F);
		Tail2.setTextureSize(58, 59);
		Tail2.mirror = true;
		setRotation(Tail2, 0F, 0F, 0F);
		Tail3 = new ModelRenderer(this, 0, 33);
		Tail3.addBox(-8F, 0F, 9F, 3, 1, 5);
		Tail3.setRotationPoint(-0.5F, 17F, 6F);
		Tail3.setTextureSize(58, 59);
		Tail3.mirror = true;
		setRotation(Tail3, 0F, 0.6981317F, 0F);
		Tail4 = new ModelRenderer(this, 16, 34);
		Tail4.addBox(-1F, 0F, 9F, 3, 1, 4);
		Tail4.setRotationPoint(-0.5F, 17F, 6F);
		Tail4.setTextureSize(58, 59);
		Tail4.mirror = true;
		setRotation(Tail4, 0F, 0F, 0F);
		Tail5 = new ModelRenderer(this, 0, 33);
		Tail5.addBox(6F, 0F, 8F, 3, 1, 5);
		Tail5.setRotationPoint(-0.5F, 17F, 6F);
		Tail5.setTextureSize(58, 59);
		Tail5.mirror = true;
		setRotation(Tail5, 0F, -0.6981317F, 0F);
		Leg1 = new ModelRenderer(this, 37, 24);
		Leg1.addBox(-2F, 0.2F, -1F, 2, 4, 3);
		Leg1.setRotationPoint(2.3F, 17F, 3F);
		Leg1.setTextureSize(58, 59);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, -0.7853982F);
		Leg2 = new ModelRenderer(this, 0, 39);
		Leg2.addBox(-2.8F, 2.9F, -1F, 2, 4, 3);
		Leg2.setRotationPoint(0F, 0F, 0F);
		Leg2.setTextureSize(58, 59);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, -0.7679449F);
		Leg3 = new ModelRenderer(this, 0, 46);
		Leg3.addBox(-2.8F, 6F, -2F, 2, 1, 4);
		Leg3.setRotationPoint(0F, 0F, 0F);
		Leg3.setTextureSize(58, 59);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, -0.7679449F);
		
		Leg4 = new ModelRenderer(this, 37, 16);
		Leg4.addBox(0F, 0F, -2F, 2, 5, 3);
		Leg4.setRotationPoint(-2.4F, 15F, -2F);
		Leg4.setTextureSize(58, 59);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0.7679449F);
		Leg5 = new ModelRenderer(this, 0, 51);
		Leg5.addBox(-3.5F, 3.6F, -2F, 2, 5, 3);
		Leg5.setRotationPoint(0F, 0F, 0F);
		Leg5.setTextureSize(58, 59);
		Leg5.mirror = true;
		setRotation(Leg5, 0F, 0F, -0.7679449F);
		Leg6 = new ModelRenderer(this, 0, 46);
		Leg6.addBox(-3.5F, 8F, -3F, 2, 1, 4);
		Leg6.setRotationPoint(0F, 0F, -2F);
		Leg6.setTextureSize(58, 59);
		Leg6.mirror = true;
		setRotation(Leg6, 0F, 0F, -0.7679449F);
		
		Leg7 = new ModelRenderer(this, 37, 16);
		Leg7.addBox(-2.1F, 0F, -2F, 2, 5, 3);
		Leg7.setRotationPoint(2.6F, 15F, -2F);
		Leg7.setTextureSize(58, 59);
		Leg7.mirror = true;
		setRotation(Leg7, 0F, 0F, -0.7679449F);
		Leg8 = new ModelRenderer(this, 0, 51);
		Leg8.addBox(1.4F, 3.7F, -1F, 2, 5, 3);
		Leg8.setRotationPoint(0F, 0F, 0F);
		Leg8.setTextureSize(58, 59);
		Leg8.mirror = true;
		setRotation(Leg8, 0F, 0F, 0.7679449F);
		Leg9 = new ModelRenderer(this, 0, 46);
		Leg9.addBox(1.4F, 8F, -3F, 2, 1, 4);
		Leg9.setRotationPoint(0F, 0F, 0F);
		Leg9.setTextureSize(58, 59);
		Leg9.mirror = true;
		setRotation(Leg9, 0F, 0F, 0.7679449F);
		Leg11 = new ModelRenderer(this, 0, 39);
		Leg11.addBox(0.9F, 3F, -1F, 2, 3, 3);
		Leg11.setRotationPoint(0F, 0F, 0F);
		Leg11.setTextureSize(58, 59);
		Leg11.mirror = true;
		setRotation(Leg11, 0F, 0F, 0.7679449F);
		Leg12 = new ModelRenderer(this, 0, 46);
		Leg12.addBox(0.9F, 6F, -2F, 2, 1, 4);
		Leg12.setRotationPoint(0F, 0F, 0F);
		Leg12.setTextureSize(58, 59);
		Leg12.mirror = true;
		setRotation(Leg12, 0F, 0F, 0.7679449F);
		Head1 = new ModelRenderer(this, 24, 54);
		Head1.addBox(2.1F, -1F, -3F, 1, 2, 3);
		Head1.setRotationPoint(-0.8F, 17.5F, -5F);
		Head1.setTextureSize(58, 59);
		Head1.mirror = true;
		setRotation(Head1, 0F, 0F, 0F);
		Head_2 = new ModelRenderer(this, 20, 52);
		Head_2.addBox(-1.7F, -1.7F, -2.1F, 5, 1, 1);
		Head_2.setRotationPoint(-0.8F, 17.5F, -5F);
		Head_2.setTextureSize(58, 59);
		Head_2.mirror = true;
		setRotation(Head_2, -0.5061455F, 0F, 0F);
		Head2 = new ModelRenderer(this, 16, 47);
		Head2.addBox(-1.7F, -2.7F, -3F, 5, 2, 3);
		Head2.setRotationPoint(-0.8F, 17.5F, -5F);
		Head2.setTextureSize(58, 59);
		Head2.mirror = true;
		setRotation(Head2, 0.3665191F, 0F, 0F);
		Head3 = new ModelRenderer(this, 32, 54);
		Head3.addBox(-1.7F, -1.9F, -5.6F, 5, 2, 3);
		Head3.setRotationPoint(-0.8F, 17.5F, -5F);
		Head3.setTextureSize(58, 59);
		Head3.mirror = true;
		setRotation(Head3, 0.122173F, 0F, 0F);
		Head4 = new ModelRenderer(this, 32, 48);
		Head4.addBox(-1.7F, 0.4F, -5.6F, 5, 1, 5);
		Head4.setRotationPoint(-0.8F, 17.5F, -5F);
		Head4.setTextureSize(58, 59);
		Head4.mirror = true;
		setRotation(Head4, 0F, 0F, 0F);
		Head_5 = new ModelRenderer(this, 32, 43);
		Head_5.addBox(-1.4F, -1F, -3F, 1, 2, 3);
		Head_5.setRotationPoint(-0.8F, 17.5F, -5F);
		Head_5.setTextureSize(58, 59);
		Head_5.mirror = true;
		setRotation(Head_5, 0F, 0F, 0F);
		Mouth = new ModelRenderer(this, 40, 43);
		Mouth.addBox(-3F, -0.5F, -4F, 5, 1, 4);
		Mouth.setRotationPoint(0.5F, 19.5F, -5.8F);
		Mouth.setTextureSize(58, 59);
		Mouth.mirror = true;
		setRotation(Mouth, 0.2094395F, 0F, 0F);
		Neck = new ModelRenderer(this, 46, 37);
		Neck.addBox(-2.5F, -3.6F, -1F, 5, 5, 1);
		Neck.setRotationPoint(0F, 19F, -5F);
		Neck.setTextureSize(58, 59);
		Neck.mirror = true;
		setRotation(Neck, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-3F, -4F, 0F, 6, 6, 11);
		Body.setRotationPoint(0F, 19F, -5F);
		Body.setTextureSize(58, 59);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Fin = new ModelRenderer(this, 20, 24);
		Fin.addBox(-0.5F, -3F, 3F, 1, 3, 6);
		Fin.setRotationPoint(0F, 19F, -5F);
		Fin.setTextureSize(58, 59);
		Fin.mirror = true;
		setRotation(Fin, 0.3839724F, 0F, 0F);
		Leg13 = new ModelRenderer(this, 37, 24);
		Leg13.addBox(0F, 0F, -1F, 2, 4, 3);
		Leg13.setRotationPoint(-2.4F, 17F, 3F);
		Leg13.setTextureSize(58, 59);
		Leg13.mirror = true;
		setRotation(Leg13, 0F, 0F, 0.7679449F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Tail1.render(f5);
		Tail2.render(f5);
		Tail3.render(f5);
		Tail4.render(f5);
		Tail5.render(f5);
		Leg1.render(f5);
		Leg4.render(f5);
		Leg7.render(f5);
		Leg13.render(f5);
		Head1.render(f5);
		Head_2.render(f5);
		Head2.render(f5);
		Head3.render(f5);
		Head4.render(f5);
		Head_5.render(f5);
		Mouth.render(f5);
		Neck.render(f5);
		Body.render(f5);
		Fin.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		
		//Right front
		Leg4.addChild(Leg5);
		Leg4.addChild(Leg6);
		
		//Right back
		Leg13.addChild(Leg2);
		Leg13.addChild(Leg3);
		
		//Left Front
		Leg7.addChild(Leg8);
		Leg7.addChild(Leg9);
		
		//Left back
		Leg1.addChild(Leg11);
		Leg1.addChild(Leg12);
		
		
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
