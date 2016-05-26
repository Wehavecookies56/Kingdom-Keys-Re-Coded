package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumDoorHalf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.AttackEntity;

import java.util.List;

public class ItemKeyblade extends ItemSword {

	public static int
	abaddonplasma[] = {30,24},
	abyssaltide[] = {,},
	allforone[] = {,},
    anguisforetellerskeyblade[] = {,},
    arpeggio[] = {,},
    astralblast[] = {,},
    aubade[] = {,},
    blazeofglory[] = {,},
    bondofflame[] = {12,8},
    bookofretribution[] = {,},
    brightcrest[] = {,},
    chaosripper[] = {30,4},
    circleoflife[] = {12,2},
    counterpoint[] = {36,28},
    crabclaw[] = {18,2},
    crownofguilt[] = {,},
    darkerthandark[] = {,},
    darkgnaw[] = {15,4},
    decisivepumpkin[] = {,},
    destinysembrace[] = {,},
    diamonddust[] = {9,6},
    divewing[] = {,},
    divinerose[] = {30,0},
    dreamsword[] = {,},
    dualdisc[] = {,},
    earthshaker[] = {9,2},
    endofpain[] = {,},
    endsoftheearth[] = {15,6},
    eternalflames[] = {,},
    fairgame[] = {,},
    fairyharp[] = {24,2},
    fairystars[] = {6,6},
    fatalcrest[] = {9,10},
    fenrir[] = {21,2},
    ferrisgear[] = {,},
    followthewind[] = {9,2},
    foudre[] = {,},
    frolicflame[] = {,},
    frozenpride[] = {,},
    glimpseofdarkness[] = {,},
    gracefuldahlia[] = {,},
    guardianbell[] = {,},
    guardiansoul[] = {15,2},
    gullwing[] = {6,6},
    heroscrest[] = {12,0},
    hiddendragon[] = {6,4},
    hyperdrive[] = {12,6},
    ifrit[] = {,},
    incompletekiblade[] = {18,6},
    interdiction[] = {,},
    jungleking[] = {15,0},
    keybladeofpeopleshearts[] = {,},
    kiblade[] = {36,18},
    kingdomkey[] = {9,2},
    kingdomkeyd[] = {9,2},
    knockoutpunch[] = {,},
    ladyluck[] = {24,4},
    leaskeyblade[] = {,},
    leopardosforetellerskeyblade[] = {,},
    leviathan[] = {,},
    lindworm[] = {,},
    lionheart[] = {30,2},
    lostmemory[] = {,},
    lunareclipse[] = {,},
    lunatic[] = {,},
    markofahero[] = {15,2},
    mastersdefender[] = {,},
    masterxehanortskeyblade[] = {,},
    maverickflare[] = {,},
    metalchocobo[] = {30,-2},
    midnightroar[] = {,},
    miragesplit[] = {,},
    missingache[] = {,},
    monochrome[] = {9,4},
    mysteriousabyss[] = {9,6},
    nightmaresend[] = {,},
    nightmaresendandmiragesplit[] = {,},
    noname[] = {18,24},
    oathkeeper[] = {18,6},
    oblivion[] = {24,4},
    oceansrage[] = {24,20},
    olympia[] = {27,0},
    omegaweapon[] = {,},
    ominousblight[] = {,},
    onewingedangel[] = {24,-4},
    painofsolitude[] = {,},
    photondebugger[] = {9,4},
    pixiepetal[] = {9,12},
    prometheus[] = {,},
    pumpkinhead[] = {21,0},
    rainfell[] = {6,4},
    rejectionoffate[] = {,},
    royalradiance[] = {24,14},
    rumblingrose[] = {15,0},
    sharpshooter[] = {,},
    signofinnocence[] = {,},
    silentdirge[] = {,},
    skullnoise[] = {21,14},
    skysplitter[] = {,},
    sleepinglion[] = {15,6},
    souleater[] = {,},
    spellbinder[] = {12,4},
    starlight[] = {,},
    starseeker[] = {9,2},
    stormfall[] = {,},
    strokeofmidnight[] = {6,4},
    sweetdreams[] = {,},
    sweetmemories[] = {4,8},
    sweetstack[] = {18,8},
    threewishes[] = {18,0},
    totaleclipse[] = {,},
    treasuretrove[] = {9,4},
    truelightsflight[] = {,},
    twilightblaze[] = {,},
    twobecomeone[] = {15,8},
    ultimaweaponbbs[] = {30,14},
    ultimaweaponddd[] = {30,14},
    ultimaweaponkh1[] = {30,14},
    ultimaweaponkh2[] = {30,14},
    umbrella[] = {12,4},
    unbound[] = {27,28},
    unicorni7sforetellerskeyblade[] = {,},
    ursusforetellerskeyblade[] = {,},
    victoryline[] = {,},
    voidgear[] = {,},
    vulpeusforetellerskeyblade[] = {,},
    waytothedawn[] = {15,8},
    waywardwind[] = {9,2},
    winnersproof[] = {15,14},
    wishinglamp[] = {12,6},
    wishingstar[] = {18,0},
    woodenkeyblade[] = {,},
    woodenstick[] = {,},
    youngxehanortskeyblade[] = {,},
    zeroone[] = {,};
	int magic, strength;

	public ItemKeyblade (int strength, int magic) {
		super(EnumHelper.addToolMaterial("KEYBLADE", 0, -1, 0, 0, 20));
		this.magic = magic;
		this.strength = strength;
		setMaxStackSize(1);
		setCreativeTab(ModItems.tabKingdomKeys);
	}
	public int getStrength() {
		return this.strength;
	}
	
	public int getMagic() {
		return this.magic;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	/*@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Strength: "+(getStrength()+(player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() * 0.25))+"TOTAL"+getStrength());
		dataList.add("Magic: "+getMagic());
	}*/
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {
		if(player.isSneaking()) {
			
		} else {
			if (worldIn.isRemote){
				RayTraceResult rtr = Minecraft.getMinecraft().objectMouseOver;
				if (player.getHeldItem(EnumHand.OFF_HAND) != null && player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade) {
					if(player.swingProgress <= 0)
						player.swingArm(EnumHand.OFF_HAND);
					if (rtr.entityHit != null) {
						PacketDispatcher.sendToServer(new AttackEntity(rtr.entityHit.getEntityId()));
						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
					}
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
				}
				
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (stack.getItem() == ModItems.WoodenKeyblade || stack.getItem() == ModItems.WoodenStick || stack.getItem() == ModItems.DreamSword)
			return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);

		if (world.getBlockState(pos).getBlock() instanceof BlockDoor) {
			SoundEvent sound;
			PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
			if ((!STATS.getRecharge()) || player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
				if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) STATS.remMP(30);

				if (world.getBlockState(pos).getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
					world.setBlockState(pos.down(), world.getBlockState(pos.down()).withProperty(BlockDoor.OPEN, !world.getBlockState(pos.down()).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos.down()).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
					world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
					return EnumActionResult.SUCCESS;
				} else {
					world.setBlockState(pos, world.getBlockState(pos).withProperty(BlockDoor.OPEN, !world.getBlockState(pos).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
					world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
					return EnumActionResult.SUCCESS;
				}
			}
		}
		return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
	}
	
}
