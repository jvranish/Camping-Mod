package rikmuld.item.itemblock;

import net.minecraft.item.ItemBlock;
import rikmuld.core.lib.Blocks;
import rikmuld.core.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCampfireFastCooker extends ItemBlock {
	
	public ItemCampfireFastCooker(int id) 
	{
		super(id);
		setItemName(Blocks.BLOCK_CAMP_FAST_NAME);
	}
	
	private static int color = 4;
	
	public static void settexture(int colorfc, int colormetafc)
	{
		 color = colorfc;
	}
		
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
	    {
	    	case 0: return color;
	    	default: return 0;
	    }
    }
		
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{ 
		return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
	}
}
		
