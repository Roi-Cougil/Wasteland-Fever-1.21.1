package net.lobogr.wastelandfever.entity.custom;

import net.lobogr.wastelandfever.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;



public class PowerArmorFrame extends Mob {
    public PowerArmorFrame(EntityType<? extends Mob> type, Level level) {
        super(type, level);
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
                if(player.isCreative()){
                    ItemStack itemDrop = new ItemStack((Holder<Item>) ModItems.POWER_ARMOR_FRAME_ITEM, 1);
                    this.spawnAtLocation(itemDrop);

                }
                this.discard();
            }
            return  InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.mobInteract(player, hand);
    }
}
