package camping.common.rikmuld.item;

import camping.common.rikmuld.core.lib.Items;

public class TentContents extends CampingItem {

	public TentContents(int i) 
	{
		super(i);
		maxStackSize = 4;
		setMaxDamage(0);
		setItemName(Items.ITEM_TENT_CONTENTS_NAME);
		setIconIndex(22);
	}
}
