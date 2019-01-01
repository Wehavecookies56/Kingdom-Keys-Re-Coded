package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySlash;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityAshes;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityBlazeofGlory;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityBurnout;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityCombustion;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityDoledrum;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityDoubleEdge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityEternalFlames;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityFerrisWheels;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityIfrit;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityInferno;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityMoulinRouge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityOmegaTrinity;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityOutbreak;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityPrometheus;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityProminence;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntitySizzlingEdge;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemScythe extends ItemOrgWeapon implements IOrgWeapon{

    public ItemScythe (String name, double[] stats)  {
        super(name, stats);
        setMaxStackSize(1);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        Entity entity = new EntitySlash(world, player);

        if(!player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge()) {
            if (!player.isSneaking()) {
                world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
                world.spawnEntity(entity);
                ((EntityThrowable) entity).setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1f, 1);
                if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
                    player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(5);
                player.swingArm(hand);
            }
            return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
        }
        return ActionResult.newResult(EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.MARLUXIA;
    }
}
