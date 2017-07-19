package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class PotionConsume extends AbstractMessage.AbstractServerMessage<PotionConsume> {

    public PotionConsume () {}

    String potion;

    public PotionConsume (String potion) {
        this.potion = potion;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        potion = buffer.readString(100);
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(potion);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        switch (potion) {
            case Strings.Potion:
                ((ItemKKPotion) ModItems.Potion).getPotionEffect(player);
                //player.heal(player.getCapability(ModCapabilities.PLAYER_STATS, null).getHP()/3);
                break;
            case Strings.HiPotion:
                ((ItemKKPotion) ModItems.HiPotion).getPotionEffect(player);
                //player.heal(player.getCapability(ModCapabilities.PLAYER_STATS, null).getHP()/2);
                break;
            case Strings.MegaPotion:
                ((ItemKKPotion) ModItems.MegaPotion).getPotionEffect(player);
                //player.heal(player.getCapability(ModCapabilities.PLAYER_STATS, null).getHP());
                break;
            case Strings.Ether:
                ((ItemKKPotion) ModItems.Ether).getPotionEffect(player);
                //player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 3);
                break;
            case Strings.MegaEther:
                ((ItemKKPotion) ModItems.MegaEther).getPotionEffect(player);
            case Strings.Elixir:
                ((ItemKKPotion) ModItems.Elixir).getPotionEffect(player);
                //player.heal(player.getCapability(ModCapabilities.PLAYER_STATS, null).getHP()/3);
                 //player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 3);
                break;
            case Strings.Megalixir:
                ((ItemKKPotion) ModItems.Megalixir).getPotionEffect(player);
                break;
            case Strings.DriveRecovery:
                ((ItemKKPotion) ModItems.DriveRecovery).getPotionEffect(player);
                break;
            case Strings.HighDriveRecovery:
                ((ItemKKPotion) ModItems.HighDriveRecovery).getPotionEffect(player);
                break;
            case Strings.Panacea:
                ((ItemKKPotion) ModItems.Panacaea).getPotionEffect(player);
                break;
            default:
                break;
        }
        //PacketDispatcher.sendTo(new Syn(), player);
    }
}
