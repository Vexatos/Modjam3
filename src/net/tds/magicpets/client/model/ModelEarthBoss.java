package net.tds.magicpets.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEarthBoss extends ModelBase {
	// fields
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer Leg5;
	ModelRenderer Leg6;
	ModelRenderer Leg7;
	ModelRenderer Leg8;
	ModelRenderer Leg9;
	ModelRenderer Leg10;
	ModelRenderer Leg11;
	ModelRenderer Leg12;
	ModelRenderer Head;
	ModelRenderer Body1;
	ModelRenderer Body2;
	ModelRenderer Body3;
	ModelRenderer Body4;
	ModelRenderer Body5;
	ModelRenderer Body6;
	ModelRenderer Body7;
	ModelRenderer Body8;
	ModelRenderer Arm1;
	ModelRenderer Arm2;
	ModelRenderer Arm3;
	ModelRenderer Arm4;
	ModelRenderer Arm5;
	ModelRenderer Arm6;
	ModelRenderer Arm7;
	ModelRenderer Arm8;
	ModelRenderer Arm9;
	ModelRenderer Arm10;
	ModelRenderer Arm11;
	ModelRenderer Arm12;

	public ModelEarthBoss() {
		
		textureWidth = 165;
		textureHeight = 224;

		Leg1 = new ModelRenderer(this, 0, 0);
		Leg1.addBox(-4F, 18F, -8F, 8, 2, 13);
		Leg1.setRotationPoint(8F, 4F, 0F);
		Leg1.setTextureSize(165, 224);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 133, 0);
		Leg2.addBox(-2.8F, -6.3F, -4F, 2, 10, 8);
		Leg2.setRotationPoint(-9F, 4F, 0F);
		Leg2.setTextureSize(165, 224);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0.3665191F);
		Leg3 = new ModelRenderer(this, 133, 23);
		Leg3.addBox(-4F, 2F, -4F, 8, 16, 8);
		Leg3.setRotationPoint(-9F, 4F, 0F);
		Leg3.setTextureSize(165, 224);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 27);
		Leg4.addBox(-4F, 15.9F, 4.3F, 8, 3, 3);
		Leg4.setRotationPoint(8F, 4F, 0F);
		Leg4.setTextureSize(165, 224);
		Leg4.mirror = true;
		setRotation(Leg4, -0.6108652F, 0F, 0F);
		Leg5 = new ModelRenderer(this, 0, 27);
		Leg5.addBox(-4F, 11.3F, 10.4F, 8, 2, 3);
		Leg5.setRotationPoint(8F, 4F, 0F);
		Leg5.setTextureSize(165, 224);
		Leg5.mirror = true;
		setRotation(Leg5, -0.9948377F, 0F, 0F);
		Leg6 = new ModelRenderer(this, 0, 37);
		Leg6.addBox(-4F, 15.4F, -7.8F, 8, 2, 1);
		Leg6.setRotationPoint(8F, 4F, 0F);
		Leg6.setTextureSize(165, 224);
		Leg6.mirror = true;
		setRotation(Leg6, 0.6457718F, 0F, 0F);
		Leg7 = new ModelRenderer(this, 0, 27);
		Leg7.addBox(-4F, 16.2F, 4.3F, 8, 3, 3);
		Leg7.setRotationPoint(-9F, 4F, 0F);
		Leg7.setTextureSize(165, 224);
		Leg7.mirror = true;
		setRotation(Leg7, -0.6108652F, 0F, 0F);
		Leg8 = new ModelRenderer(this, 0, 27);
		Leg8.addBox(-4F, 11.6F, 10.5F, 8, 2, 3);
		Leg8.setRotationPoint(-9F, 4F, 0F);
		Leg8.setTextureSize(165, 224);
		Leg8.mirror = true;
		setRotation(Leg8, -0.9948377F, 0F, 0F);
		Leg9 = new ModelRenderer(this, 0, 0);
		Leg9.addBox(-4F, 18F, -8F, 8, 2, 13);
		Leg9.setRotationPoint(-9F, 4F, 0F);
		Leg9.setTextureSize(165, 224);
		Leg9.mirror = true;
		setRotation(Leg9, 0F, 0F, 0F);
		Leg10 = new ModelRenderer(this, 0, 37);
		Leg10.addBox(-4F, 15.4F, -7.8F, 8, 2, 1);
		Leg10.setRotationPoint(-9F, 4F, 0F);
		Leg10.setTextureSize(165, 224);
		Leg10.mirror = true;
		setRotation(Leg10, 0.6457718F, 0F, 0F);
		Leg11 = new ModelRenderer(this, 133, 23);
		Leg11.addBox(-4F, 2F, -4F, 8, 16, 8);
		Leg11.setRotationPoint(8F, 4F, 0F);
		Leg11.setTextureSize(165, 224);
		Leg11.mirror = true;
		setRotation(Leg11, 0F, 0F, 0F);
		Leg12 = new ModelRenderer(this, 133, 0);
		Leg12.addBox(0.9F, -6.5F, -4F, 2, 10, 8);
		Leg12.setRotationPoint(8F, 4F, 0F);
		Leg12.setTextureSize(165, 224);
		Leg12.mirror = true;
		setRotation(Leg12, 0F, 0F, -0.3665191F);
		Head = new ModelRenderer(this, 0, 86);
		Head.addBox(-5F, -12F, -5F, 12, 12, 12);
		Head.setRotationPoint(-1F, -37F, -1F);
		Head.setTextureSize(165, 224);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body1 = new ModelRenderer(this, 49, 66);
		Body1.addBox(-6.5F, -2F, -3F, 4, 7, 7);
		Body1.setRotationPoint(-1F, -5.1F, -0.5F);
		Body1.setTextureSize(165, 224);
		Body1.mirror = true;
		setRotation(Body1, 0F, 0F, -0.3141593F);
		Body2 = new ModelRenderer(this, 75, 45);
		Body2.addBox(-3F, 0.1F, -2.5F, 7, 5, 6);
		Body2.setRotationPoint(-1F, -5.1F, -0.5F);
		Body2.setTextureSize(165, 224);
		Body2.mirror = true;
		setRotation(Body2, 0F, 0F, 0F);
		Body3 = new ModelRenderer(this, 49, 66);
		Body3.addBox(3.5F, -2.3F, -3F, 4, 7, 7);
		Body3.setRotationPoint(-1F, -5.1F, -0.5F);
		Body3.setTextureSize(165, 224);
		Body3.mirror = true;
		setRotation(Body3, 0F, 0F, 0.3141593F);
		Body4 = new ModelRenderer(this, 76, 95);
		Body4.addBox(-7F, -6.9F, -3.5F, 15, 7, 8);
		Body4.setRotationPoint(-1F, -5.1F, -0.5F);
		Body4.setTextureSize(165, 224);
		Body4.mirror = true;
		setRotation(Body4, 0F, 0F, 0F);
		Body5 = new ModelRenderer(this, 0, 118);
		Body5.addBox(-5F, -17.9F, -7.5F, 11, 12, 16);
		Body5.setRotationPoint(-1F, -5.1F, -0.5F);
		Body5.setTextureSize(165, 224);
		Body5.mirror = true;
		setRotation(Body5, 0F, 0F, 0F);
		Body6 = new ModelRenderer(this, 0, 185);
		Body6.addBox(-2.6F, -30.3F, -7.5F, 7, 23, 16);
		Body6.setRotationPoint(-1F, -5.1F, -0.5F);
		Body6.setTextureSize(165, 224);
		Body6.mirror = true;
		setRotation(Body6, 0F, 0F, -0.3665191F);
		Body7 = new ModelRenderer(this, 46, 185);
		Body7.addBox(-4F, -30.9F, -7.5F, 7, 23, 16);
		Body7.setRotationPoint(-1F, -5.1F, -0.5F);
		Body7.setTextureSize(165, 224);
		Body7.mirror = true;
		setRotation(Body7, 0F, 0F, 0.418879F);
		Body8 = new ModelRenderer(this, 0, 152);
		Body8.addBox(-7F, -29.9F, -7.5F, 16, 12, 16);
		Body8.setRotationPoint(-1F, -5.1F, -0.5F);
		Body8.setTextureSize(165, 224);
		Body8.mirror = true;
		setRotation(Body8, 0F, 0F, 0F);
		Arm1 = new ModelRenderer(this, 53, 42);
		Arm1.addBox(-10F, -8F, 0F, 2, 1, 2);
		Arm1.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm1.setTextureSize(165, 224);
		Arm1.mirror = true;
		setRotation(Arm1, 0F, 0F, 0F);
		Arm2 = new ModelRenderer(this, 76, 18);
		Arm2.addBox(3F, 26F, -5F, 8, 8, 15);
		Arm2.setRotationPoint(14.5F, -34F, -2F);
		Arm2.setTextureSize(165, 224);
		Arm2.mirror = true;
		setRotation(Arm2, 0F, 0F, 0F);
		Arm3 = new ModelRenderer(this, 53, 58);
		Arm3.addBox(-5.5F, -7F, -1.5F, 1, 3, 1);
		Arm3.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm3.setTextureSize(165, 224);
		Arm3.mirror = true;
		setRotation(Arm3, 0F, 0F, 0F);
		Arm4 = new ModelRenderer(this, 53, 53);
		Arm4.addBox(-9.5F, -6F, 0.5F, 1, 2, 1);
		Arm4.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm4.setTextureSize(165, 224);
		Arm4.mirror = true;
		setRotation(Arm4, 0F, 0F, 0F);
		Arm5 = new ModelRenderer(this, 53, 37);
		Arm5.addBox(-10.5F, -7F, -0.5F, 3, 1, 3);
		Arm5.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm5.setTextureSize(165, 224);
		Arm5.mirror = true;
		setRotation(Arm5, 0F, 0F, 0F);
		Arm6 = new ModelRenderer(this, 53, 30);
		Arm6.addBox(-6.5F, -8F, -2.5F, 3, 1, 3);
		Arm6.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm6.setTextureSize(165, 224);
		Arm6.mirror = true;
		setRotation(Arm6, 0F, 0F, 0F);
		Arm7 = new ModelRenderer(this, 53, 47);
		Arm7.addBox(-6F, -9F, -2F, 2, 1, 2);
		Arm7.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm7.setTextureSize(165, 224);
		Arm7.mirror = true;
		setRotation(Arm7, 0F, 0F, 0F);
		Arm8 = new ModelRenderer(this, 0, 44);
		Arm8.addBox(31.5F, -3F, -4F, 9, 21, 12);
		Arm8.setRotationPoint(-14.5F, -34F, -2F);
		Arm8.setTextureSize(165, 224);
		Arm8.mirror = true;
		setRotation(Arm8, 0F, 0F, 0F);
		Arm9 = new ModelRenderer(this, 76, 0);
		Arm9.addBox(34F, 18F, 0F, 4, 8, 4);
		Arm9.setRotationPoint(-14.5F, -34F, -2F);
		Arm9.setTextureSize(165, 224);
		Arm9.mirror = true;
		setRotation(Arm9, 0F, 0F, 0F);
		Arm10 = new ModelRenderer(this, 76, 0);
		Arm10.addBox(-9F, 18F, 0F, 4, 8, 4);
		Arm10.setRotationPoint(-14.5F, -34F, -2F);
		Arm10.setTextureSize(165, 224);
		Arm10.mirror = true;
		setRotation(Arm10, 0F, 0F, 0F);
		Arm11 = new ModelRenderer(this, 0, 44);
		Arm11.addBox(-11.5F, -4F, -3.5F, 9, 21, 12);
		Arm11.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm11.setTextureSize(165, 224);
		Arm11.mirror = true;
		setRotation(Arm11, 0F, 0F, 0F);
		Arm12 = new ModelRenderer(this, 76, 18);
		Arm12.addBox(-11F, 25F, -4.5F, 8, 8, 15);
		Arm12.setRotationPoint(-14.5F, -33F, -2.5F);
		Arm12.setTextureSize(165, 224);
		Arm12.mirror = true;
		setRotation(Arm12, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Leg5.render(f5);
		Leg6.render(f5);
		Leg7.render(f5);
		Leg8.render(f5);
		Leg9.render(f5);
		Leg10.render(f5);
		Leg11.render(f5);
		Leg12.render(f5);
		Head.render(f5);
		Body1.render(f5);
		Body2.render(f5);
		Body3.render(f5);
		Body4.render(f5);
		Body5.render(f5);
		Body6.render(f5);
		Body7.render(f5);
		Body8.render(f5);
		Arm1.render(f5);
		Arm2.render(f5);
		Arm3.render(f5);
		Arm4.render(f5);
		Arm5.render(f5);
		Arm6.render(f5);
		Arm7.render(f5);
		Arm8.render(f5);
		Arm9.render(f5);
		Arm10.render(f5);
		Arm11.render(f5);
		Arm12.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}