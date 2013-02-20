package camping.common.rikmuld.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTentSleeping extends ModelBase {

	ModelRenderer Shape10;
	ModelRenderer Shape9;
	ModelRenderer Shape8;
	ModelRenderer Shape7;
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape6;
	ModelRenderer Shape5;
	ModelRenderer Shape4;
	ModelRenderer Shape3;
	ModelRenderer Shape11;

	public ModelTentSleeping() 
	{
		textureWidth = 256;
		textureHeight = 128;

		Shape10 = new ModelRenderer(this, 0, 0);
		Shape10.addBox(0F, 0F, 0F, 48, 1, 12);
		Shape10.setRotationPoint(-8F, 23.8F, -15.2F);
		Shape10.setTextureSize(256, 128);
		Shape10.mirror = true;
		setRotation(Shape10, 0.835486F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(0F, 0F, 0F, 48, 1, 12);
		Shape9.setRotationPoint(-8F, 23.8F, 15.2F);
		Shape9.setTextureSize(256, 128);
		Shape9.mirror = true;
		setRotation(Shape9, 2.402461F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, 0F, 48, 1, 11);
		Shape8.setRotationPoint(-8F, 15.6F, 6.4F);
		Shape8.setTextureSize(256, 128);
		Shape8.mirror = true;
		setRotation(Shape8, 2.048128F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 48, 1, 6);
		Shape7.setRotationPoint(-8F, 6.2F, 1.6F);
		Shape7.setTextureSize(256, 128);
		Shape7.mirror = true;
		setRotation(Shape7, 1.936593F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape1.setRotationPoint(-7.8F, 20F, 15F);
		Shape1.setTextureSize(256, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape2.setRotationPoint(38.8F, 20F, 15F);
		Shape2.setTextureSize(256, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, 0F, 48, 1, 11);
		Shape6.setRotationPoint(-8F, 15.2F, -7.3F);
		Shape6.setTextureSize(256, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 1.081485F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(0F, 0F, 0F, 48, 1, 6);
		Shape5.setRotationPoint(-8F, 6F, -2.2F);
		Shape5.setTextureSize(256, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 1.267377F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape4.setRotationPoint(38.8F, 20F, -15.4F);
		Shape4.setTextureSize(256, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape3.setRotationPoint(-7.8F, 20F, -15.4F);
		Shape3.setTextureSize(256, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 26);
		Shape11.addBox(0F, 0F, 0F, 32, 1, 16);
		Shape11.setRotationPoint(-2F, 23F, -11F);
		Shape11.setTextureSize(256, 128);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape10.render(f5);
		Shape9.render(f5);
		Shape8.render(f5);
		Shape7.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape6.render(f5);
		Shape5.render(f5);
		Shape4.render(f5);
		Shape3.render(f5);
		Shape11.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) 
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) 
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

	public void renderModel(float f5) 
	{
		Shape10.render(f5);
		Shape9.render(f5);
		Shape8.render(f5);
		Shape7.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape6.render(f5);
		Shape5.render(f5);
		Shape4.render(f5);
		Shape3.render(f5);
		Shape11.render(f5);
	}
}