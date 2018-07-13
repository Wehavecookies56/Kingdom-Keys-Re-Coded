package uk.co.wehavecookies56.kk.common.ability;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.common.lib.Strings;

@Mod.EventBusSubscriber
public class Abilities {

    public static Ability scan, highJump, quickRun, aerialDodge, glide;
    		
    @SubscribeEvent
    public static void registerAbilities(RegistryEvent.Register<Ability> event) {
        event.getRegistry().register(scan = new Ability(1, Strings.AbilityScan));
        event.getRegistry().register(highJump = new Ability(2, Strings.AbilityHighJump));
        event.getRegistry().register(quickRun = new Ability(2, Strings.AbilityQuickRun));
        event.getRegistry().register(aerialDodge = new Ability(3, Strings.AbilityAerialDodge));
        event.getRegistry().register(glide = new Ability(3, Strings.AbilityGlide));
    }

}
