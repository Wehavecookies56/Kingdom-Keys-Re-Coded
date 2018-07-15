package uk.co.wehavecookies56.kk.common.ability;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.common.lib.Strings;

@Mod.EventBusSubscriber
public class ModAbilities {

	// Action
	public static Ability 
	aerialDive,
	aerialFinish,
	aerialSprial,
	aerialSweep,
	arsArcanum,
	autoFinal,
	autoLimit,
	autoMaster,
	autoSummon,
	autoValor,
	autoWisdom,
	blitz,
	counterattack,
	counterguard,
	crescent,
	dodgeSlash,
	explosion,
	finishingLeap,
	flashStep,
	gravityBreak,
	guard,
	guardBreak,
	horizontalSlash,
	hurricaneBlast,
	magnetSplash,
	ragnarok,
	retaliatingSlash,
	rippleDrive,
	roundBreak,
	slapshot,
	slidingDash,
	sonicBlade,
	strikeRaid,
	stunImpact,
	upperSlash,
	vortex,
	zantetsuken;
	
	// Growth
	public static Ability 
	aerialDodge,
	dodgeRoll,
	glide,
	highJump,
	quickRun;
	
	// Support
	public static Ability 
	aerialRecovery,
	airComboBoost,
	airComboPlus,
	berserk,
	berserkCharge,
	blizzardBoost,
	blizzardScreen,
	combinationBoost,
	comboBoost,
	comboFBoost,
	comboMaster,
	comboPlus,
	criticalPlus,
	cureBoost,
	damageControl,
	damageDrive,
	darkScreen,
	defender,
	draw,
	driveBoost,
	driveConverter,
	encounterPlus,
	endlessMagic,
	expWalker,
	experienceBoost,
	finishBoost,
	finishingPlus,
	fireBoost,
	fireScreen,
	formBoost,
	hpBoost,
	hpGain,
	hpPrizePlus,
	itemBoost,
	jackpot,
	leafBracer,
	lightAndDark,
	luckyLucky,
	magicLockOn,
	mpHaste,
	mpHastega,
	mpHastera,
	mpRage,
	negativeCombo,
	onceMore,
	reactionBoost,
	scan,
	secondChance,
	summonBoost,
	synchBlade,
	techBoost,
	thunderBoost,
	thunderScreen,
	zeroEXP;

