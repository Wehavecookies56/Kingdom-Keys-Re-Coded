package uk.co.wehavecookies56.kk.common.ability;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.api.abilities.Ability;

@Mod.EventBusSubscriber
public class Abilities {

    public static Ability scan;

    @SubscribeEvent
    public static void registerAbilities(RegistryEvent.Register<Ability> event) {
        event.getRegistry().register(scan = new AbilityScan().setRegistryName("kk:ability.scan"));
    }

}
