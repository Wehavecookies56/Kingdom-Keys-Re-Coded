package wehavecookies56.kk.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.PacketMunny;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayer";

	private final EntityPlayer player;

	public int munny;

	public ExtendedPlayer(EntityPlayer player){
		this.player = player;
		this.munny = 0;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("Munny", this.munny);

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		this.munny = properties.getInteger("Munny");

		System.out.println("[TUT PROPS] Munny from NBT: " + this.munny);
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public void addMunny(int amount){
		this.munny += amount;
		this.sync();
	}

	public void removeMunny(int amount){
		this.munny -= amount;
		this.sync();
	}

	public int getMunny(){
		return this.munny;
	}
	

	public final void sync(){
		PacketMunny packetMunny = new PacketMunny(this.munny);
         	KingdomKeys.kkPacketHandler.sendToServer(packetMunny);
		

		if(!player.worldObj.isRemote){
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			KingdomKeys.kkPacketHandler.sendTo(packetMunny, player1);
		}
	}
	
	private static String getSaveKey (EntityPlayer player){
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}
	
	public static void saveProxyData(EntityPlayer player){
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData (SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData (EntityPlayer player){
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound SavedData = CommonProxy.getEntityData(getSaveKey(player));

		if(SavedData != null) {
			playerData.loadNBTData(SavedData);
		}
		playerData.sync();
	}
	
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player){
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
 

}
