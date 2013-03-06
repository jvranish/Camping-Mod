package rikmuld.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCampfire extends ModelBase {
  
	ModelRenderer Stone_3;
    ModelRenderer Stone_1;
    ModelRenderer Stone_2;
    ModelRenderer Stone_4;
    ModelRenderer stone_5;
    ModelRenderer stone_6;
    ModelRenderer stone_7;
    ModelRenderer stone_8;
    ModelRenderer balk_1;
    ModelRenderer balk_2;
    ModelRenderer balk_3;
    ModelRenderer balk_4;
    ModelRenderer top;
  
  public ModelCampfire()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Stone_3 = new ModelRenderer(this, 46, 0);
      Stone_3.addBox(0F, 0F, -4F, 2, 2, 6);
      Stone_3.setRotationPoint(4F, 22F, 1F);
      Stone_3.setTextureSize(128, 64);
      Stone_3.mirror = true;
      setRotation(Stone_3, 0F, 0F, 0F);
      Stone_1 = new ModelRenderer(this, 46, 0);
      Stone_1.addBox(0F, 0F, 0F, 2, 2, 6);
      Stone_1.setRotationPoint(-6F, 22F, -3F);
      Stone_1.setTextureSize(128, 64);
      Stone_1.mirror = true;
      setRotation(Stone_1, 0F, 0F, 0F);
      Stone_2 = new ModelRenderer(this, 10, 4);
      Stone_2.addBox(0F, 0F, 0F, 6, 2, 2);
      Stone_2.setRotationPoint(-3F, 22F, 4F);
      Stone_2.setTextureSize(128, 64);
      Stone_2.mirror = true;
      setRotation(Stone_2, 0F, 0F, 0F);
      Stone_4 = new ModelRenderer(this, 10, 0);
      Stone_4.addBox(0F, 0F, 0F, 6, 2, 2);
      Stone_4.setRotationPoint(-3F, 22F, -6F);
      Stone_4.setTextureSize(128, 64);
      Stone_4.mirror = true;
      setRotation(Stone_4, 0F, 0F, 0F);
      stone_5 = new ModelRenderer(this, 0, 0);
      stone_5.addBox(0F, 0F, 0F, 4, 2, 1);
      stone_5.setRotationPoint(2F, 22F, 5F);
      stone_5.setTextureSize(128, 64);
      stone_5.mirror = true;
      setRotation(stone_5, 0F, 0.8597554F, 0F);
      stone_6 = new ModelRenderer(this, 0, 6);
      stone_6.addBox(0F, 0F, 0F, 4, 2, 1);
      stone_6.setRotationPoint(-2F, 22F, -5F);
      stone_6.setTextureSize(128, 64);
      stone_6.mirror = true;
      setRotation(stone_6, 0F, -2.374784F, 0F);
      stone_7 = new ModelRenderer(this, 0, 9);
      stone_7.addBox(0F, 0F, 0F, 4, 2, 1);
      stone_7.setRotationPoint(5F, 22F, -2F);
      stone_7.setTextureSize(128, 64);
      stone_7.mirror = true;
      setRotation(stone_7, 0F, 2.384079F, 0F);
      stone_8 = new ModelRenderer(this, 0, 3);
      stone_8.addBox(0F, 0F, 0F, 4, 2, 1);
      stone_8.setRotationPoint(-5F, 22F, 2F);
      stone_8.setTextureSize(128, 64);
      stone_8.mirror = true;
      setRotation(stone_8, 0F, -0.7436755F, 0F);
      balk_1 = new ModelRenderer(this, 32, 0);
      balk_1.addBox(0F, 0F, 0F, 1, 10, 2);
      balk_1.setRotationPoint(-1F, 14F, -1F);
      balk_1.setTextureSize(128, 64);
      balk_1.mirror = true;
      setRotation(balk_1, 0F, 0F, 0.4363323F);
      balk_2 = new ModelRenderer(this, 32, 12);
      balk_2.addBox(0F, 0F, 0F, 1, 10, 2);
      balk_2.setRotationPoint(5F, 23F, -1F);
      balk_2.setTextureSize(128, 64);
      balk_2.mirror = true;
      setRotation(balk_2, 0F, 0F, 2.742439F);
      balk_3 = new ModelRenderer(this, 26, 0);
      balk_3.addBox(0F, 0F, 0F, 2, 10, 1);
      balk_3.setRotationPoint(-1F, 23F, 5F);
      balk_3.setTextureSize(128, 64);
      balk_3.mirror = true;
      setRotation(balk_3, -2.740167F, 0F, 0F);
      balk_4 = new ModelRenderer(this, 26, 11);
      balk_4.addBox(0F, 0F, 0F, 2, 10, 1);
      balk_4.setRotationPoint(-1F, 23F, -4F);
      balk_4.setTextureSize(128, 64);
      balk_4.mirror = true;
      setRotation(balk_4, 2.731079F, 0F, 0F);
      top = new ModelRenderer(this, 38, 0);
      top.addBox(0F, 0F, 0F, 2, 1, 2);
      top.setRotationPoint(-1F, 13F, -1F);
      top.setTextureSize(128, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Stone_3.render(f5);
    Stone_1.render(f5);
    Stone_2.render(f5);
    Stone_4.render(f5);
    stone_5.render(f5);
    stone_6.render(f5);
    stone_7.render(f5);
    stone_8.render(f5);
    balk_1.render(f5);
    balk_2.render(f5);
    balk_3.render(f5);
    balk_4.render(f5);
    top.render(f5);
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
	  Stone_3.render(f5);
	  Stone_1.render(f5);
	  Stone_2.render(f5);
	  Stone_4.render(f5);
	  stone_5.render(f5);
	  stone_6.render(f5);
	  stone_7.render(f5);
	  stone_8.render(f5);
	  balk_1.render(f5);
	  balk_2.render(f5);
	  balk_3.render(f5);
	  balk_4.render(f5);
	  top.render(f5);
  }
}
