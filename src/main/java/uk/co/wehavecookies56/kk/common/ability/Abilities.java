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
public class Abilities {

	//public static Ability scan, highJump, quickRun, aerialDodge, glide, mpHaste;

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
	expBoost,
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
		event.getRegistry().register(aerialDive = new Ability(1, Strings.aerialDive, Ability.Category.ACTION));
		event.getRegistry().register(aerialFinish = new Ability(1, Strings.aerialFinish, Ability.Category.ACTION));
		event.getRegistry().register(aerialSprial = new Ability(1, Strings.aerialSprial, Ability.Category.ACTION));
		event.getRegistry().register(aerialSweep = new Ability(1, Strings.aerialSweep, Ability.Category.ACTION));
		event.getRegistry().register(arsArcanum = new Ability(1, Strings.arsArcanum, Ability.Category.ACTION));
		event.getRegistry().register(autoFinal = new Ability(1, Strings.autoFinal, Ability.Category.ACTION));
		event.getRegistry().register(autoLimit = new Ability(1, Strings.autoLimit, Ability.Category.ACTION));
		event.getRegistry().register(autoMaster = new Ability(1, Strings.autoMaster, Ability.Category.ACTION));
		event.getRegistry().register(autoSummon = new Ability(1, Strings.autoSummon, Ability.Category.ACTION));
		event.getRegistry().register(autoValor = new Ability(1, Strings.autoValor, Ability.Category.ACTION));
		event.getRegistry().register(autoWisdom = new Ability(1, Strings.autoWisdom, Ability.Category.ACTION));
		event.getRegistry().register(blitz = new Ability(1, Strings.blitz, Ability.Category.ACTION));
		event.getRegistry().register(counterattack = new Ability(1, Strings.counterattack, Ability.Category.ACTION));
		event.getRegistry().register(counterguard = new Ability(1, Strings.counterguard, Ability.Category.ACTION));
		event.getRegistry().register(crescent = new Ability(1, Strings.crescent, Ability.Category.ACTION));
		event.getRegistry().register(dodgeSlash = new Ability(1, Strings.dodgeSlash, Ability.Category.ACTION));
		event.getRegistry().register(explosion = new Ability(1, Strings.explosion, Ability.Category.ACTION));
		event.getRegistry().register(finishingLeap = new Ability(1, Strings.finishingLeap, Ability.Category.ACTION));
		event.getRegistry().register(flashStep = new Ability(1, Strings.flashStep, Ability.Category.ACTION));
		event.getRegistry().register(gravityBreak = new Ability(1, Strings.gravityBreak, Ability.Category.ACTION));
		event.getRegistry().register(guard = new Ability(1, Strings.guard, Ability.Category.ACTION));
		event.getRegistry().register(guardBreak = new Ability(1, Strings.guardBreak, Ability.Category.ACTION));
		event.getRegistry().register(horizontalSlash = new Ability(1, Strings.horizontalSlash, Ability.Category.ACTION));
		event.getRegistry().register(hurricaneBlast = new Ability(1, Strings.hurricaneBlast, Ability.Category.ACTION));
		event.getRegistry().register(magnetSplash = new Ability(1, Strings.magnetSplash, Ability.Category.ACTION));
		event.getRegistry().register(ragnarok = new Ability(1, Strings.ragnarok, Ability.Category.ACTION));
		event.getRegistry().register(retaliatingSlash = new Ability(1, Strings.retaliatingSlash, Ability.Category.ACTION));
		event.getRegistry().register(rippleDrive = new Ability(1, Strings.rippleDrive, Ability.Category.ACTION));
		event.getRegistry().register(slidingDash = new Ability(1, Strings.slidingDash, Ability.Category.ACTION));
		event.getRegistry().register(roundBreak = new Ability(1, Strings.roundBreak, Ability.Category.ACTION));
		event.getRegistry().register(slapshot = new Ability(1, Strings.slapshot, Ability.Category.ACTION));
		event.getRegistry().register(sonicBlade = new Ability(1, Strings.sonicBlade, Ability.Category.ACTION));
		event.getRegistry().register(strikeRaid = new Ability(1, Strings.strikeRaid, Ability.Category.ACTION));
		event.getRegistry().register(stunImpact = new Ability(1, Strings.stunImpact, Ability.Category.ACTION));
		event.getRegistry().register(upperSlash = new Ability(1, Strings.upperSlash, Ability.Category.ACTION));
		event.getRegistry().register(vortex = new Ability(1, Strings.vortex, Ability.Category.ACTION));
		event.getRegistry().register(zantetsuken = new Ability(1, Strings.zantetsuken, Ability.Category.ACTION));

		event.getRegistry().register(aerialDodge = new Ability(1, Strings.aerialDodge, Ability.Category.GROWTH));
		event.getRegistry().register(dodgeRoll = new Ability(1, Strings.dodgeRoll, Ability.Category.GROWTH));
		event.getRegistry().register(glide = new Ability(1, Strings.glide, Ability.Category.GROWTH));
		event.getRegistry().register(highJump = new Ability(1, Strings.highJump, Ability.Category.GROWTH));
		event.getRegistry().register(quickRun = new Ability(1, Strings.quickRun, Ability.Category.GROWTH));

