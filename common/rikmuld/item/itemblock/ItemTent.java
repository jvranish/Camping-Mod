package rikmuld.item.itemblock;

import net.minecraft.item.ItemBlock;
import rikmuld.core.lib.Blocks;
import rikmuld.core.lib.Textures;
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
		return 18;
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile() 
	{
		return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
	}
}
