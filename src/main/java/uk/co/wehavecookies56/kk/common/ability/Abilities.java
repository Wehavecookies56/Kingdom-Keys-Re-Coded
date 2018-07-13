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

    public static Ability scan, highJump, quickRun, aerialDodge, glide, mpHaste;
        		
    @SubscribeEvent
    public static void registerAbilities(RegistryEvent.Register<Ability> event) {
        event.getRegistry().register(scan = new Ability(1, Strings.AbilityScan, Ability.Category.SUPPORT));
		event.getRegistry().register(highJump = new Ability(2, Strings.AbilityHighJump, Ability.Category.GROWTH));
        event.getRegistry().register(quickRun = new Ability(2, Strings.AbilityQuickRun, Ability.Category.GROWTH));
        event.getRegistry().register(aerialDodge = new Ability(3, Strings.AbilityAerialDodge, Ability.Category.GROWTH));
        event.getRegistry().register(glide = new Ability(3, Strings.AbilityGlide, Ability.Category.GROWTH));
        event.getRegistry().register(mpHaste = new Ability(1, Strings.AbilityMPHaste, Ability.Category.SUPPORT));
    }

}
