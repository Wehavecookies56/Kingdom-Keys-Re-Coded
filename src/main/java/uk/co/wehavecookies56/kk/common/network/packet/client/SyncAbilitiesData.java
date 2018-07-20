package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.capability.TutorialsCapability;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncAbilitiesData extends AbstractMessage.AbstractClientMessage<SyncAbilitiesData> {

	private boolean useSonicBlade;

	public SyncAbilitiesData() {
	}

	public SyncAbilitiesData(AbilitiesCapability.IAbilities abilities) {
		this.useSonicBlade = abilities.getUseSonicBlade();
		// System.out.println(tutorials);

	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		useSonicBlade = buffer.readBoolean();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(useSonicBlade);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		final AbilitiesCapability.IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
		ABILITIES.setUseSonicBlade(useSonicBlade);
	}

}
