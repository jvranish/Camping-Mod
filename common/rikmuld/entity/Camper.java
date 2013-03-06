package rikmuld.entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rikmuld.core.lib.Textures;

public class Camper extends EntityAnimal{

	 Random generator = new Random();
	 int textnum = generator.nextInt(6) + 1;
	 
	 public Camper(World par1World) 
	 {
	  super(par1World);
	  this.moveSpeed = 0.30F;
	  this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMob.class, 8.0F, 0.3F, 0.35F));
      this.tasks.addTask(2, new EntityAIMoveIndoors(this));
      this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
      this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
      this.tasks.addTask(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
      this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(9, new EntityAIWatchClosest2(this, Camper.class, 5.0F, 0.02F));
      this.tasks.addTask(9, new EntityAIWander(this, 0.3F));
      this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
      this.isImmuneToFire = true;
	 }
	 
	 public int getMaxHealth() 
	 {
		 return 24;
	 }
	
	 protected boolean isAIEnabled()
	 {
		 return true;
	 }
	 
	 public EnumCreatureAttribute getCreatureAttribute()
	 {
		 return EnumCreatureAttribute.UNDEFINED;
	 }
	 
	 public int getAttackStrength(Entity par1Entity)
	 {
	     return 6;
	 }

	 public String getTexture()
	{
	      if (textnum==1)
	      {
	    	  return Textures.MODEL_LOCATION + Textures.MODEL_CAMPER_MALE;
          }
		  if (textnum==2)
		  {
			  return Textures.MODEL_LOCATION + Textures.MODEL_CAMPER_FEMALE;
          }
          if (textnum==3)
          {
        	  return Textures.MODEL_LOCATION + Textures.MODEL_CAMPER_MALE;
          }
          if (textnum==4)
          {
        	  return Textures.MODEL_LOCATION + Textures.MODEL_CAMPER_FEMALE;
          }
          else
          {
        	  return Textures.MODEL_LOCATION + Textures.MODEL_CAMPER_MALE;
          } 
	 }
	 
	 protected boolean canDespawn()
	 {
		 return false;
	 }

	 protected String getLivingSound()
	 {
		 return "mob.villager.default";
	 }

	 protected String getHurtSound()
	 {
	     return "mob.villager.defaulthurt";
	 }

	 protected String getDeathSound()
	 {
	     return "mob.villager.defaultdeath";
	 }

	 protected void playStepSound(int par1, int par2, int par3, int par4)
	 {
		 this.worldObj.playSoundAtEntity(this, "mob.villager.step", 0.15F, 1.0F);
	 }

	 @Override
	 public EntityAgeable createChild(EntityAgeable var1) 
	 {
		return null;
	 }	    	    
}
