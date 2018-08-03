package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability;

public class ItemRealKeyblade extends ItemKeyblade {
	//Ability ability;
	
    public ItemRealKeyblade (String name, double strength, double magic, String ability) {
    	super(name,strength,magic,ability);
        setMaxStackSize(1);
    	//this.ability = ability;
    }
    public ItemRealKeyblade (String name, double strength, double magic) {
        super(name, strength, magic);
        setMaxStackSize(1);
    }

    //public Ability getAbility() {
       // return this.ability;
   // }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityIn;
            if (!player.isCreative() && !player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
                SummonKeybladeCapability.ISummonKeyblade keyblade = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null);
                DriveStateCapability.IDriveState driveformCap = player.getCapability(ModCapabilities.DRIVE_STATE, null);
                if (!keyblade.getIsKeybladeSummoned(EnumHand.MAIN_HAND) && !keyblade.getIsKeybladeSummoned(EnumHand.OFF_HAND) && !driveformCap.getInDrive()) {
                    stack.setCount(0);
                }
            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    /*
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand)
    {

        if (!(player.getHeldItem(EnumHand.OFF_HAND) != null && player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade))
        {

            double posX = player.getPosition().getX();
            double posZ = player.getPosition().getZ();
            double distance = 3.0D;
            //System.out.println(FMLCommonHandler.instance().getEffectiveSide());
            AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
            List list = worldIn.getEntitiesWithinAABBExcludingEntity(player, aabb);
            if(player.onGround)
            {
                //System.out.println(player.rotationYaw);
                if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
                    Entity e = (Entity) list.get(i);
                    if (e instanceof EntityLivingBase) {
                        player.swingArm(hand);
                        e.motionY=1.15;
                        e.attackEntityFrom(DamageSource.magic, 1);
                        player.motionY = 1.15;
                    }
                }
            }
            else
            {
                if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
                    Entity e = (Entity) list.get(i);
                    if (e instanceof EntityLivingBase)
                    {
                        double d = e.posX - posX;
                        double d1;
                        for (d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
                            d = (Math.random() - Math.random()) * 0.01D;
                        ((EntityLivingBase) e).knockBack(e, 1, -d, -d1);
                        e.motionY*=1.15;
                        e.attackEntityFrom(DamageSource.causePlayerDamage(player), (float) DamageCalculation.getStrengthDamage(player, (ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()));
                        System.out.println(DamageCalculation.getStrengthDamage(player, (ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()));
                    }
                }
            }
            aabb.expand(-2, -2, -2);
        }
        return super.onItemRightClick(itemStackIn, worldIn, player, hand);

    }
    */
}
