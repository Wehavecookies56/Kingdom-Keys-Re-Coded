package uk.co.wehavecookies56.kk.common.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityBlueRhapsody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityCrimsonJazz;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDetonator;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityEmeraldBlues;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGigaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGreenRequiem;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMegaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMinuteBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityRedNocturne;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySilverRock;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySkaterBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityStormBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityYellowOpera;

public class Spawnings {
	public static void init() {
		Iterator<Biome> biomeRegistry = Biome.REGISTRY.iterator();
        List<Biome> biomes = new ArrayList<>();
        while(biomeRegistry.hasNext()) {
            Biome biome = biomeRegistry.next();
            if (biome.getSpawnableList(KingdomKeys.HEARTLESS) != null && biome.getSpawnableList(KingdomKeys.MOOGLE) != null)
                biomes.add(biome);
        }
        for (String b : MainConfig.entities.mobBiomeExclusion) {
            if (Biome.REGISTRY.containsKey(new ResourceLocation(b))) {
                KingdomKeys.logger.info("Removed mob spawns for biome " + b);
                biomes.remove(Biome.REGISTRY.getObject(new ResourceLocation(b)));
            }
        }
        Biome[] biomesArray = biomes.toArray(new Biome[biomes.size()]);

        //Pureblood
        registerSpawn(EntityShadow.class, MainConfig.entities.shadowRatio, 3, 5, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityMegaShadow.class, MainConfig.entities.megaShadowRatio, 2, 3, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityGigaShadow.class, MainConfig.entities.gigaShadowRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityDarkball.class, MainConfig.entities.darkballRatio, 1, 2, KingdomKeys.HEARTLESS, biomesArray);
        
        //Emblem
        registerSpawn(EntityRedNocturne.class, MainConfig.entities.redNocturneRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityBlueRhapsody.class, MainConfig.entities.blueRhapsodyRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityYellowOpera.class, MainConfig.entities.yellowOperaRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityGreenRequiem.class, MainConfig.entities.greenRequiemRatio, 1, 2, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntityEmeraldBlues.class, MainConfig.entities.emeraldBluesRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        registerSpawn(EntitySilverRock.class, MainConfig.entities.silverRockRatio, 1, 1, KingdomKeys.HEARTLESS, Biomes.SKY);
        registerSpawn(EntityCrimsonJazz.class, MainConfig.entities.crimsonJazzRatio, 1, 1, KingdomKeys.HEARTLESS, Biomes.HELL);
        registerSpawn(EntityMinuteBomb.class, MainConfig.entities.minuteBombRatio, 2, 4, KingdomKeys.HEARTLESS, Biomes.HELL);
        registerSpawn(EntitySkaterBomb.class, MainConfig.entities.skaterBombRatio, 1, 3, KingdomKeys.HEARTLESS, Biomes.HELL);
        registerSpawn(EntityStormBomb.class, MainConfig.entities.stormBombRatio, 1, 2, KingdomKeys.HEARTLESS, Biomes.HELL);
        registerSpawn(EntityDetonator.class, MainConfig.entities.detonatorRatio, 1, 1, KingdomKeys.HEARTLESS, Biomes.HELL);

        //Others
        registerSpawn(EntityMoogle.class, MainConfig.entities.moogleRatio, 1, 1, KingdomKeys.MOOGLE, biomesArray);

        KingdomKeys.logger.info("Entity spawning loaded");

	}
	
	public static void registerSpawn(Class<? extends EntityLiving> entityClass, int configRatio, int min, int max, EnumCreatureType type, Biome... biomes) {
		 if (configRatio != 0)
	            EntityRegistry.addSpawn(entityClass, configRatio, min, max, type, biomes);
	}
}
