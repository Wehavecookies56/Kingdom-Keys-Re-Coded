package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncDriveData extends AbstractClientMessage<SyncDriveData> {

	boolean inDrive;
	String driveName;
	int antiPoints;
	int valorLevel, valorExp;
	int wisdomLevel, wisdomExp;
	int limitLevel, limitExp;
	int masterLevel, masterExp;
	int finalLevel, finalExp;
	double dp;
	
	public SyncDriveData() {}
	
	public SyncDriveData(IDriveState state, IPlayerStats stats) {
		this.inDrive = state.getInDrive();
		this.driveName = state.getActiveDriveName();
		this.antiPoints = state.getAntiPoints();
		this.valorLevel = state.getDriveLevel(Strings.Form_Valor);
		this.wisdomLevel = state.getDriveLevel(Strings.Form_Wisdom);
		this.limitLevel = state.getDriveLevel(Strings.Form_Limit);
		this.masterLevel = state.getDriveLevel(Strings.Form_Master);
		this.finalLevel = state.getDriveLevel(Strings.Form_Final);
		
		this.valorExp = state.getDriveExp(Strings.Form_Valor);
		this.wisdomExp = state.getDriveExp(Strings.Form_Wisdom);
		this.limitExp = state.getDriveExp(Strings.Form_Limit);
		this.masterExp = state.getDriveExp(Strings.Form_Master);
		this.finalExp = state.getDriveExp(Strings.Form_Final);

		this.dp = stats.getDP();
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.inDrive = buffer.readBoolean();
		this.driveName = buffer.readStringFromBuffer(100);
		this.antiPoints = buffer.readInt();
		this.valorLevel = buffer.readInt();
		this.wisdomLevel = buffer.readInt();
		this.limitLevel = buffer.readInt();
		this.masterLevel = buffer.readInt();
		this.finalLevel = buffer.readInt();
		
		this.valorExp = buffer.readInt();
		this.wisdomExp = buffer.readInt();
		this.limitExp = buffer.readInt();
		this.masterExp = buffer.readInt();
		this.finalExp = buffer.readInt();
		
		this.dp = buffer.readDouble();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(this.inDrive);
		buffer.writeString(this.driveName);
		buffer.writeInt(this.antiPoints);
		buffer.writeInt(this.valorLevel);
		buffer.writeInt(this.wisdomLevel);
		buffer.writeInt(this.limitLevel);
		buffer.writeInt(this.masterLevel);
		buffer.writeInt(this.finalLevel);
		
		buffer.writeInt(this.valorExp);
		buffer.writeInt(this.wisdomExp);
		buffer.writeInt(this.limitExp);
		buffer.writeInt(this.masterExp);
		buffer.writeInt(this.finalExp);
		
		buffer.writeDouble(this.dp);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		final IDriveState state = player.getCapability(ModCapabilities.DRIVE_STATE, null);
		final IPlayerStats stats = player.getCapability(ModCapabilities.PLAYER_STATS, null);
		state.setInDrive(inDrive);
		state.setActiveDriveName(driveName);
		state.setAntiPoints(antiPoints);
		state.setDriveLevel(Strings.Form_Valor, valorLevel);
		state.setDriveLevel(Strings.Form_Wisdom, wisdomLevel);
		state.setDriveLevel(Strings.Form_Limit, limitLevel);
		state.setDriveLevel(Strings.Form_Master, masterLevel);
		state.setDriveLevel(Strings.Form_Final, finalLevel);
		
		state.setDriveExp(Strings.Form_Valor, valorExp);
		state.setDriveExp(Strings.Form_Wisdom, wisdomExp);
		state.setDriveExp(Strings.Form_Limit, limitExp);
		state.setDriveExp(Strings.Form_Master, masterExp);
		state.setDriveExp(Strings.Form_Final, finalExp);
		
		stats.setDP(dp);
	}

}
