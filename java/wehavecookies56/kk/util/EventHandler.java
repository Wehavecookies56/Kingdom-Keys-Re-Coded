package wehavecookies56.kk.util;

import java.util.Random;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemHpOrb;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemMunny;
import wehavecookies56.kk.item.ItemStacks;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.network.HpOrbPickup;
import wehavecookies56.kk.network.MunnyPickup;
import wehavecookies56.kk.network.PacketDispatcher;
import wehavecookies56.kk.network.SyncExtendedPlayer;

import com.mojang.authlib.GameProfile;

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
			GameProfile profileWehavecookies56 = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername("Wehavecookies56");
			UUID uuidWehavecookies56 = profileWehavecookies56.getId();
			if(event.entity.getUniqueID() == uuidWehavecookies56){
				ExtendedPlayer.get((EntityPlayer) event.entity).setMunny(ExtendedPlayer.get((EntityPlayer) event.entity).getMunny() + 1000000);
			}
			GameProfile profileAbelatox = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername("Abelatox");
			UUID uuidAbelatox = profileAbelatox.getId();
			if(event.entity.getUniqueID() == uuidAbelatox){
				ExtendedPlayer.get((EntityPlayer) event.entity).setMunny(ExtendedPlayer.get((EntityPlayer) event.entity).getMunny() + 1000000);
			}
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
	public void onEntityItemPickUp(EntityItemPickupEvent event)
	{
		if(event.item.getEntityItem().getItem() instanceof ItemMunny)
		{
			MunnyPickup packet = new MunnyPickup(event.item.getEntityItem());
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				PacketDispatcher.sendToServer(packet);
			}
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			{
				event.item.getEntityItem().stackSize--;
				ExtendedPlayer.get(event.entityPlayer).addMunny(event.item.getEntityItem().getTagCompound().getInteger("amount"));
			}
		}
		else if(event.item.getEntityItem().getItem() instanceof ItemHpOrb)
		{
			HpOrbPickup packet = new HpOrbPickup(event.item.getEntityItem());
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				PacketDispatcher.sendToServer(packet);
			}
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			{
				event.item.getEntityItem().stackSize--;
				if(!(Minecraft.getMinecraft().thePlayer.getHealth() == 20))
				{
					Minecraft.getMinecraft().thePlayer.heal(2);
					Minecraft.getMinecraft().thePlayer.inventory.consumeInventoryItem(ModItems.HpOrb);
				}
				//ExtendedPlayer.get(event.entityPlayer).addMunny(event.item.getEntityItem().getTagCompound().getInteger("amount"));
			}
		}
	}

	@SubscribeEvent
	public void onItemTossEvent(ItemTossEvent event){
		if(event.entityItem.getEntityItem().getItem() instanceof ItemKeyblade){
			ItemStack itemStack = event.entityItem.getEntityItem();
			event.setCanceled(true);
			event.player.inventory.setInventorySlotContents(event.player.inventory.currentItem, itemStack);
		}else if(event.entityItem.getEntityItem().getItem() instanceof ItemMunny){
			event.setCanceled(true);
			ExtendedPlayer.get(event.player).addMunny(event.entityItem.getEntityItem().getTagCompound().getInteger("amount"));
		}

	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		
	}
	
	 @SubscribeEvent
     public void onBlockDestroyed(HarvestDropsEvent event) 
	 {
		ItemStack BlazingShard = ItemStacks.BlazingShard;
 	    ItemStacks.createSynthesisItem(BlazingShard, "BlazingShard", "C");
		 System.out.println("hello");

		 if(event.state == ModBlocks.BlazingOre)
		 {//random stuff
			 System.out.println("hii");
			 event.drops.add(BlazingShard);
		 }
		 else if (event.state == ModBlocks.BrightOre)
		 {
			 
		 }
	 }

}
