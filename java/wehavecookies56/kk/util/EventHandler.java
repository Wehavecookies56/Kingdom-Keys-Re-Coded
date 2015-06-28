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
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.HpOrbPickup;
import wehavecookies56.kk.network.MunnyPickup;
import wehavecookies56.kk.network.PacketDispatcher;
import wehavecookies56.kk.network.SyncExtendedPlayer;
import wehavecookies56.kk.recipes.RecipeRegistry;

import com.mojang.authlib.GameProfile;

public class EventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
			ExtendedPlayer.register((EntityPlayer) event.entity);
			RecipeRegistry.learnrecipe((EntityPlayer) event.entity, Strings.KingdomKey);
		}

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
				event.entityPlayer.heal(2);
				PacketDispatcher.sendToServer(packet);
			}
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			{
				if(!(event.entityPlayer.getHealth() == 20))
				{
					event.entityPlayer.heal(2);
					event.entityPlayer.inventory.consumeInventoryItem(ModItems.HpOrb);
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
			int drop = randomWithRange(1, 29);
			if(drop == 1)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 50);
				event.drops.add(munny);
			}
			else if(drop == 2)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 100);
				event.drops.add(munny);
			}
			else if(drop == 3)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 500);
				event.drops.add(munny);
			}
			else if(drop == 4)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 700);
				event.drops.add(munny);
			}
			else if(drop == 5)
			{
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, "Blazing Shard", "C");
				event.drops.add(BlazingGem);
			}
			else if(drop == 6)
			{
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, "Bright Shard", "C");
				event.drops.add(BrightGem);
			}
			else if(drop == 7)
			{
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, "Dark Shard", "C");
				event.drops.add(DarkGem);
			}
			else if(drop == 8)
			{
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, "Dense Shard", "C");
				event.drops.add(DenseGem);
			}
			else if(drop == 9)
			{
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, "Energy Shard", "C");
				event.drops.add(EnergyGem);
			}
			else if(drop == 10)
			{
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, "Frost Shard", "C");
				event.drops.add(FrostGem);
			}
			else if(drop == 11)
			{
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, "Lucid Shard", "C");
				event.drops.add(LucidGem);
			}
			else if(drop == 12)
			{
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, "Power Shard", "C");
				event.drops.add(PowerGem);
			}
			else if(drop == 13)
			{
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, "Remembrance Shard", "C");
				event.drops.add(RemembranceGem);
			}
			else if(drop == 14)
			{
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, "Serenity Shard", "C");
				event.drops.add(SerenityGem);
			}
			else if(drop == 15)
			{
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, "Tranquil Shard", "C");
				event.drops.add(TranquilGem);
			}
			else if(drop == 16)
			{
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, "Twilight Shard", "C");
				event.drops.add(TwilightGem);
			}
			else if(drop == 17)
			{
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, "Blazing Stone","B");
				event.drops.add(BlazingCrystal);
			}
			else if(drop == 18)
			{
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, "Bright Stone","B");
				event.drops.add(BrightCrystal);
			}
			else if(drop == 19)
			{
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, "Dark Stone","B");
				event.drops.add(DarkCrystal);
			}
			else if(drop == 20)
			{
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, "Dense Stone","B");
				event.drops.add(DenseCrystal);
			}
			else if(drop == 21)
			{
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, "Energy Stone","B");
				event.drops.add(EnergyCrystal);
			}
			else if(drop == 22)
			{
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, "Frost Stone","B");
				event.drops.add(FrostCrystal);
			}
			else if(drop == 23)
			{
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, "Lucid Stone","B");
				event.drops.add(LucidCrystal);
			}
			else if(drop == 24)
			{
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, "Power Stone","B");
				event.drops.add(PowerCrystal);
			}
			else if(drop == 25)
			{
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, "Remembrance Stone","B");
				event.drops.add(RemembranceCrystal);
			}
			else if(drop == 26)
			{
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, "Serenity Stone","B");
				event.drops.add(SerenityCrystal);
			}
			else if(drop == 27)
			{
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, "Tranquil Stone","B");
				event.drops.add(TranquilCrystal);
			}
			else if(drop == 28)
			{
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, "Twilight Stone","B");
				event.drops.add(TwilightCrystal);
			}
			else if(drop == 29)
			{
				ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(Orichalcum, "Orichalcum", "A");
				event.drops.add(Orichalcum);
			}
		}
		
		else if (event.state.getBlock() == ModBlocks.RarePrizeBlox)
		{
			int drop = randomWithRange(1, 28);
			if(drop == 1)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 1000);
				event.drops.add(munny);
			}
			else if(drop == 2)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 1500);
				event.drops.add(munny);
			}
			else if(drop == 3)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 2000);
				event.drops.add(munny);
			}
			else if(drop == 4)
			{
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 3000);
				event.drops.add(munny);
			}
			else if(drop == 5)
			{
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, "Blazing Gem", "A");
				event.drops.add(BlazingGem);
			}
			else if(drop == 6)
			{
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, "Bright Gem", "A");
				event.drops.add(BrightGem);
			}
			else if(drop == 7)
			{
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, "Dark Gem", "A");
				event.drops.add(DarkGem);
			}
			else if(drop == 8)
			{
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, "Dense Gem", "A");
				event.drops.add(DenseGem);
			}
			else if(drop == 9)
			{
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, "Energy Gem", "A");
				event.drops.add(EnergyGem);
			}
			else if(drop == 10)
			{
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, "Frost Gem", "A");
				event.drops.add(FrostGem);
			}
			else if(drop == 11)
			{
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, "Lucid Gem", "A");
				event.drops.add(LucidGem);
			}
			else if(drop == 12)
			{
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, "Power Gem", "A");
				event.drops.add(PowerGem);
			}
			else if(drop == 13)
			{
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, "Remembrance Gem", "A");
				event.drops.add(RemembranceGem);
			}
			else if(drop == 14)
			{
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, "Serenity Gem", "A");
				event.drops.add(SerenityGem);
			}
			else if(drop == 15)
			{
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, "Tranquil Gem", "A");
				event.drops.add(TranquilGem);
			}
			else if(drop == 16)
			{
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, "Twilight Gem", "A");
				event.drops.add(TwilightGem);
			}
			else if(drop == 17)
			{
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, "Blazing Crystal", "S");
				event.drops.add(BlazingCrystal);
			}
			else if(drop == 18)
			{
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, "Bright Crystal", "S");
				event.drops.add(BrightCrystal);
			}
			else if(drop == 19)
			{
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, "Dark Crystal", "S");
				event.drops.add(DarkCrystal);
			}
			else if(drop == 20)
			{
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, "Dense Crystal", "S");
				event.drops.add(DenseCrystal);
			}
			else if(drop == 21)
			{
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, "Energy Crystal", "S");
				event.drops.add(EnergyCrystal);
			}
			else if(drop == 22)
			{
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, "Frost Crystal", "S");
				event.drops.add(FrostCrystal);
			}
			else if(drop == 23)
			{
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, "Lucid Crystal", "S");
				event.drops.add(LucidCrystal);
			}
			else if(drop == 24)
			{
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, "Power Crystal", "S");
				event.drops.add(PowerCrystal);
			}
			else if(drop == 25)
			{
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, "Remembrance Crystal", "S");
				event.drops.add(RemembranceCrystal);
			}
			else if(drop == 26)
			{
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, "Serenity Crystal", "S");
				event.drops.add(SerenityCrystal);
			}
			else if(drop == 27)
			{
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, "Tranquil Crystal", "S");
				event.drops.add(TranquilCrystal);
			}
			else if(drop == 28)
			{
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, "Twilight Crystal", "S");
				event.drops.add(TwilightCrystal);
			}
			else if(drop == 29)
			{
				ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(Orichalcum, "Orichalcum", "A");
				event.drops.add(Orichalcum);
			}
			else if(drop == 30)
			{
				ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(OrichalcumPlus, "Orichalcum+", "S");
				event.drops.add(OrichalcumPlus);
			}
		}
	}

}
