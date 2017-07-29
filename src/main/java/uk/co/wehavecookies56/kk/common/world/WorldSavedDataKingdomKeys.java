package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class WorldSavedDataKingdomKeys extends WorldSavedData {

    private static final String DATA_NAME = Reference.MODID + "_WorldData";

    public boolean generated;

    public WorldSavedDataKingdomKeys() {
        super(DATA_NAME);
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
        markDirty();
    }

    public WorldSavedDataKingdomKeys(String name) {
        super(name);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        generated = nbt.getBoolean("generated");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean("generated", generated);
        return compound;
    }

    public static WorldSavedDataKingdomKeys get(World world) {
        MapStorage storage = world.getPerWorldStorage();
        WorldSavedDataKingdomKeys instance = (WorldSavedDataKingdomKeys) storage.getOrLoadData(WorldSavedDataKingdomKeys.class, DATA_NAME);

        if (instance == null) {
            instance = new WorldSavedDataKingdomKeys();
            storage.setData(DATA_NAME, instance);
        }
        return instance;
    }

}
