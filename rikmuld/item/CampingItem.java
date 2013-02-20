package camping.common.rikmuld.item;

import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.core.proxys.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

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
