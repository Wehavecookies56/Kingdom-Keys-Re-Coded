package uk.co.wehavecookies56.kk.api.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class AbilityEvent {

    public static class Equip extends Event {

        EntityPlayer player;
        Ability ability;

        @Override
        public boolean isCancelable() {
            return true;
        }

        public Equip(EntityPlayer player, Ability ability) {
            this.player = player;
            this.ability = ability;
        }

        public EntityPlayer getPlayer() {
            return player;
        }

        public Ability getAbility() {
            return ability;
        }

    }

    public static class Unequip extends Event {

        EntityPlayer player;
        Ability ability;

        @Override
        public boolean isCancelable() {
            return true;
        }

        public Unequip(EntityPlayer player, Ability ability) {
            this.player = player;
            this.ability = ability;
        }

        public EntityPlayer getPlayer() {
            return player;
        }

        public Ability getAbility() {
            return ability;
        }
    }

    public static class Update extends Event {

        EntityPlayer player;
        Ability ability;

        @Override
        public boolean isCancelable() {
            return true;
        }

        public Update(EntityPlayer player, Ability ability) {
            this.player = player;
            this.ability = ability;
        }

        public EntityPlayer getPlayer() {
            return player;
        }

        public Ability getAbility() {
            return ability;
        }
    }

}