	@SubscribeEvent
	public static void registerAbilities(RegistryEvent.Register<Ability> event) {
		event.getRegistry().register(aerialDive = new Ability(2, Strings.aerialDive, Ability.Category.ACTION));
		event.getRegistry().register(aerialFinish = new Ability(3, Strings.aerialFinish, Ability.Category.ACTION));
		event.getRegistry().register(aerialSprial = new Ability(2, Strings.aerialSprial, Ability.Category.ACTION));
		event.getRegistry().register(aerialSweep = new Ability(2, Strings.aerialSweep, Ability.Category.ACTION));
		event.getRegistry().register(arsArcanum = new Ability(4, Strings.arsArcanum, Ability.Category.ACTION));
		event.getRegistry().register(autoFinal = new Ability(1, Strings.autoFinal, Ability.Category.ACTION));
		event.getRegistry().register(autoLimit = new Ability(1, Strings.autoLimit, Ability.Category.ACTION));
		event.getRegistry().register(autoMaster = new Ability(1, Strings.autoMaster, Ability.Category.ACTION));
		event.getRegistry().register(autoSummon = new Ability(2, Strings.autoSummon, Ability.Category.ACTION));
		event.getRegistry().register(autoValor = new Ability(1, Strings.autoValor, Ability.Category.ACTION));
		event.getRegistry().register(autoWisdom = new Ability(1, Strings.autoWisdom, Ability.Category.ACTION));
		event.getRegistry().register(blitz = new Ability(3, Strings.blitz, Ability.Category.ACTION));
		event.getRegistry().register(counterattack = new Ability(2, Strings.counterattack, Ability.Category.ACTION));
		event.getRegistry().register(counterguard = new Ability(4, Strings.counterguard, Ability.Category.ACTION));
		event.getRegistry().register(crescent = new Ability(2, Strings.crescent, Ability.Category.ACTION));
		event.getRegistry().register(dodgeSlash = new Ability(2, Strings.dodgeSlash, Ability.Category.ACTION));
		event.getRegistry().register(explosion = new Ability(3, Strings.explosion, Ability.Category.ACTION));
		event.getRegistry().register(finishingLeap = new Ability(5, Strings.finishingLeap, Ability.Category.ACTION));
		event.getRegistry().register(flashStep = new Ability(2, Strings.flashStep, Ability.Category.ACTION));
		event.getRegistry().register(gravityBreak = new Ability(2, Strings.gravityBreak, Ability.Category.ACTION));
		event.getRegistry().register(guard = new Ability(2, Strings.guard, Ability.Category.ACTION));
		event.getRegistry().register(guardBreak = new Ability(3, Strings.guardBreak, Ability.Category.ACTION));
		event.getRegistry().register(horizontalSlash = new Ability(2, Strings.horizontalSlash, Ability.Category.ACTION));
		event.getRegistry().register(hurricaneBlast = new Ability(2, Strings.hurricaneBlast, Ability.Category.ACTION));
		event.getRegistry().register(magnetSplash = new Ability(3, Strings.magnetSplash, Ability.Category.ACTION));
		event.getRegistry().register(ragnarok = new Ability(4, Strings.ragnarok, Ability.Category.ACTION));
		event.getRegistry().register(retaliatingSlash = new Ability(3, Strings.retaliatingSlash, Ability.Category.ACTION));
		event.getRegistry().register(rippleDrive = new Ability(3, Strings.rippleDrive, Ability.Category.ACTION));
		event.getRegistry().register(roundBreak = new Ability(2, Strings.roundBreak, Ability.Category.ACTION));
		event.getRegistry().register(slapshot = new Ability(2, Strings.slapshot, Ability.Category.ACTION));
		event.getRegistry().register(slidingDash = new Ability(2, Strings.slidingDash, Ability.Category.ACTION));
		event.getRegistry().register(sonicBlade = new Ability(3, Strings.sonicBlade, Ability.Category.ACTION));
		event.getRegistry().register(strikeRaid = new Ability(3, Strings.strikeRaid, Ability.Category.ACTION));
		event.getRegistry().register(stunImpact = new Ability(2, Strings.stunImpact, Ability.Category.ACTION));
		event.getRegistry().register(upperSlash = new Ability(4, Strings.upperSlash, Ability.Category.ACTION));
		event.getRegistry().register(vortex = new Ability(1, Strings.vortex, Ability.Category.ACTION));
		event.getRegistry().register(zantetsuken = new Ability(2, Strings.zantetsuken, Ability.Category.ACTION));

		event.getRegistry().register(aerialDodge = new Ability(3, Strings.aerialDodge, Ability.Category.GROWTH));
		event.getRegistry().register(dodgeRoll = new Ability(3, Strings.dodgeRoll, Ability.Category.GROWTH));
		event.getRegistry().register(glide = new Ability(3, Strings.glide, Ability.Category.GROWTH));
		event.getRegistry().register(highJump = new Ability(2, Strings.highJump, Ability.Category.GROWTH));
		event.getRegistry().register(quickRun = new Ability(2, Strings.quickRun, Ability.Category.GROWTH));

		event.getRegistry().register(aerialRecovery = new Ability(2, Strings.aerialRecovery, Ability.Category.SUPPORT));
		event.getRegistry().register(airComboBoost = new Ability(4, Strings.airComboBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(airComboPlus = new Ability(1, Strings.airComboPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(berserk = new Ability(1, Strings.berserk, Ability.Category.SUPPORT));
		event.getRegistry().register(berserkCharge = new Ability(5, Strings.berserkCharge, Ability.Category.SUPPORT));
		event.getRegistry().register(blizzardBoost = new Ability(4, Strings.blizzardBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(blizzardScreen = new Ability(2, Strings.blizzardScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(combinationBoost = new Ability(4, Strings.combinationBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboBoost = new Ability(5, Strings.comboBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboFBoost = new Ability(4, Strings.comboFBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboMaster = new Ability(4, Strings.comboMaster, Ability.Category.SUPPORT));
		event.getRegistry().register(comboPlus = new Ability(1, Strings.comboPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(criticalPlus = new Ability(3, Strings.criticalPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(cureBoost = new Ability(3, Strings.cureBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(damageControl = new Ability(5, Strings.damageControl, Ability.Category.SUPPORT));
		event.getRegistry().register(damageDrive = new Ability(3, Strings.damageDrive, Ability.Category.SUPPORT));
		event.getRegistry().register(darkScreen = new Ability(2, Strings.darkScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(defender = new Ability(3, Strings.defender, Ability.Category.SUPPORT));
		event.getRegistry().register(draw = new Ability(3, Strings.draw, Ability.Category.SUPPORT));
		event.getRegistry().register(driveBoost = new Ability(3, Strings.driveBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(driveConverter = new Ability(5, Strings.driveConverter, Ability.Category.SUPPORT));
		event.getRegistry().register(encounterPlus = new Ability(1, Strings.encounterPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(endlessMagic = new Ability(0, Strings.endlessMagic, Ability.Category.SUPPORT));
		event.getRegistry().register(expWalker = new Ability(3, Strings.expWalker, Ability.Category.SUPPORT));
		event.getRegistry().register(experienceBoost = new Ability(4, Strings.experienceBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(finishBoost = new Ability(4, Strings.finishBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(finishingPlus = new Ability(5, Strings.finishingPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(fireBoost = new Ability(3, Strings.fireBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(fireScreen = new Ability(2, Strings.fireScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(formBoost = new Ability(5, Strings.formBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(hpBoost = new Ability(3, Strings.hpBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(hpGain = new Ability(0, Strings.hpGain, Ability.Category.SUPPORT));
		event.getRegistry().register(hpPrizePlus = new Ability(2, Strings.hpPrizePlus, Ability.Category.SUPPORT));
		event.getRegistry().register(itemBoost = new Ability(2, Strings.itemBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(jackpot = new Ability(3, Strings.jackpot, Ability.Category.SUPPORT));
		event.getRegistry().register(leafBracer = new Ability(1, Strings.leafBracer, Ability.Category.SUPPORT));
		event.getRegistry().register(lightAndDark = new Ability(0, Strings.lightAndDark, Ability.Category.SUPPORT));
		event.getRegistry().register(luckyLucky = new Ability(5, Strings.luckyLucky, Ability.Category.SUPPORT));
		event.getRegistry().register(magicLockOn = new Ability(2, Strings.magicLockOn, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHaste = new Ability(3, Strings.mpHaste, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHastega = new Ability(5, Strings.mpHastega, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHastera = new Ability(4, Strings.mpHastera, Ability.Category.SUPPORT));
		event.getRegistry().register(mpRage = new Ability(2, Strings.mpRage, Ability.Category.SUPPORT));
		event.getRegistry().register(negativeCombo = new Ability(2, Strings.negativeCombo, Ability.Category.SUPPORT));
		event.getRegistry().register(onceMore = new Ability(4, Strings.onceMore, Ability.Category.SUPPORT));
		event.getRegistry().register(reactionBoost = new Ability(2, Strings.reactionBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(scan = new Ability(1, Strings.scan, Ability.Category.SUPPORT));
		event.getRegistry().register(secondChance = new Ability(3, Strings.secondChance, Ability.Category.SUPPORT));
		event.getRegistry().register(summonBoost = new Ability(5, Strings.summonBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(synchBlade = new Ability(0, Strings.synchBlade, Ability.Category.SUPPORT));
		event.getRegistry().register(techBoost = new Ability(2, Strings.techBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(thunderBoost = new Ability(5, Strings.thunderBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(thunderScreen = new Ability(2, Strings.thunderScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(zeroEXP = new Ability(0, Strings.zeroEXP, Ability.Category.SUPPORT));
		
	}

}
