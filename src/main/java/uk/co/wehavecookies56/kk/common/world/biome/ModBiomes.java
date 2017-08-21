package uk.co.wehavecookies56.kk.common.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeVoid;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import java.awt.Color;


public class ModBiomes {

    @GameRegistry.ObjectHolder(Reference.MODID + ":biome_destinyislands")
    public static Biome DestinyIslandsBiome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":biome_divetotheheart")
    public static Biome DiveToTheHeartBiome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":biome_traversetown")
    public static Biome TraverseTownBiome;

    public static void init() {
        BiomeDictionary.addTypes(DestinyIslandsBiome, BiomeDictionary.Type.WET, BiomeDictionary.Type.BEACH);
        BiomeDictionary.addTypes(DiveToTheHeartBiome, BiomeDictionary.Type.VOID);
        BiomeDictionary.addTypes(TraverseTownBiome, BiomeDictionary.Type.DRY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.VOID);
    }

    @SubscribeEvent
    public void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(new BiomeVoid(new Biome.BiomeProperties("Destiny Islands")
                .setRainDisabled()
                .setWaterColor(new Color(76, 225, 255).hashCode())
                .setTemperature(0.8F)
                .setBaseBiome("Destiny Islands")
        ).setRegistryName("biome_destinyislands"));
        event.getRegistry().register(new BiomeVoid(new Biome.BiomeProperties("Station of Awakening")
                .setRainDisabled()
                .setBaseBiome("Station of Awakening")
        ).setRegistryName("biome_divetotheheart"));
        event.getRegistry().register(new BiomeVoid(new Biome.BiomeProperties("Traverse Town")
                .setRainDisabled()
                .setBaseBiome("Traverse Town")
        ).setRegistryName("biome_traversetown"));
    }


}
