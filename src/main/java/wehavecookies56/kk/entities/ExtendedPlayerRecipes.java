package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.util.Constants;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayerRecipes;
import wehavecookies56.kk.recipes.Recipe;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.LogHelper;

public class ExtendedPlayerRecipes implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "KKExtendedPlayerRecipes";

	private final EntityPlayer player;

	public ExtendedPlayerRecipes(EntityPlayer player) {
		this.player = player;
	}

	public List<String> knownRecipes = new ArrayList<String>();

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		NBTTagList tagList = new NBTTagList();
		for (int i = 0; i < knownRecipes.size(); i++){
			String s = knownRecipes.get(i);
			if(s != null){
				NBTTagCompound recipes = new NBTTagCompound();
				recipes.setString("Recipes" + i, s);
				tagList.appendTag(recipes);
			}

		}
		properties.setTag("RecipeList", tagList);

		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		NBTTagList tagList = properties.getTagList("RecipeList", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound recipes = tagList.getCompoundTagAt(i);
			if(!RecipeRegistry.isRecipeKnown(player, recipes.getString("Recipes" + i))){
				knownRecipes.add(i, recipes.getString("Recipes" + i));
				LogHelper.info("Loaded known recipe: " + recipes.getString("Recipes" + i) + " " + i);
			}

		}

	}

	@Override
	public void init(Entity entity, World world) {}

	public void learnRecipe(Recipe recipe){
		knownRecipes.add(recipe.getName());
		if(player instanceof EntityPlayerMP)
			this.sync();
	}

	public final void sync(){
		SyncExtendedPlayerRecipes packet = new SyncExtendedPlayerRecipes(player);
		if(player.worldObj.isRemote){
			PacketDispatcher.sendToServer(packet);
		}

		if(!player.worldObj.isRemote){
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendTo(packet, player1);
		}
	}

	private static String getSaveKey (EntityPlayer player){
		return player.getDisplayName() + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player){
		ExtendedPlayerRecipes playerData = ExtendedPlayerRecipes.get(player);
		NBTTagCompound SavedData = new NBTTagCompound();

		playerData.saveNBTData (SavedData);
		CommonProxy.storeEntityData(getSaveKey(player), SavedData);
	}

	public static void loadProxyData (EntityPlayer player){
		ExtendedPlayerRecipes playerData = ExtendedPlayerRecipes.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) {
			playerData.loadNBTData(savedData);
		}
		playerData.sync();
	}

	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerRecipes(player));
	}

	public static final ExtendedPlayerRecipes get(EntityPlayer player){
		return (ExtendedPlayerRecipes) player.getExtendedProperties(EXT_PROP_NAME);
	}

}
