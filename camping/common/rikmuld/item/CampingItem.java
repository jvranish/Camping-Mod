package camping.common.rikmuld.item;

import net.minecraft.item.Item;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CampingItem extends Item{

	public CampingItem(int par1) 
	{
		super(par1);
		this.setCreativeTab(CampingMod.customTab);
	}
	
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{ 
		return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
	}
}
