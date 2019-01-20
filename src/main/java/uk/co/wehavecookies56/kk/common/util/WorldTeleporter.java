package uk.co.wehavecookies56.kk.common.util;

import net.minecraft.util.math.BlockPos;

public class WorldTeleporter {
	public String fromName, toName;
	public int fromDim, toDim;
	public BlockPos fromPos, toPos;
	
	public WorldTeleporter(String toName, int toDim, BlockPos toPos) {
		this.toName = toName;
		this.toDim = toDim;
		this.toPos = toPos;
	}
	
	public WorldTeleporter(String fromName, int fromDim, BlockPos fromPos, String toName, int toDim, BlockPos toPos) {
		this.fromName = fromName;
		this.fromDim = fromDim;
		this.fromPos = fromPos;
		this.toName = toName;
		this.toDim = toDim;
		this.toPos = toPos;
	}
}
