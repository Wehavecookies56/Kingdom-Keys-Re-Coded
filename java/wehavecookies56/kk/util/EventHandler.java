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

		} 
		else
		{
			
		}
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
				//event.item.getEntityItem().stackSize--;
				if(!(Minecraft.getMinecraft().thePlayer.getHealth() == 20))
				{
					Minecraft.getMinecraft().thePlayer.heal(2);
					Minecraft.getMinecraft().thePlayer.inventory.consumeInventoryItem(ModItems.HpOrb);
				}
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
	
	int randomWithRange(int min, int max)
	{
	   int range = Math.abs(max - min) + 1;     
	   return (int)(Math.random() * range) + (min <= max ? min : max);
	}

	@SubscribeEvent
	public void onBlockDestroyed(HarvestDropsEvent event) 
	{
		if(event.state.getBlock() == ModBlocks.BlazingOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingShard, "Blazing Shard", "C");
				event.drops.add(BlazingShard);
			}else if (drop == 2){
				ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingStone, "Blazing Stone", "B");
				event.drops.add(BlazingStone);
			}else if (drop == 3){
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, "Blazing Gem", "A");
				event.drops.add(BlazingGem);
			}else if (drop == 4){
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, "Blazing Crystal", "S");
				event.drops.add(BlazingCrystal);
			}	
		}
		else if (event.state.getBlock() == ModBlocks.BrightOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightShard, "Bright Shard", "C");
				event.drops.add(BrightShard);
			}else if (drop == 2){
				ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightStone, "Bright Stone", "B");
				event.drops.add(BrightStone);
			}else if (drop == 3){
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, "Bright Gem", "A");
				event.drops.add(BrightGem);
			}else if (drop == 4){
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, "Bright Crystal", "S");
				event.drops.add(BrightCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DarkOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkShard, "Dark Shard", "C");
				event.drops.add(DarkShard);
			}else if (drop == 2){
				ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkStone, "Dark Stone", "B");
				event.drops.add(DarkStone);
			}else if (drop == 3){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, "Dark Gem", "A");
				event.drops.add(DarkGem);
			}else if (drop == 4){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, "Dark Crystal", "S");
				event.drops.add(DarkCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DarkOreE)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkShard, "Dark Shard", "C");
				event.drops.add(DarkShard);
			}else if (drop == 2){
				ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkStone, "Dark Stone", "B");
				event.drops.add(DarkStone);
			}else if (drop == 3){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, "Dark Gem", "A");
				event.drops.add(DarkGem);
			}else if (drop == 4){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, "Dark Crystal", "S");
				event.drops.add(DarkCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DenseOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseShard, "Dense Shard", "C");
				event.drops.add(DenseShard);
			}else if (drop == 2){
				ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseStone, "Dense Stone", "B");
				event.drops.add(DenseStone);
			}else if (drop == 3){
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, "Dense Gem", "A");
				event.drops.add(DenseGem);
			}else if (drop == 4){
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, "Dense Crystal", "S");
				event.drops.add(DenseCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.EnergyOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyShard, "Energy Shard", "C");
				event.drops.add(EnergyShard);
			}else if (drop == 2){
				ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyStone, "Energy Stone", "B");
				event.drops.add(EnergyStone);
			}else if (drop == 3){
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, "Energy Gem", "A");
				event.drops.add(EnergyGem);
			}else if (drop == 4){
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, "Energy Crystal", "S");
				event.drops.add(EnergyCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.FrostOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostShard, "Frost Shard", "C");
				event.drops.add(FrostShard);
			}else if (drop == 2){
				ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostStone, "Frost Stone", "B");
				event.drops.add(FrostStone);
			}else if (drop == 3){
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, "Frost Gem", "A");
				event.drops.add(FrostGem);
			}else if (drop == 4){
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, "Frost Crystal", "S");
				event.drops.add(FrostCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.LucidOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidShard, "Lucid Shard", "C");
				event.drops.add(LucidShard);
			}else if (drop == 2){
				ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidStone, "Lucid Stone", "B");
				event.drops.add(LucidStone);
			}else if (drop == 3){
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, "Lucid Gem", "A");
				event.drops.add(LucidGem);
			}else if (drop == 4){
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, "Lucid Crystal", "S");
				event.drops.add(LucidCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PowerOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerShard, "Power Shard", "C");
				event.drops.add(PowerShard);
			}else if (drop == 2){
				ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerStone, "Power Stone", "B");
				event.drops.add(PowerStone);
			}else if (drop == 3){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, "Power Gem", "A");
				event.drops.add(PowerGem);
			}else if (drop == 4){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, "Power Crystal", "S");
				event.drops.add(PowerCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PowerOreE)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerShard, "Power Shard", "C");
				event.drops.add(PowerShard);
			}else if (drop == 2){
				ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerStone, "Power Stone", "B");
				event.drops.add(PowerStone);
			}else if (drop == 3){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, "Power Gem", "A");
				event.drops.add(PowerGem);
			}else if (drop == 4){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, "Power Crystal", "S");
				event.drops.add(PowerCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.RemembranceOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceShard, "Remembrance Shard", "C");
				event.drops.add(RemembranceShard);
			}else if (drop == 2){
				ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceStone, "Remembrance Stone", "B");
				event.drops.add(RemembranceStone);
			}else if (drop == 3){
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, "Remembrance Gem", "A");
				event.drops.add(RemembranceGem);
			}else if (drop == 4){
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, "Remembrance Crystal", "S");
				event.drops.add(RemembranceCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.SerenityOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityShard, "Serenity Shard", "C");
				event.drops.add(SerenityShard);
			}else if (drop == 2){
				ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityStone, "Serenity Stone", "B");
				event.drops.add(SerenityStone);
			}else if (drop == 3){
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, "Serenity Gem", "A");
				event.drops.add(SerenityGem);
			}else if (drop == 4){
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, "Serenity Crystal", "S");
				event.drops.add(SerenityCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.TranquilOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilShard, "Tranquil Shard", "C");
				event.drops.add(TranquilShard);
			}else if (drop == 2){
				ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilStone, "Tranquil Stone", "B");
				event.drops.add(TranquilStone);
			}else if (drop == 3){
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, "Tranquil Gem", "A");
				event.drops.add(TranquilGem);
			}else if (drop == 4){
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, "Tranquil Crystal", "S");
				event.drops.add(TranquilCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.TwilightOre)
		{
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightShard, "Twilight Shard", "C");
				event.drops.add(TwilightShard);
			}else if (drop == 2){
				ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightStone, "Twilight Stone", "B");
				event.drops.add(TwilightStone);
			}else if (drop == 3){
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, "Twilight Gem", "A");
				event.drops.add(TwilightGem);
			}else if (drop == 4){
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, "Twilight Crystal", "S");
				event.drops.add(TwilightCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PrizeBlox)
		{
			int drop = randomWithRange(1, 10);
			if(drop == 1){
				ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkShard, "Dark Shard", "C");
				event.drops.add(DarkShard);
			}else if (drop == 2){
				ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostShard, "Frost Shard", "C");
				event.drops.add(FrostShard);
			}else if (drop == 3){
				ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LightningShard, "Lightning Shard", "C");
				event.drops.add(LightningShard);
			}else if (drop == 4){
				ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidShard, "Lucid Shard", "C");
				event.drops.add(LucidShard);
			}else if (drop == 5){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 5);
				event.drops.add(munny);
			}else if (drop == 6){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 10);
				event.drops.add(munny);
			}else if (drop == 7){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 20);
				event.drops.add(munny);
			}else if (drop == 8){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 50);
				event.drops.add(munny);

			}else if (drop == 9){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 100);
				event.drops.add(munny);

			}else if (drop == 10){
				ItemStack HP = new ItemStack(ModItems.HpOrb, 1);
				event.drops.add(HP);

			}
		}
	}

}
