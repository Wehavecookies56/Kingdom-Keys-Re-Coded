package uk.co.wehavecookies56.kk.common.util;

import java.util.ArrayList;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;

public class WorldSpawner {
	public int dim;
	public BlockPos pos;
	public ArrayList<IKHMob> enemies;
	public boolean enabled = true;
	
	public WorldSpawner(int toDim, BlockPos toPos, ArrayList<IKHMob> enemies) {
		this.dim = toDim;
		this.pos = toPos;
		this.enemies = enemies;
	}
	
	public void setEnabled(boolean b) {
		this.enabled = b;
	}
	
	public boolean getEnabled() {
		return this.enabled;
	}
}
