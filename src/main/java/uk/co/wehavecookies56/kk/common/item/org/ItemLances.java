package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import uk.co.wehavecookies56.kk.common.entity.projectiles.lances.EntityLance;
import uk.co.wehavecookies56.kk.common.entity.projectiles.lances.EntityZephyr;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemLances extends ItemOrgWeapon implements IOrgWeapon{
	String weapon;
    public ItemLances (String name, double[] stats) {
        super(name, stats);
        this.weapon = name;
        setMaxStackSize(1);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public boolean hitEntity (ItemStack item, EntityLivingBase entity, EntityLivingBase p_77644_3_) {
        //entity.setFire(5);
        return super.hitEntity(item, entity, p_77644_3_);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        Entity entity;
        switch(weapon){
            /*case Strings.Ashes:
                entity = new EntityAshes(world, player);
                break;
            case Strings.BlazeofGlory:
                entity = new EntityBlazeofGlory(world, player);
                break;
            case Strings.EternalFlames:
                entity = new EntityEternalFlames(world, player);
                break;
            case Strings.Ifrit:
                entity = new EntityIfrit(world, player);
                break;
            case Strings.Prometheus:
                entity = new EntityPrometheus(world, player);
                break;
            case Strings.Prominence:
                entity = new EntityProminence(world, player);
                break;
            case Strings.MoulinRouge:
                entity = new EntityMoulinRouge(world, player);
                break;
            case Strings.FerrisWheel:
                entity = new EntityFerrisWheels(world, player);
                break;
            case Strings.Combustion:
                entity = new EntityCombustion(world, player);
                break;
            case Strings.Burnout:
                entity = new EntityBurnout(world, player);
                break;
            case Strings.OmegaTrinity:
                entity = new EntityOmegaTrinity(world, player);
                break;
            case Strings.Doldrums:
                entity = new EntityDoledrum(world, player);
                break;
            case Strings.Outbreak:
                entity = new EntityOutbreak(world, player);
                break;
            case Strings.Inferno:
                entity = new EntityInferno(world, player);
                break;
            case Strings.SizzlingEdge:
                entity= new EntitySizzlingEdge(world, player);
                break;
            case Strings.DoubleEdge:
                entity= new EntityDoubleEdge(world, player);
                break;*/
            default:
                entity = new EntityZephyr(world, player);
                break;
        }

        if(!player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge()) {
            if (!player.isSneaking()) {
                world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
                world.spawnEntity(entity);
                ((EntityLance) entity).setAim(player, 2, 0);//setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1f, 1);
                if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
                    player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(7);
                player.swingArm(hand);
            }
            return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
        }
        return ActionResult.newResult(EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.XALDIN;
    }
}
