package uk.co.wehavecookies56.kk.api.abilities;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryInternal;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

@Mod.EventBusSubscriber
public class AbilityRegistry {

    public static BiMap<ResourceLocation, Ability> abilityMap = HashBiMap.create();

    public static IForgeRegistry<Ability> abilityRegistry;

    @SubscribeEvent
    public static void newRegistry(RegistryEvent.NewRegistry event) {
        abilityRegistry = new RegistryBuilder().setType(Ability.class).setName(new ResourceLocation(Reference.MODID, "ability_registry")).setIDRange(0, 16384).addCallback(new Callback()).create();
    }

    public static class Callback implements IForgeRegistry.AddCallback<Ability>, IForgeRegistry.ClearCallback<Ability>, IForgeRegistry.CreateCallback<Ability> {

        @Override
        public void onAdd(IForgeRegistryInternal<Ability> owner, RegistryManager stage, int id, Ability obj, @Nullable Ability oldObj) {
            KingdomKeys.logger.info("Registered Ability " + owner.getKey(obj).toString());
        }

        @Override
        public void onClear(IForgeRegistryInternal<Ability> owner, RegistryManager stage) {

        }

        @Override
        public void onCreate(IForgeRegistryInternal<Ability> owner, RegistryManager stage) {

        }
    }

}