		event.getRegistry().register(aerialRecovery = new Ability(1, Strings.aerialRecovery, Ability.Category.SUPPORT));
		event.getRegistry().register(airComboBoost = new Ability(1, Strings.airComboBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(airComboPlus = new Ability(1, Strings.airComboPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(berserk = new Ability(1, Strings.berserk, Ability.Category.SUPPORT));
		event.getRegistry().register(berserkCharge = new Ability(1, Strings.berserkCharge, Ability.Category.SUPPORT));
		event.getRegistry().register(blizzardBoost = new Ability(1, Strings.blizzardBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(blizzardScreen = new Ability(1, Strings.blizzardScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(combinationBoost = new Ability(1, Strings.combinationBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboBoost = new Ability(1, Strings.comboBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboFBoost = new Ability(1, Strings.comboFBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(comboMaster = new Ability(1, Strings.comboMaster, Ability.Category.SUPPORT));
		event.getRegistry().register(comboPlus = new Ability(1, Strings.comboPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(criticalPlus = new Ability(1, Strings.criticalPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(cureBoost = new Ability(1, Strings.cureBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(damageControl = new Ability(1, Strings.damageControl, Ability.Category.SUPPORT));
		event.getRegistry().register(damageDrive = new Ability(1, Strings.damageDrive, Ability.Category.SUPPORT));
		event.getRegistry().register(darkScreen = new Ability(1, Strings.darkScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(defender = new Ability(1, Strings.defender, Ability.Category.SUPPORT));
		event.getRegistry().register(draw = new Ability(1, Strings.draw, Ability.Category.SUPPORT));
		event.getRegistry().register(driveBoost = new Ability(1, Strings.driveBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(driveConverter = new Ability(1, Strings.driveConverter, Ability.Category.SUPPORT));
		event.getRegistry().register(encounterPlus = new Ability(1, Strings.encounterPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(endlessMagic = new Ability(1, Strings.endlessMagic, Ability.Category.SUPPORT));
		event.getRegistry().register(expBoost = new Ability(1, Strings.expBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(expWalker = new Ability(1, Strings.expWalker, Ability.Category.SUPPORT));
		event.getRegistry().register(experienceBoost = new Ability(1, Strings.experienceBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(finishBoost = new Ability(1, Strings.finishBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(finishingPlus = new Ability(1, Strings.finishingPlus, Ability.Category.SUPPORT));
		event.getRegistry().register(fireBoost = new Ability(1, Strings.fireBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(fireScreen = new Ability(1, Strings.fireScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(formBoost = new Ability(1, Strings.formBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(hpBoost = new Ability(1, Strings.hpBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(hpGain = new Ability(1, Strings.hpGain, Ability.Category.SUPPORT));
		event.getRegistry().register(hpPrizePlus = new Ability(1, Strings.hpPrizePlus, Ability.Category.SUPPORT));
		event.getRegistry().register(itemBoost = new Ability(1, Strings.itemBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(jackpot = new Ability(1, Strings.jackpot, Ability.Category.SUPPORT));
		event.getRegistry().register(leafBracer = new Ability(1, Strings.leafBracer, Ability.Category.SUPPORT));
		event.getRegistry().register(lightAndDark = new Ability(1, Strings.lightAndDark, Ability.Category.SUPPORT));
		event.getRegistry().register(luckyLucky = new Ability(1, Strings.luckyLucky, Ability.Category.SUPPORT));
		event.getRegistry().register(magicLockOn = new Ability(1, Strings.magicLockOn, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHaste = new Ability(1, Strings.mpHaste, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHastega = new Ability(1, Strings.mpHastega, Ability.Category.SUPPORT));
		event.getRegistry().register(mpHastera = new Ability(1, Strings.mpHastera, Ability.Category.SUPPORT));
		event.getRegistry().register(mpRage = new Ability(1, Strings.mpRage, Ability.Category.SUPPORT));
		event.getRegistry().register(negativeCombo = new Ability(1, Strings.negativeCombo, Ability.Category.SUPPORT));
		event.getRegistry().register(onceMore = new Ability(1, Strings.onceMore, Ability.Category.SUPPORT));
		event.getRegistry().register(reactionBoost = new Ability(1, Strings.reactionBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(scan = new Ability(1, Strings.scan, Ability.Category.SUPPORT));
		event.getRegistry().register(secondChance = new Ability(1, Strings.secondChance, Ability.Category.SUPPORT));
		event.getRegistry().register(summonBoost = new Ability(1, Strings.summonBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(synchBlade = new Ability(1, Strings.synchBlade, Ability.Category.SUPPORT));
		event.getRegistry().register(techBoost = new Ability(1, Strings.techBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(thunderBoost = new Ability(1, Strings.thunderBoost, Ability.Category.SUPPORT));
		event.getRegistry().register(thunderScreen = new Ability(1, Strings.thunderScreen, Ability.Category.SUPPORT));
		event.getRegistry().register(zeroEXP = new Ability(1, Strings.zeroEXP, Ability.Category.SUPPORT));
		
	}

}
