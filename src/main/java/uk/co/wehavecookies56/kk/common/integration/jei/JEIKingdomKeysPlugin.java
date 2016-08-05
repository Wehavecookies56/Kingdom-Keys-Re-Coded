package uk.co.wehavecookies56.kk.common.integration.jei;

import mezz.jei.api.*;

import javax.annotation.Nonnull;

/**
 * Created by Toby on 04/08/2016.
 */

@JEIPlugin
public class JEIKingdomKeysPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {

    }
}
