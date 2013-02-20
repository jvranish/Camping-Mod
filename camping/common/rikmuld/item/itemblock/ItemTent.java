package camping.common.rikmuld.item.itemblock;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import camping.common.rikmuld.core.lib.Blocks;
import camping.common.rikmuld.core.lib.Textures;
import camping.common.rikmuld.core.proxys.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTent extends ItemBlock {

	public ItemTent(int id) 
	{
		super(id);
		setHasSubtypes(true);
		setItemName(Blocks.BLOCK_TENT_NAME);
	}
	
	@Override
	public int getMetadata(int damageValue) 
	{
		return damageValue;
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int i) 
	{
		switch (i) 
		{
		case 0:return 18;
		case 1:return 18;
		case 2:return 18;
		case 3:return 18;
		case 4:return 18;
		case 5:return 18;
		default:return 18;
		}
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile() 
	{
		return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
	}
}
