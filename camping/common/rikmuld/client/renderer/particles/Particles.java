package camping.common.rikmuld.client.renderer.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.world.World;
import camping.common.rikmuld.client.renderer.particles.fx.FXColoredFlame;

public class Particles{

	private static Minecraft mc = Minecraft.getMinecraft();
	private static World theWorld = mc.theWorld;
	private static RenderEngine renderEngine = mc.renderEngine;

	public EntityFX doSpawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12, int color)
	{
	if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null)
	{
	int var14 = mc.gameSettings.particleSetting;

	if (var14 == 1 && theWorld.rand.nextInt(3) == 0)
	{
	var14 = 2;
	}

	double var15 = mc.renderViewEntity.posX - par2;
	double var17 = mc.renderViewEntity.posY - par4;
	double var19 = mc.renderViewEntity.posZ - par6;
	EntityFX var21 = null;
	double var22 = 16.0D;

	if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22)
	{
	return null;
	}
	else if (var14 > 1)
	{
	return null;
	}
	else
	{
	if (particleName.equals("coloredflame"))
	{
	var21 = new FXColoredFlame(theWorld, par2, par4, par6, par8, par10, par12, color);
	}

	mc.effectRenderer.addEffect((EntityFX)var21);
	return (EntityFX)var21;
	}
	}
	return null;
	}
}

