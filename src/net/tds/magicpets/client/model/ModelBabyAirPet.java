package net.tds.magicpets.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBabyAirPet extends ModelBase {
	// fields
	ModelRenderer backrLeg;
	ModelRenderer frontrLeg;
	ModelRenderer frontlLeg;
	ModelRenderer backlLeg;
	ModelRenderer Body;
	ModelRenderer rWing;
	ModelRenderer lWing;
	ModelRenderer Head;
	ModelRenderer Beak;
	ModelRenderer Tail;

	public ModelBabyAirPet() {
		textureWidth = 256;
		textureHeight = 256;

		backrLeg = new ModelRenderer(this, 0, 0);
		backrLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		backrLeg.setRotationPoint(-0.1F, 22F, -0.3F);
		backrLeg.setTextureSize(256, 256);
		backrLeg.mirror = true;
		setRotation(backrLeg, 0F, 0F, 0F);
		frontrLeg = new ModelRenderer(this, 0, 0);
		frontrLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		frontrLeg.setRotationPoint(-0.1F, 22F, -3.1F);
		frontrLeg.setTextureSize(256, 256);
		frontrLeg.mirror = true;
		setRotation(frontrLeg, 0F, 0F, 0F);
		frontlLeg = new ModelRenderer(this, 0, 0);
		frontlLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		frontlLeg.setRotationPoint(2.1F, 22F, -3.1F);
		frontlLeg.setTextureSize(256, 256);
		frontlLeg.mirror = true;
		setRotation(frontlLeg, 0F, 0F, 0F);
		backlLeg = new ModelRenderer(this, 0, 0);
		backlLeg.addBox(0F, 0F, 0F, 1, 2, 1);
		backlLeg.setRotationPoint(2.1F, 22F, -0.3F);
		backlLeg.setTextureSize(256, 256);
		backlLeg.mirror = true;
		setRotation(backlLeg, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 45);
		Body.addBox(-2F, 0F, 0F, 3, 3, 4);
		Body.setRotationPoint(2F, 20F, -3F);
		Body.setTextureSize(256, 256);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		rWing = new ModelRenderer(this, 0, 26);
		rWing.addBox(0F, 0F, 0F, 1, 3, 5);
		rWing.setRotationPoint(-1F, 20F, -3F);
		rWing.setTextureSize(256, 256);
		rWing.mirror = true;
		setRotation(rWing, -0.0523599F, -0.1047198F, 0F);
		lWing = new ModelRenderer(this, 0, 14);
		lWing.addBox(0F, 0F, 0F, 1, 3, 5);
		lWing.setRotationPoint(3F, 20F, -3F);
		lWing.setTextureSize(256, 256);
		lWing.mirror = true;
		setRotation(lWing, -0.0523599F, 0.1047198F, 0F);
		Head = new ModelRenderer(this, 14, 0);
		Head.addBox(-2F, -2F, -3F, 3, 3, 3);
		Head.setRotationPoint(2F, 21F, -3F);
		Head.setTextureSize(256, 256);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Beak = new ModelRenderer(this, 33, 0);
		Beak.addBox(-2.8F, 1.2F, 0F, 1, 1, 1);
		Beak.setRotationPoint(2F, 21F, -3F);
		Beak.setTextureSize(256, 256);
		Beak.mirror = true;
		setRotation(Beak, 0F, -1.58825F, 0.6806784F);
		Tail = new ModelRenderer(this, 0, 39);
		Tail.addBox(0F, 0F, 0F, 1, 1, 2);
		Tail.setRotationPoint(1F, 21F, 1F);
		Tail.setTextureSize(256, 256);
		Tail.mirror = true;
		setRotation(Tail, -0.8901179F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		backrLeg.render(f5);
		frontrLeg.render(f5);
		frontlLeg.render(f5);
		backlLeg.render(f5);
		Body.render(f5);
		rWing.render(f5);
		lWing.render(f5);
		Head.render(f5);
		Beak.render(f5);
		Tail.render(f5);
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
