package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.gui.GuiOrgUnlock;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortal;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemLexicon extends ItemOrgWeapon implements IOrgWeapon{

	public ItemLexicon (double strength, double magic)  {
		super(strength,magic);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("VI Zexion");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiOrgUnlock());
		if(world.isRemote){
			RayTraceResult rtr = InputHandler.getMouseOverExtended(100);
	        if (rtr != null) {
            	if (rtr.typeOfHit == rtr.typeOfHit.BLOCK){
		            if (rtr.typeOfHit != null) {
		                double distanceSq = player.getDistanceSq(rtr.getBlockPos());
		                double reachSq = 100 * 100;
		                if (reachSq >= distanceSq) 
		                {
	                		BlockPos pos = rtr.getBlockPos();
	                		
	                		//player.world.spawnParticle(EnumParticleTypes.REDSTONE, pos.getX()+0.5, pos.getY(), pos.getZ()+0.5, 1, 1, 1, 1,2,2);
	                		EntityOrgPortal portal = new EntityOrgPortal(player.world, player, pos);
	                		player.world.spawnEntity(portal);
	                		System.out.println(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getPortal());
	            			PacketDispatcher.sendToServer(new OrgPortal(rtr.getBlockPos()));
	            			player.world.playSound((EntityPlayer)player, player.getPosition(), ModSounds.lockon, SoundCategory.MASTER, 1.0f, 1.0f);
	                	}
	                }
	            }
	        }
		}
		
		return super.onItemRightClick(itemStack, world, player, hand);
	}
	
	@Override
	public OrgMember getMember() {
		return Utils.OrgMember.ZEXION;
	}
}
