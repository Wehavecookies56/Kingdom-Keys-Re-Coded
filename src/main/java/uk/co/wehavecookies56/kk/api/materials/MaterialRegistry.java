package uk.co.wehavecookies56.kk.api.materials;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

public class MaterialRegistry {

    private static Map<String, Material> materialMap = new HashMap<String, Material>();

    public static Map<String, Material> getMaterialMap () {
        return ImmutableMap.copyOf(materialMap);
    }

    public static boolean registerMaterial (Material material) {
        if (isMaterialRegistered(material.getName())) return false;
        materialMap.put(material.getName(), material);
        return true;
    }

    public static boolean isMaterialRegistered (Material material) {
        return isMaterialRegistered(material.getName());
    }

    public static boolean isMaterialRegistered (String name) {
        return materialMap.containsKey(name);
    }

    public static Material get (String name) {
        return materialMap.get(name);
    }

    public static boolean learnMaterial (EntityPlayer player, String name) {
        if (player != null && !isMaterialKnown(player, name)) {
            Material material = materialMap.get(name);
            //player.getCapability(KingdomKeys.SYNTHESIS_MATERIALS, null).(material);
            return true;
        }
        return false;
    }

    public static boolean isMaterialKnown (EntityPlayer player, String name) {
        return player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).getKnownMaterialsMap().containsKey(name);
    }

}
