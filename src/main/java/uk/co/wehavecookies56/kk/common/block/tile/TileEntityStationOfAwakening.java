package uk.co.wehavecookies56.kk.common.block.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Toby on 02/08/2016.
 */
public class TileEntityStationOfAwakening extends TileEntity {

    public int px, py, pz;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        compound.setInteger("px", px);
        compound.setInteger("py", py);
        compound.setInteger("pz", pz);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        px = compound.getInteger("px");
        py = compound.getInteger("py");
        pz = compound.getInteger("pz");
        return compound;
}
}
