package camping.common.rikmuld.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import camping.common.rikmuld.CampingMod;
import camping.common.rikmuld.core.lib.Config;
import camping.common.rikmuld.core.lib.Items;
import camping.common.rikmuld.core.lib.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FoodRadish extends ItemFood{

	   public final int itemUseDuration;
	    private final int healAmount;
	    private final float saturationModifier;
	    private final boolean isWolfsFavoriteMeat;
	    private boolean alwaysEdible;
	    private int potionId;
	    private int potionDuration;
	    private int potionAmplifier;
	    private float potionEffectProbability;

	    public FoodRadish(int par1, int par2, float par3, boolean par4)
	    {
	        super(par1, par2, par4);
	        this.itemUseDuration = 64;
			maxStackSize = 64;
	        this.healAmount = Config.PLANT_RADISH_HEAL;
	        this.isWolfsFavoriteMeat = false;
	        this.saturationModifier = par3;
	        this.setItemName(Items.ITEM_RADISH_FOOD_NAME);
	        this.setCreativeTab(CampingMod.customTab);
	        setIconIndex(27);
	    }

	    public FoodRadish(int par1, int par2, boolean par3)
	    {
	        this(par1, par2, 0.6F, par3);
	    }
	    
	    @SideOnly(Side.CLIENT)
		public String getTextureFile()
		{ 
	    	return Textures.SPRITE_LOCATION + Textures.SPRITE_ITEM;
		}
	    
	    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        --par1ItemStack.stackSize;
	        par3EntityPlayer.getFoodStats().addStats(this);
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        this.func_77849_c(par1ItemStack, par2World, par3EntityPlayer);
	        return par1ItemStack;
	    }

	    protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
	        {
	            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
	        }
	    }

	    public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 8;
	    }

	    public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.eat;
	    }

	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (par3EntityPlayer.canEat(this.alwaysEdible))
	        {
	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        }

	        return par1ItemStack;
	    }

	    public int getHealAmount()
	    {
	        return this.healAmount;
	    }

	    public float getSaturationModifier()
	    {
	        return this.saturationModifier;
	    }

	    public boolean isWolfsFavoriteMeat()
	    {
	        return this.isWolfsFavoriteMeat;
	    }

	    public ItemFood setPotionEffect(int par1, int par2, int par3, float par4)
	    {
	        this.potionId = par1;
	        this.potionDuration = par2;
	        this.potionAmplifier = par3;
	        this.potionEffectProbability = par4;
	        return this;
	    }

	    public ItemFood setAlwaysEdible()
	    {
	        this.alwaysEdible = false;
	        return this;
	    }
}
