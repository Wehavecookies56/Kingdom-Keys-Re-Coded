package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemArrowguns extends ItemOrgWeapon implements IOrgWeapon {

    int ammo, reload, tempAmmo;

    public ItemArrowguns(String name, double[] stats) {
        super(name, stats);
        setMaxStackSize(1);
    }

    public ItemArrowguns(String name, double[] stats, int ammo, int reload) {
        super(name, stats);
        this.ammo = ammo;
        this.reload = reload;
        setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!player.isSneaking()) {
            // if (player.getCapability(ModCapabilities.PLAYER_STATS, null).getMP() > 0 &&
            // !player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge() ||
            // player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
            if (player.getHeldItem(hand).getTagCompound().getInteger("ammo") > 0) {
                world.playSound(player.posX, player.posY, player.posZ, ModSounds.sharpshooterbullet, SoundCategory.PLAYERS, 0.5F, 1F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
                EntitySharpshooterBullet bullet = new EntitySharpshooterBullet(world, player);
                world.spawnEntity(bullet);
                bullet.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 4f, 0);
                // if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
                // player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(5);
                player.swingArm(EnumHand.MAIN_HAND);
                tempAmmo = player.getHeldItem(hand).getTagCompound().getInteger("ammo") - 1;
                player.getHeldItem(hand).getTagCompound().setInteger("ammo", tempAmmo);
            }

        } else {
            // player.setItemInUse(stack, getMaxItemUseDuration(stack));
        }
        if (player.isSneaking() == true) {
            if (player.getHeldItemMainhand().getItemDamage() == 0) {
                if (!world.isRemote) {
                    player.getHeldItemMainhand().setItemDamage(1);
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getHeldItemMainhand());
                    player.world.playSound((EntityPlayer) null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
                }
            } else {
                if (!world.isRemote) {
                    player.getHeldItemMainhand().setItemDamage(0);
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getHeldItemMainhand());
                    player.world.playSound((EntityPlayer) null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
                }
            }
            return super.onItemRightClick(world, player, hand);
        }

        return super.onItemRightClick(world, player, hand);
    }


    public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
        if (!itemStack.hasTagCompound()) {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setInteger("ammo", ammo);
            itemStack.getTagCompound().setInteger("reload", reload);
        }

        if (itemStack.getTagCompound().getInteger("ammo") == 0) {
            int cd = itemStack.getTagCompound().getInteger("reload");
            if (cd > 0) {
                cd--;
                itemStack.getTagCompound().setInteger("reload", cd);
            } else {
                itemStack.getTagCompound().setInteger("reload", reload);
                itemStack.getTagCompound().setInteger("ammo", ammo);
            }
        }
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.XIGBAR;
    }
}
