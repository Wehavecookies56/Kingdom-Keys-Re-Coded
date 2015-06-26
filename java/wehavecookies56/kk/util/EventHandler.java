package wehavecookies56.kk.util;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.client.keys.Keybinds;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemMunny;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.network.MunnyPickup;
import wehavecookies56.kk.network.OpenGui;
import wehavecookies56.kk.network.PacketDispatcher;
import wehavecookies56.kk.network.SyncExtendedPlayer;

public class EventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			ExtendedPlayer.register((EntityPlayer) event.entity);
	}
	
	@SubscribeEvent
	public void OnEntityJoinWorld(EntityJoinWorldEvent event){
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			ExtendedPlayer.get((EntityPlayer) event.entity).loadProxyData(((EntityPlayer) event.entity));
			PacketDispatcher.sendTo(new SyncExtendedPlayer((EntityPlayer) event.entity), ((EntityPlayerMP) event.entity));
		}

	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			ExtendedPlayer.get((EntityPlayer) event.entity).saveProxyData(((EntityPlayer) event.entity));
			
		} else {}
	}
	
	public static int randInt(int min, int max, Random rand) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event)
	{
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.source.getSourceOfDamage();
			if(player.getCurrentEquippedItem() != null)
			{
				if(player.getCurrentEquippedItem().getItem() instanceof ItemKeyblade)
				{
					if(event.entity instanceof EntityAnimal)
					{
						event.entityLiving.entityDropItem(new ItemStack(ModItems.Heart), 2);

					}
					else if(event.entity instanceof EntityMob)
					{
						event.entityLiving.entityDropItem(new ItemStack(ModItems.DarkHeart), 2);
					}
					else if(event.entity instanceof EntityAgeable)
					{
						event.entityLiving.entityDropItem(new ItemStack(ModItems.PureHeart), 2);
					}
					else if(event.entity instanceof EntityDragon||event.entity instanceof EntityWither)
					{
						event.entityLiving.entityDropItem(new ItemStack(ModItems.KingdomHearts), 2);
					}
				}
			}
			ItemStack munny = new ItemStack(ModItems.Munny, 1);
			munny.setTagCompound(new NBTTagCompound());
			munny.getTagCompound().setInteger("amount", 100);
			event.entityLiving.entityDropItem(munny, 1);
		}		
	}
	
	@SubscribeEvent
	public void onEntityItemPickUp(EntityItemPickupEvent event){
		
		if(event.item.getEntityItem().getItem() instanceof ItemMunny){
			MunnyPickup packet = new MunnyPickup(event.item.getEntityItem());
	    	PacketDispatcher.sendToServer(packet);
		}
	}
	
	@SubscribeEvent
	public void onItemTossEvent(ItemTossEvent event){
		if(event.player.worldObj.isRemote){
			if(event.player.inventory.getCurrentItem().getItem() instanceof ItemKeyblade){
				event.setCanceled(true);
			}
		}
		
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event){
		
	}
	
	@SubscribeEvent
	public void bg(ClientTickEvent event){
		 //int i = (int)Math.random();
	      //if(i <= 10){
	  		//SoundHelper.playSoundAtEntity(Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer, SoundHelper.LazyAfternoons, 1, 1);
	      //}
	}
	
}
