package wehavecookies56.kk.network;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import wehavecookies56.kk.entities.ExtendedPlayer;

public class CommonProxy implements IGuiHandler {

	public void init()
	{

	}

	public EntityPlayer getPlayerEntity(MessageContext ctx){
		return ctx.getServerHandler().playerEntity;
	}
	
	private  static  final  Map < String ,  NBTTagCompound > extendedEntityData =  new  HashMap < String ,  NBTTagCompound > ();

	
	public  static  void storeEntityData ( String name , NBTTagCompound compound )  {
		extendedEntityData.put(name, compound);
	}

	public  static  NBTTagCompound getEntityData ( String name )  {
		return extendedEntityData.remove(name);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

}
