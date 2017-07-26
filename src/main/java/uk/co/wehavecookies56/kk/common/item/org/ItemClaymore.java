package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.DesummonClaymore;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonClaymore;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemClaymore extends ItemOrgWeapon implements IOrgWeapon{

    public ItemClaymore (String name, double strength, double magic)  {
        super(name, strength, magic);
        setMaxStackSize(1);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(Utils.translateToLocal(Strings.LunaticDesc));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(player.getHeldItemMainhand().getItemDamage()==0){
            if(world.isRemote){
                PacketDispatcher.sendToServer(new SummonClaymore((ItemClaymore) player.getHeldItemMainhand().getItem()));
            }else{
                player.getHeldItemMainhand().setItemDamage(1);
                player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getHeldItemMainhand());
                player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
            }
        }else{
            if(world.isRemote){
                PacketDispatcher.sendToServer(new DesummonClaymore((ItemClaymore) player.getHeldItemMainhand().getItem()));
            }else{
                player.getHeldItemMainhand().setItemDamage(0);
                player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getHeldItemMainhand());
                player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        super.getSubItems(tab, items);
        if (isInCreativeTab(tab)) {
            items.add(new ItemStack(this, 1, 1));
        }
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.SAIX;
    }
}
