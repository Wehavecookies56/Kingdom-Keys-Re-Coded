package wehavecookies56.kk.util;

import java.util.List;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderItemInFrameEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.inventory.InventorySynthesisBagL;
import wehavecookies56.kk.inventory.InventorySynthesisBagM;
import wehavecookies56.kk.inventory.InventorySynthesisBagS;
import wehavecookies56.kk.item.ItemHpOrb;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemMunny;
import wehavecookies56.kk.item.ItemSynthesisMaterial;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerMaterials;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerRecipes;
import wehavecookies56.kk.network.packet.server.DeSummonKeyblade;
import wehavecookies56.kk.network.packet.server.DriveOrbPickup;
import wehavecookies56.kk.network.packet.server.HpOrbPickup;
import wehavecookies56.kk.network.packet.server.MagicOrbPickup;
import wehavecookies56.kk.network.packet.server.MunnyPickup;

public class EventHandler {
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
		if(event.entity instanceof EntityPlayer && ExtendedPlayerRecipes.get((EntityPlayer) event.entity) == null){
			ExtendedPlayerRecipes.register((EntityPlayer) event.entity);
		}
		if(event.entity instanceof EntityPlayer && ExtendedPlayerMaterials.get((EntityPlayer) event.entity) == null){
			ExtendedPlayerMaterials.register((EntityPlayer) event.entity);
		}

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderItemInFrame(RenderItemInFrameEvent event){
		if(event.item.getItem() != null){
			if(event.item.getItem() instanceof ItemKeyblade){
				GlStateManager.scale(0.02f, 0.02f, 0.02f);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void fovUpdate(FOVUpdateEvent event){
		if(event.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue() == 0){
			event.newfov = 1f;
		}
	}

	@SubscribeEvent
	public void addTooltip(ItemTooltipEvent event){
		Item ghostBlox = Item.getItemFromBlock(ModBlocks.GhostBlox);
		if(event.itemStack.getItem() == ghostBlox){
			if(!KeyboardHelper.isShiftDown()){
				event.toolTip.add(TextHelper.ITALIC + TextHelper.localize(Strings.HoldForInfo));
			}else{
				int x = 30;
				String s = TextHelper.localize(Strings.GhostBloxDesc).replace("%s", TextHelper.localize(ModBlocks.GhostBlox.getUnlocalizedName() + ".name"));
				s = s.replaceAll("(.{" + x + ",}?)\\s+", "$1\n");
				String []splitS = s.split("\n");
				for(int i = 0; i < splitS.length; i++){
					event.toolTip.add(splitS[i]);
				}
			}
		}
		Item dangerBlox = Item.getItemFromBlock(ModBlocks.DangerBlox);
		if(event.itemStack.getItem() == dangerBlox){
			if(!KeyboardHelper.isShiftDown()){
				event.toolTip.add(TextHelper.ITALIC + TextHelper.localize(Strings.HoldForInfo));
			}else{
				int x = 30;
				String s = TextHelper.localize(Strings.DangerBloxDesc).replace("%s", TextHelper.localize(ModBlocks.DangerBlox.getUnlocalizedName() + ".name"));
				s = s.replaceAll("(.{" + x + ",}?)\\s+", "$1\n");
				String []splitS = s.split("\n");
				for(int i = 0; i < splitS.length; i++){
					event.toolTip.add(splitS[i]);
				}
			}
		}
		Item bounceBlox = Item.getItemFromBlock(ModBlocks.BounceBlox);
		if(event.itemStack.getItem() == bounceBlox){
			if(!KeyboardHelper.isShiftDown()){
				event.toolTip.add(TextHelper.ITALIC + TextHelper.localize(Strings.HoldForInfo));
			}else{
				int x = 30;
				String s = TextHelper.localize(Strings.BounceBloxDesc).replace("%s", TextHelper.localize(ModBlocks.BounceBlox.getUnlocalizedName() + ".name"));
				s = s.replaceAll("(.{" + x + ",}?)\\s+", "$1\n");
				String []splitS = s.split("\n");
				for(int i = 0; i < splitS.length; i++){
					event.toolTip.add(splitS[i]);
				}
			}
		}
		Item kkchest = Item.getItemFromBlock(ModBlocks.KKChest);
		if(event.itemStack.getItem() == kkchest){
			event.toolTip.add(TextHelper.localize(Strings.KKChestDesc_1));
			if(!KeyboardHelper.isShiftDown()){
				event.toolTip.add(TextHelper.ITALIC + TextHelper.localize(Strings.HoldForInfo));
			}else{
				event.toolTip.add(TextHelper.localize(Strings.KKChestDesc_2));
			}
		}

		Item savepoint = Item.getItemFromBlock(ModBlocks.SavePoint);
		if(event.itemStack.getItem() == savepoint){
			if(!KeyboardHelper.isShiftDown()){
				event.toolTip.add(TextHelper.ITALIC + TextHelper.localize(Strings.HoldForInfo));
			}else{
				event.toolTip.add(TextHelper.localize(Strings.SavePointDesc));
			}
		}

	}
	
	@SubscribeEvent
	public void OnEntityJoinWorld(EntityJoinWorldEvent event){
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			ExtendedPlayer.get((EntityPlayer) event.entity).loadProxyData(((EntityPlayer) event.entity));
			PacketDispatcher.sendTo(new SyncExtendedPlayer((EntityPlayer) event.entity), ((EntityPlayerMP) event.entity));
			ExtendedPlayerRecipes.get((EntityPlayer) event.entity).loadProxyData(((EntityPlayer) event.entity));
			PacketDispatcher.sendTo(new SyncExtendedPlayerRecipes((EntityPlayer) event.entity), ((EntityPlayerMP) event.entity));
			ExtendedPlayerMaterials.get((EntityPlayer) event.entity).loadProxyData(((EntityPlayer) event.entity));
			PacketDispatcher.sendTo(new SyncExtendedPlayerMaterials((EntityPlayer) event.entity), ((EntityPlayerMP) event.entity));

			if(!ExtendedPlayer.get((EntityPlayer) event.entity).hasFirstKeyblade()){
				((EntityPlayer) event.entity).inventory.addItemStackToInventory(new ItemStack(ModItems.WoodenKeyblade));
				ExtendedPlayer.get((EntityPlayer) event.entity).setFirstKeyblade(true);
			}

			try{
				GameProfile profileWehavecookies56 = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername("Qwenit");
				UUID uuidWehavecookies56 = profileWehavecookies56.getId();
				if(event.entity.getUniqueID() == uuidWehavecookies56){
					ExtendedPlayer.get((EntityPlayer) event.entity).setMunny(ExtendedPlayer.get((EntityPlayer) event.entity).getMunny() + 10000);
				}
				GameProfile profileAbelatox = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername("Abelatox");
				UUID uuidAbelatox = profileAbelatox.getId();
				if(event.entity.getUniqueID() == uuidAbelatox){
					ExtendedPlayer.get((EntityPlayer) event.entity).setMunny(ExtendedPlayer.get((EntityPlayer) event.entity).getMunny() + 10000);
				}
			}catch(Exception e){

			}

		}

	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(ExtendedPlayer.get(player).isKeybladeSummoned())
			{
				PacketDispatcher.sendToServer(new DeSummonKeyblade(player.inventory.getCurrentItem()));
				ExtendedPlayer.get(player).setKeybladeSummoned(false);
				PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
			}
			ExtendedPlayer.get((EntityPlayer) event.entity).saveProxyData((EntityPlayer) event.entity);
			ExtendedPlayerRecipes.get((EntityPlayer) event.entity).saveProxyData((EntityPlayer) event.entity);
			ExtendedPlayerMaterials.get((EntityPlayer) event.entity).saveProxyData((EntityPlayer) event.entity);
		}

		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityMob){
			if(event.source.getSourceOfDamage() instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();

				EntityMob mob = (EntityMob) event.entity;
				ExtendedPlayer.get(player).addXP((int) (mob.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() / 2));
			}
		}
	}

	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event)
	{
		if(event.entity instanceof EntityPlayer){
			for(int i = 0; i < event.drops.size(); i++){
				if(event.drops.get(i).getEntityItem().getItem() instanceof ItemKeyblade && (event.drops.get(i).getEntityItem().getItem() != ModItems.WoodenKeyblade && event.drops.get(i).getEntityItem().getItem() != ModItems.WoodenStick)){
					event.drops.remove(i);
					ExtendedPlayer.get((EntityPlayer) event.entity).setKeybladeSummoned(false);
					i = 0;
				}
			}
		}
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
						if(event.entity instanceof EntityWitch)
						{
							int rand;
							rand = randomWithRange(1, 30);
							if(rand == 1)
							{
								event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicFire), 1);
							}
							else if(rand == 5)
							{
								event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicBlizzard), 1);
							}
							else if(rand == 9)
							{
								event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicThunder), 1);
							}

							else if(rand == 13)
							{
								event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicCure), 1);
							}

							else if(rand == 17)
							{
								//	event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicGravity), 1);
							}

							else if(rand == 21)
							{
								event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicAero), 1);
							}
							else if(rand == 25)
							{
								//event.entityLiving.entityDropItem(new ItemStack(ModItems.LevelUpMagicStop), 1);
							}
						}
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
			ItemStack driveOrb = new ItemStack(ModItems.DriveOrb, 1);
			driveOrb.setTagCompound(new NBTTagCompound());
			ItemStack magicOrb = new ItemStack(ModItems.MagicOrb, 1);
			magicOrb.setTagCompound(new NBTTagCompound());
			ItemStack HPOrb = new ItemStack(ModItems.HpOrb, 1);

			if(event.entity instanceof EntityAnimal){
				munny.getTagCompound().setInteger("amount", randomWithRange(1, 20));
				event.entityLiving.entityDropItem(munny, 1);
				driveOrb.getTagCompound().setInteger("amount", 1);
				event.entityLiving.entityDropItem(driveOrb, 1);
				magicOrb.getTagCompound().setInteger("amount", randomWithRange(2, 8));
				event.entityLiving.entityDropItem(magicOrb, 1);
				event.entityLiving.entityDropItem(HPOrb, 1);
			}else if(event.entity instanceof EntityMob){
				munny.getTagCompound().setInteger("amount", randomWithRange(5, 50));
				event.entityLiving.entityDropItem(munny, 1);
				driveOrb.getTagCompound().setInteger("amount", 5);
				event.entityLiving.entityDropItem(driveOrb, 1);
				magicOrb.getTagCompound().setInteger("amount", randomWithRange(5, 15));
				event.entityLiving.entityDropItem(magicOrb, 1);
				event.entityLiving.entityDropItem(HPOrb, 1);

			}else if(event.entity instanceof EntityAgeable){
				munny.getTagCompound().setInteger("amount", randomWithRange(50, 100));
				event.entityLiving.entityDropItem(munny, 1);
				driveOrb.getTagCompound().setInteger("amount", 5);
				event.entityLiving.entityDropItem(driveOrb, 1);
				magicOrb.getTagCompound().setInteger("amount", randomWithRange(10, 25));
				event.entityLiving.entityDropItem(magicOrb, 1);
			}else if(event.entity instanceof EntityDragon||event.entity instanceof EntityWither){
				munny.getTagCompound().setInteger("amount", randomWithRange(500, 1000));
				event.entityLiving.entityDropItem(munny, 1);
				driveOrb.getTagCompound().setInteger("amount", randomWithRange(200, 250));
				event.entityLiving.entityDropItem(driveOrb, 1);
				magicOrb.getTagCompound().setInteger("amount", randomWithRange(100, 140));
				event.entityLiving.entityDropItem(magicOrb, 1);
			}
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
			if(event.entityPlayer.getHeldItem() != null)
			{
				if(event.entityPlayer.getHeldItem().getItem() == ModItems.EmptyBottle)
					return;
			}

			HpOrbPickup packet = new HpOrbPickup(event.item.getEntityItem());
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				if(event.entityPlayer.getHealth() >= ExtendedPlayer.get(event.entityPlayer).getHP())
				{
					return;
				}
				if(event.entityPlayer.getHealth() < ExtendedPlayer.get(event.entityPlayer).getHP()-1)
				{
					event.entityPlayer.heal(2);
				}
				else
				{
					event.entityPlayer.heal(1);
				}
				PacketDispatcher.sendToServer(packet);
			}
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			{
				if(event.entityPlayer.getHealth() >= ExtendedPlayer.get(event.entityPlayer).getHP())
				{
					event.item.getEntityItem().stackSize--;
					return;
				}
				if(event.entityPlayer.getHealth() < ExtendedPlayer.get(event.entityPlayer).getHP()-1)
				{
					event.entityPlayer.heal(2);
				}
				else
				{
					event.entityPlayer.heal(1);
				}
				event.item.getEntityItem().stackSize--;
			}			
		}
		else if(event.item.getEntityItem().getItem() == ModItems.DriveOrb){
			ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
			double dp = props.getDP();
			//if(dp < 1000) //Not pickup orb when full
			{
				DriveOrbPickup packet = new DriveOrbPickup(event.item.getEntityItem());
				if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
				{
					PacketDispatcher.sendToServer(packet);
				}
				if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
				{
					event.item.getEntityItem().stackSize--;
					ExtendedPlayer.get(event.entityPlayer).addDP(event.item.getEntityItem().getTagCompound().getInteger("amount"));
				}
			}
		}
		else if(event.item.getEntityItem().getItem() == ModItems.MagicOrb){

			ExtendedPlayer props = ExtendedPlayer.get(event.entityPlayer);
			double mp = props.getMp();
			if(event.entityPlayer.getHeldItem() != null)
			{
				if(event.entityPlayer.getHeldItem().getItem() == ModItems.EmptyBottle)
					return;
			}
			MagicOrbPickup packet = new MagicOrbPickup(event.item.getEntityItem());
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			{
				PacketDispatcher.sendToServer(packet);
			}
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			{
				event.item.getEntityItem().stackSize--;
				ExtendedPlayer.get(event.entityPlayer).addMp(event.item.getEntityItem().getTagCompound().getInteger("amount"));
			}
		}
		else if(event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.NormalBlox) || event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.HardBlox) || event.item.getEntityItem().getItem() == Item.getItemFromBlock(ModBlocks.MetalBlox))
		{
			AchievementHelper.addAchievement(event.entityPlayer, ModAchievements.getBlox);
		}

		else if(event.item.getEntityItem().getItem() instanceof ItemSynthesisMaterial){
			if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0) != null){
				if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0).getItem() == ModItems.SynthesisBagL){
					InventorySynthesisBagL inv = new InventorySynthesisBagL(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0));
					for(int j = 0; j < inv.getSizeInventory(); j++){
						ItemStack bagItem = inv.getStackInSlot(j);
						ItemStack pickUp = event.item.getEntityItem();
						if(bagItem != null){
							if(bagItem.getItem().equals(pickUp.getItem())){
								if(bagItem.hasTagCompound() && pickUp.hasTagCompound()){
									if(bagItem.getTagCompound().hasKey("material") && pickUp.getTagCompound().hasKey("material")){
										if(bagItem.getTagCompound().getString("material").equals(pickUp.getTagCompound().getString("material"))){
											if(bagItem.stackSize < 64){
												if(bagItem.stackSize + 1 <= 64){
													event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
													ItemStack stack = new ItemStack(pickUp.getItem(), 1 + bagItem.stackSize);
													stack.setTagCompound(new NBTTagCompound());
													stack.getTagCompound().setString("material", bagItem.getTagCompound().getString("material"));
													stack.getTagCompound().setString("rank", bagItem.getTagCompound().getString("rank"));
													inv.setInventorySlotContents(j, stack);
													return;
												}
											}
										}
									}
								}
							}
						}
						else if (bagItem == null){
							event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
							inv.setInventorySlotContents(j, pickUp);
							return;
						}
					}		
				}
			}
			if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0) != null){
				if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0).getItem() == ModItems.SynthesisBagM){
					InventorySynthesisBagM inv = new InventorySynthesisBagM(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0));
					for(int j = 0; j < inv.getSizeInventory(); j++){
						ItemStack bagItem = inv.getStackInSlot(j);
						ItemStack pickUp = event.item.getEntityItem();
						if(bagItem != null){
							if(bagItem.getItem().equals(pickUp.getItem())){
								if(bagItem.hasTagCompound() && pickUp.hasTagCompound()){
									if(bagItem.getTagCompound().hasKey("material") && pickUp.getTagCompound().hasKey("material")){
										if(bagItem.getTagCompound().getString("material").equals(pickUp.getTagCompound().getString("material"))){
											if(bagItem.stackSize < 64){
												if(bagItem.stackSize + 1 <= 64){
													event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
													ItemStack stack = new ItemStack(pickUp.getItem(), 1 + bagItem.stackSize);
													stack.setTagCompound(new NBTTagCompound());
													stack.getTagCompound().setString("material", bagItem.getTagCompound().getString("material"));
													stack.getTagCompound().setString("rank", bagItem.getTagCompound().getString("rank"));
													inv.setInventorySlotContents(j, stack);
													return;
												}
											}
										}
									}
								}
							}
						}
						else if (bagItem == null){
							event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
							inv.setInventorySlotContents(j, pickUp);
							return;
						}
					}		
				}

			}
			if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0) != null){
				if(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0).getItem() == ModItems.SynthesisBagS){
					InventorySynthesisBagS inv = new InventorySynthesisBagS(ExtendedPlayer.get(event.entityPlayer).inventorySynthBag.getStackInSlot(0));
					for(int j = 0; j < inv.getSizeInventory(); j++){
						ItemStack bagItem = inv.getStackInSlot(j);
						ItemStack pickUp = event.item.getEntityItem();
						if(bagItem != null){
							if(bagItem.getItem().equals(pickUp.getItem())){
								if(bagItem.hasTagCompound() && pickUp.hasTagCompound()){
									if(bagItem.getTagCompound().hasKey("material") && pickUp.getTagCompound().hasKey("material")){
										if(bagItem.getTagCompound().getString("material").equals(pickUp.getTagCompound().getString("material"))){
											if(bagItem.stackSize < 64){
												if(bagItem.stackSize + 1 <= 64){
													event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
													ItemStack stack = new ItemStack(pickUp.getItem(), 1 + bagItem.stackSize);
													stack.setTagCompound(new NBTTagCompound());
													stack.getTagCompound().setString("material", bagItem.getTagCompound().getString("material"));
													stack.getTagCompound().setString("rank", bagItem.getTagCompound().getString("rank"));
													inv.setInventorySlotContents(j, stack);
													return;
												}
											}
										}
									}
								}
							}
						}
						else if (bagItem == null){
							event.entityPlayer.inventory.consumeInventoryItem(pickUp.getItem());
							inv.setInventorySlotContents(j, pickUp);
							return;
						}
					}		
				}
			}
		}
	}

	@SubscribeEvent
	public void onItemTossEvent(ItemTossEvent event){
		if(event.entityItem.getEntityItem().getItem() instanceof ItemKeyblade && (event.entityItem.getEntityItem().getItem() != ModItems.WoodenKeyblade && event.entityItem.getEntityItem().getItem() != ModItems.WoodenStick))
		{
			event.entityItem.isDead = true;
			ItemStack itemStack = event.entityItem.getEntityItem();
			ExtendedPlayer.get(event.player).setKeybladeSummoned(false);
		}else if(event.entityItem.getEntityItem().getItem() instanceof ItemMunny){
			event.setCanceled(true);
			ExtendedPlayer.get(event.player).addMunny(event.entityItem.getEntityItem().getTagCompound().getInteger("amount"));
		}
	}

	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event){
		ItemStack WHC56skull = new ItemStack(Items.skull, 1, 3);
		WHC56skull.setTagCompound(new NBTTagCompound());
		WHC56skull.getTagCompound().setTag("SkullOwner", new NBTTagString("Wehavecookies56"));

		ItemStack AAskull = new ItemStack(Items.skull, 1, 3);
		AAskull.setTagCompound(new NBTTagCompound());
		AAskull.getTagCompound().setTag("SkullOwner", new NBTTagString("Abelatox"));

		if(event.crafting.getItem() == Item.getItemFromBlock(ModBlocks.SynthesisTable)){
			AchievementHelper.addAchievement(event.player, ModAchievements.getSynthesisTable);
		}

		if(event.crafting.getItem() == WHC56skull.getItem()){
			AchievementHelper.addAchievement(event.player, ModAchievements.getWehavecookies56Skull);
		}

		if(event.crafting.getItem() == AAskull.getItem()){
			AchievementHelper.addAchievement(event.player, ModAchievements.getAbelatoxSkull);
		}
	}

	public static boolean isHostiles = false;

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		if(!ExtendedPlayer.get((EntityPlayer) event.player).getInDrive()) //If player is not in drive
		{
			if(ExtendedPlayer.get((EntityPlayer) event.player).getMp() <= 0 || ExtendedPlayer.get((EntityPlayer) event.player).getRecharge())
			{
				ExtendedPlayer.get((EntityPlayer) event.player).setRecharge(true);
				if (ExtendedPlayer.get((EntityPlayer) event.player).mp != ExtendedPlayer.get((EntityPlayer) event.player).getMaxMp())
				{
					ExtendedPlayer.get((EntityPlayer) event.player).mp += 0.1;
					if(ExtendedPlayer.get((EntityPlayer) event.player).mp > ExtendedPlayer.get((EntityPlayer) event.player).getMaxMp()){
						ExtendedPlayer.get((EntityPlayer) event.player).mp = ExtendedPlayer.get((EntityPlayer) event.player).getMaxMp();
					}

				}
				else
				{
					ExtendedPlayer.get((EntityPlayer) event.player).setMp(ExtendedPlayer.get((EntityPlayer) event.player).getMaxMp());
					ExtendedPlayer.get((EntityPlayer) event.player).setRecharge(false);
				}
			}
		}
		if(!ExtendedPlayer.get((EntityPlayer) event.player).getDriveInUse().equals("none") && DriveFormRegistry.isDriveFormRegistered(ExtendedPlayer.get((EntityPlayer) event.player).getDriveInUse())){
			DriveFormRegistry.get(ExtendedPlayer.get((EntityPlayer) event.player).getDriveInUse()).update((EntityPlayer) event.player);
		}
		if(event.player != null){
			List<Entity> entities = event.player.worldObj.getEntitiesWithinAABBExcludingEntity(event.player, event.player.getEntityBoundingBox().expand(16.0D, 10.0D, 16.0D));
			if(!entities.isEmpty()){
				for(int i = 0; i < entities.size(); i++){
					if(entities.get(i) instanceof EntityMob){
						isHostiles = true;
						break;
					}else {
						isHostiles = false;
					}
				}
			}else {
				isHostiles = false;
			}
		}

	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{

	}
	
	

	/**
	 * Method for generating random ints between the 2 parameters, The order of min and max do not matter.
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomWithRange(int min, int max){
		int range = Math.abs(max - min) + 1;
		return (int)(Math.random() * range) + (min <= max ? min : max);
	}

	@SubscribeEvent
	public void onHurt(LivingHurtEvent event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(event.ammount-ExtendedPlayer.get(player).getDefense() <= 0)
			{
				event.ammount = 1;
			}
			else
			{
				event.ammount = event.ammount-ExtendedPlayer.get(player).getDefense();
			}

			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.FrozenPride){
				if(player.isBlocking()){
					event.ammount = 0.5f;
				}
			}
			if(event.source.getDamageType()=="lightningBolt")
			{
				if(EntityThunder.summonLightning)
				{
					event.setCanceled(true);
				}
			}
		}
		if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			event.ammount = (float) (event.ammount+(ExtendedPlayer.get(player).getStrength()*0.25));
			if(player.getHeldItem() != null)
			{
				if(player.getHeldItem().getItem() instanceof ItemKeyblade)
				{
					if(ExtendedPlayer.get(player).getDriveInUse().equals("Valor"))
					{
						event.ammount = (float) (event.ammount*1.5);
					}
					ExtendedPlayer.get(player).addDP(1);
				}
				else
				{
					return;
				}
			}
		}
	}

	@SubscribeEvent
	public void onFall(LivingFallEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(ExtendedPlayer.get(player).getInDrive())
			{
				event.distance=0;
			}
		}
	}

	@SubscribeEvent
	public void onBlockDestroyed(HarvestDropsEvent event){
		int fortune;
		if(event.state.getBlock() == ModBlocks.BlazingOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingShard, Strings.SM_BlazingShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BlazingShard);
				}
				event.drops.add(BlazingShard);

			}else if (drop == 2){
				ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BlazingStone);
				}
				event.drops.add(BlazingStone);

			}else if (drop == 3){
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BlazingGem);
				}
				event.drops.add(BlazingGem);

			}else if (drop == 4){
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BlazingCrystal);
				}
				event.drops.add(BlazingCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.BrightOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightShard, Strings.SM_BrightShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BrightShard);
				}
				event.drops.add(BrightShard);
			}else if (drop == 2){
				ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightStone, Strings.SM_BrightStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BrightStone);
				}
				event.drops.add(BrightStone);
			}else if (drop == 3){
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BrightGem);
				}
				event.drops.add(BrightGem);
			}else if (drop == 4){
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(BrightCrystal);
				}
				event.drops.add(BrightCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DarkOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkShard);
				}
				event.drops.add(DarkShard);
			}else if (drop == 2){
				ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkStone);
				}
				event.drops.add(DarkStone);
			}else if (drop == 3){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkGem);
				}
				event.drops.add(DarkGem);
			}else if (drop == 4){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkCrystal);
				}
				event.drops.add(DarkCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DarkOreE){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkShard);
				}
				event.drops.add(DarkShard);
			}else if (drop == 2){
				ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkStone);
				}
				event.drops.add(DarkStone);
			}else if (drop == 3){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkGem);
				}
				event.drops.add(DarkGem);
			}else if (drop == 4){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DarkCrystal);
				}
				event.drops.add(DarkCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.DenseOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseShard, Strings.SM_DenseShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DenseShard);
				}
				event.drops.add(DenseShard);
			}else if (drop == 2){
				ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DenseStone);
				}
				event.drops.add(DenseStone);
			}else if (drop == 3){
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DenseGem);
				}
				event.drops.add(DenseGem);
			}else if (drop == 4){
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(DenseCrystal);
				}
				event.drops.add(DenseCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.EnergyOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyShard, Strings.SM_EnergyShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(EnergyShard);
				}
				event.drops.add(EnergyShard);
			}else if (drop == 2){
				ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(EnergyStone);
				}
				event.drops.add(EnergyStone);
			}else if (drop == 3){
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(EnergyGem);
				}
				event.drops.add(EnergyGem);
			}else if (drop == 4){
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(EnergyCrystal);
				}
				event.drops.add(EnergyCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.FrostOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostShard, Strings.SM_FrostShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(FrostShard);
				}
				event.drops.add(FrostShard);
			}else if (drop == 2){
				ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostStone, Strings.SM_FrostStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(FrostStone);
				}
				event.drops.add(FrostStone);
			}else if (drop == 3){
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(FrostGem);
				}
				event.drops.add(FrostGem);
			}else if (drop == 4){
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(FrostCrystal);
				}
				event.drops.add(FrostCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.LightningOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LightningShard, Strings.SM_LightningShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LightningShard);
				}
				event.drops.add(LightningShard);
			}else if (drop == 2){
				ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LightningStone, Strings.SM_LightningStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LightningStone);
				}
				event.drops.add(LightningStone);
			}else if (drop == 3){
				ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LightningGem, Strings.SM_LightningGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LightningGem);
				}
				event.drops.add(LightningGem);
			}else if (drop == 4){
				ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LightningCrystal);
				}
				event.drops.add(LightningCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.LucidOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidShard, Strings.SM_LucidShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LucidShard);
				}
				event.drops.add(LucidShard);
			}else if (drop == 2){
				ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidStone, Strings.SM_LucidStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LucidStone);
				}
				event.drops.add(LucidStone);
			}else if (drop == 3){
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LucidGem);
				}
				event.drops.add(LucidGem);
			}else if (drop == 4){
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(LucidCrystal);
				}
				event.drops.add(LucidCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PowerOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerShard);
				}
				event.drops.add(PowerShard);
			}else if (drop == 2){
				ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerStone);
				}
				event.drops.add(PowerStone);
			}else if (drop == 3){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerGem);
				}
				event.drops.add(PowerGem);
			}else if (drop == 4){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerCrystal);
				}
				event.drops.add(PowerCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PowerOreE){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerShard);
				}
				event.drops.add(PowerShard);
			}else if (drop == 2){
				ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerStone);
				}
				event.drops.add(PowerStone);
			}else if (drop == 3){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerGem);
				}
				event.drops.add(PowerGem);
			}else if (drop == 4){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(PowerCrystal);
				}
				event.drops.add(PowerCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.RemembranceOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceShard, Strings.SM_RemembranceShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(RemembranceShard);
				}
				event.drops.add(RemembranceShard);
			}else if (drop == 2){
				ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(RemembranceStone);
				}
				event.drops.add(RemembranceStone);
			}else if (drop == 3){
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(RemembranceGem);
				}
				event.drops.add(RemembranceGem);
			}else if (drop == 4){
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(RemembranceCrystal);
				}
				event.drops.add(RemembranceCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.SerenityOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(SerenityShard);
				}
				event.drops.add(SerenityShard);
			}else if (drop == 2){
				ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(SerenityStone);
				}
				event.drops.add(SerenityStone);
			}else if (drop == 3){
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(SerenityGem);
				}
				event.drops.add(SerenityGem);
			}else if (drop == 4){
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(SerenityCrystal);
				}
				event.drops.add(SerenityCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.TranquilOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilShard, Strings.SM_TranquilShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TranquilShard);
				}
				event.drops.add(TranquilShard);
			}else if (drop == 2){
				ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TranquilStone);
				}
				event.drops.add(TranquilStone);
			}else if (drop == 3){
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TranquilGem);
				}
				event.drops.add(TranquilGem);
			}else if (drop == 4){
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TranquilCrystal);
				}
				event.drops.add(TranquilCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.TwilightOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TwilightShard);
				}
				event.drops.add(TwilightShard);
			}else if (drop == 2){
				ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TwilightStone);
				}
				event.drops.add(TwilightStone);
			}else if (drop == 3){
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TwilightGem);
				}
				event.drops.add(TwilightGem);
			}else if (drop == 4){
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(TwilightCrystal);
				}
				event.drops.add(TwilightCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.StormyOre){
			int drop = randomWithRange(1, 4);
			if(drop == 1){
				ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(StormyShard, Strings.SM_StormyShard, "C");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(StormyShard);
				}
				event.drops.add(StormyShard);
			}else if (drop == 2){
				ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(StormyStone, Strings.SM_StormyStone, "B");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(StormyStone);
				}
				event.drops.add(StormyStone);
			}else if (drop == 3){
				ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(StormyGem, Strings.SM_StormyGem, "A");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(StormyGem);
				}
				event.drops.add(StormyGem);
			}else if (drop == 4){
				ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, "S");
				for(int i = 0; i<event.fortuneLevel;i++)
				{
					fortune = randomWithRange(1, 15);
					if(fortune < 5)
						event.drops.add(StormyCrystal);
				}
				event.drops.add(StormyCrystal);
			}
		}
		else if (event.state.getBlock() == ModBlocks.PrizeBlox){
			int drop = randomWithRange(1, 29);
			if(drop == 1){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 50);
				event.drops.add(munny);
			}
			else if(drop == 2){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 100);
				event.drops.add(munny);
			}
			else if(drop == 3){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 500);
				event.drops.add(munny);
			}
			else if(drop == 4){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 700);
				event.drops.add(munny);
			}
			else if(drop == 5){
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingShard, "C");
				event.drops.add(BlazingGem);
			}
			else if(drop == 6){
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightShard, "C");
				event.drops.add(BrightGem);
			}
			else if(drop == 7){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkShard, "C");
				event.drops.add(DarkGem);
			}
			else if(drop == 8){
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseShard, "C");
				event.drops.add(DenseGem);
			}
			else if(drop == 9){
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyShard, "C");
				event.drops.add(EnergyGem);
			}
			else if(drop == 10){
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostShard, "C");
				event.drops.add(FrostGem);
			}
			else if(drop == 11){
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidShard, "C");
				event.drops.add(LucidGem);
			}
			else if(drop == 12){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerShard, "C");
				event.drops.add(PowerGem);
			}
			else if(drop == 13){
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceShard, "C");
				event.drops.add(RemembranceGem);
			}
			else if(drop == 14){
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityShard, "C");
				event.drops.add(SerenityGem);
			}
			else if(drop == 15){
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilShard, "C");
				event.drops.add(TranquilGem);
			}
			else if(drop == 16){
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightShard, "C");
				event.drops.add(TwilightGem);
			}
			else if(drop == 17){
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingStone,"B");
				event.drops.add(BlazingCrystal);
			}
			else if(drop == 18){
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightStone,"B");
				event.drops.add(BrightCrystal);
			}
			else if(drop == 19){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkStone,"B");
				event.drops.add(DarkCrystal);
			}
			else if(drop == 20){
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseStone,"B");
				event.drops.add(DenseCrystal);
			}
			else if(drop == 21){
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyStone,"B");
				event.drops.add(EnergyCrystal);
			}
			else if(drop == 22){
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostStone,"B");
				event.drops.add(FrostCrystal);
			}
			else if(drop == 23){
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidStone,"B");
				event.drops.add(LucidCrystal);
			}
			else if(drop == 24){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerStone,"B");
				event.drops.add(PowerCrystal);
			}
			else if(drop == 25){
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceStone,"B");
				event.drops.add(RemembranceCrystal);
			}
			else if(drop == 26){
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityStone,"B");
				event.drops.add(SerenityCrystal);
			}
			else if(drop == 27){
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilStone,"B");
				event.drops.add(TranquilCrystal);
			}
			else if(drop == 28){
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightStone,"B");
				event.drops.add(TwilightCrystal);
			}
			else if(drop == 29){
				ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(Orichalcum, Strings.SM_Orichalcum,"A");
				event.drops.add(Orichalcum);
			}
		}

		else if (event.state.getBlock() == ModBlocks.RarePrizeBlox){
			int drop = randomWithRange(1, 28);
			if(drop == 1){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 1000);
				event.drops.add(munny);
			}
			else if(drop == 2){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 1500);
				event.drops.add(munny);
			}
			else if(drop == 3){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 2000);
				event.drops.add(munny);
			}
			else if(drop == 4){
				ItemStack munny = new ItemStack(ModItems.Munny, 1);
				munny.setTagCompound(new NBTTagCompound());
				munny.getTagCompound().setInteger("amount", 3000);
				event.drops.add(munny);
			}
			else if(drop == 5){
				ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A");
				event.drops.add(BlazingGem);
			}
			else if(drop == 6){
				ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A");
				event.drops.add(BrightGem);
			}
			else if(drop == 7){
				ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
				event.drops.add(DarkGem);
			}
			else if(drop == 8){
				ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");
				event.drops.add(DenseGem);
			}
			else if(drop == 9){
				ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A");
				event.drops.add(EnergyGem);
			}
			else if(drop == 10){
				ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A");
				event.drops.add(FrostGem);
			}
			else if(drop == 11){
				ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A");
				event.drops.add(LucidGem);
			}
			else if(drop == 12){
				ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
				event.drops.add(PowerGem);
			}
			else if(drop == 13){
				ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A");
				event.drops.add(RemembranceGem);
			}
			else if(drop == 14){
				ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A");
				event.drops.add(SerenityGem);
			}
			else if(drop == 15){
				ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A");
				event.drops.add(TranquilGem);
			}
			else if(drop == 16){
				ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
				event.drops.add(TwilightGem);
			}
			else if(drop == 17){
				ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");
				event.drops.add(BlazingCrystal);
			}
			else if(drop == 18){
				ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");
				event.drops.add(BrightCrystal);
			}
			else if(drop == 19){
				ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
				event.drops.add(DarkCrystal);
			}
			else if(drop == 20){
				ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");
				event.drops.add(DenseCrystal);
			}
			else if(drop == 21){
				ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S");
				event.drops.add(EnergyCrystal);
			}
			else if(drop == 22){
				ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");
				event.drops.add(FrostCrystal);
			}
			else if(drop == 23){
				ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S");
				event.drops.add(LucidCrystal);
			}
			else if(drop == 24){
				ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
				event.drops.add(PowerCrystal);
			}
			else if(drop == 25){
				ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S");
				event.drops.add(RemembranceCrystal);
			}
			else if(drop == 26){
				ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S");
				event.drops.add(SerenityCrystal);
			}
			else if(drop == 27){
				ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S");
				event.drops.add(TranquilCrystal);
			}
			else if(drop == 28){
				ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");
				event.drops.add(TwilightCrystal);
			}
			else if(drop == 29){
				ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, "A");
				event.drops.add(Orichalcum);
			}
			else if(drop == 30){
				ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial, randomWithRange(1, 3));
				ItemStacks.createSynthesisItem(OrichalcumPlus, Strings.SM_OrichalcumPlus, "S");
				event.drops.add(OrichalcumPlus);
			}
		}
	}
}