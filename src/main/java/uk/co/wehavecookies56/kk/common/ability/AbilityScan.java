package uk.co.wehavecookies56.kk.common.ability;

import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.api.abilities.Ability;

public class AbilityScan extends Ability {

    @Override
    public int getAPCost() {
        return 1;
    }
    @Override
    public String getName() {
        return "ability.scan";
    }
}
