package uk.co.wehavecookies56.kk.common.item.base;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumDoorHalf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.AttackEntity;

public class ItemKeyblade extends ItemSword {
    double magic, strength;
    public String description;
    double speed = 1.0;

    //TODO Set attack speed

    public ItemKeyblade (double strength, double magic) {
        super(EnumHelper.addToolMaterial("KEYBLADE", -4, -1, 0, 0, 20));
        this.magic = magic;
        this.strength = strength;
        setMaxStackSize(1);
        setCreativeTab(ModItems.tabKingdomKeys);
    }
    public double getStrength() {
        return this.strength;
    }

    public double getMagic() {
        return this.magic;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.MAINHAND) {
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, getSpeed());
        }

        return modifiers;
    }

    private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) {
        // Get the modifiers for the specified attribute
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

        // Find the modifier with the specified ID, if any
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

        if (modifierOptional.isPresent()) { // If it exists,
            final AttributeModifier modifier = modifierOptional.get();
            modifiers.remove(modifier); // Remove it
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(player.isSneaking()) {

        } else {
            if (world.isRemote){
                RayTraceResult rtr = Minecraft.getMinecraft().objectMouseOver;
                if (player.getHeldItem(EnumHand.OFF_HAND) != ItemStack.EMPTY && player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade) {
                    if(player.swingProgress <= 0)
                        player.swingArm(EnumHand.OFF_HAND);
                    if (rtr.entityHit != null) {
                        PacketDispatcher.sendToServer(new AttackEntity(rtr.entityHit.getEntityId()));
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getActiveItemStack());
                    }
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getActiveItemStack());
                }

            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (player.getActiveItemStack().getItem() == ModItems.WoodenKeyblade || player.getActiveItemStack().getItem() == ModItems.WoodenStick || player.getActiveItemStack().getItem() == ModItems.DreamSword)
            return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);

        if (world.getBlockState(pos).getBlock() instanceof BlockDoor) {
            SoundEvent sound;
            PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
            if ((!STATS.getRecharge()) || player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
            {
                if (world.getBlockState(pos).getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER)
                {
                    world.setBlockState(pos.down(), world.getBlockState(pos.down()).withProperty(BlockDoor.OPEN, !world.getBlockState(pos.down()).getValue(BlockDoor.OPEN)));
                    sound = world.getBlockState(pos.down()).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
                    world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    return EnumActionResult.SUCCESS;
                } else {
                    world.setBlockState(pos, world.getBlockState(pos).withProperty(BlockDoor.OPEN, !world.getBlockState(pos).getValue(BlockDoor.OPEN)));
                    sound = world.getBlockState(pos).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
                    world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

}
