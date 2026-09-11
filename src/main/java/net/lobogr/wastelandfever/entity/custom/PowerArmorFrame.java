package net.lobogr.wastelandfever.entity.custom;

import net.lobogr.wastelandfever.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;


public class PowerArmorFrame extends Mob {

    public PowerArmorFrame(EntityType<? extends Mob> type, Level level) {
        super(type, level);
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent){
        return null;
    }

    @Override
    protected void registerGoals() {
    }
    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public boolean isPushable(){
        return false;
    }

    @Override
    protected void doPush(net.minecraft.world.entity.Entity entity){

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand){
        if(player.isShiftKeyDown()){
            if(!this.level().isClientSide()){
                if(!player.isCreative()){
                    ItemStack itemDrop = new ItemStack((Holder<Item>) ModItems.POWER_ARMOR_FRAME_ITEM, 1);
                    this.spawnAtLocation(itemDrop);

                }
                this.discard();
            }
            return  InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        else{
            if(!this.level().isClientSide()){
                player.startRiding(this);
                return InteractionResult.SUCCESS;

            }

        }
        return super.mobInteract(player, hand);
    }
}
