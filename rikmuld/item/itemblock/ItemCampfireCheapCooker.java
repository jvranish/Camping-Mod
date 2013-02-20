package camping.common.rikmuld.item.itemblock;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.core.proxys.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCampfireCheapCooker extends ItemBlock {
	
	public ItemCampfireCheapCooker(int id) 
	{
		super(id);
		setHasSubtypes(true);
		setItemName(Blocks.BLOCK_META_CAMP_CHEAP_INSTA_NAME);
	}
	
	private static int color = 8;
	private static int colormeta = 1;
	
	private final static String[] subNames = {Blocks.BLOCK_CAMP_CHEAP_NAME, Blocks.BLOCK_CAMP_INSTA_NAME};
		
	public static void settexture(int colorcc, int colormetacc)
	{
		color = colorcc;
		colormeta = colormetacc;
	}
	
	@Override
	public int getMetadata (int damageValue) 
	{
		return damageValue;
	}
		
	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i)
	{
		switch(i)
	    {
	     case 0: return color;
	     case 1: return colormeta; 
	     default: return 0;
	    }
	}
		
	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{ 
		return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
	}
		
	@Override
	public String getItemNameIS(ItemStack itemstack) 
	{
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
}
		
