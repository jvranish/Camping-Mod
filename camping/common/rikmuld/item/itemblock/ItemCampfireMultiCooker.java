package camping.common.rikmuld.item.itemblock;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemCampfireMultiCooker extends ItemBlock {
	
	public ItemCampfireMultiCooker(int id) 
	{
		super(id);
		setHasSubtypes(true);
		setItemName(Blocks.BLOCK_META_CAMP_NORMAL_MULTI_NAME);
	}
	
	private static int color = 15;
	private static int colormeta = 2;
	
	private final static String[] subNames = {Blocks.BLOCK_CAMP_NAME, Blocks.BLOCK_CAMP_MULTI_NAME};
	
	@Override
	public int getMetadata (int damageValue) 
	{
		return damageValue;
	}
	
	public static void settexture(int colormc, int colormetamc)
	{
		color = colormc;
		colormeta = colormetamc;
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
		
