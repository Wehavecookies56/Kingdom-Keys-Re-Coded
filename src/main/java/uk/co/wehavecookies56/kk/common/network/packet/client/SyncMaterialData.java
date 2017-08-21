package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability.ISynthesisMaterial;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SyncMaterialData extends AbstractClientMessage<SyncMaterialData> {

    private Map<String, Integer> materials;

    public SyncMaterialData() {}

    public SyncMaterialData(ISynthesisMaterial material) {
        this.materials = material.getKnownMaterialsMap();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        materials = new HashMap<String, Integer>();
        while(buffer.isReadable()){
            materials.put(buffer.readString(100), buffer.readInt());
        }
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        Iterator<Entry<String, Integer>> it = materials.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
            buffer.writeString(pair.getKey().toString());
            buffer.writeInt(pair.getValue());
        }
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final ISynthesisMaterial material = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
        Iterator<Entry<String, Integer>> it = materials.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
            material.setMaterial(MaterialRegistry.get(pair.getKey().toString()), pair.getValue());
        }
    }


}
