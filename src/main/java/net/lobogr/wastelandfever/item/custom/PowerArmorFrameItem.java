package net.lobogr.wastelandfever.item.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class PowerArmorFrameItem extends Item {
    public  PowerArmorFrameItem(Properties properties){
        super(properties);

    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if(!level.isClientSide() && level instanceof ServerLevel serverLevel){
            BlockPos clickpos = context.getClickedPos();
            Direction face = context.getClickedFace();

            BlockPos spawnpos = clickpos.relative(face);

            Cow entidad = EntityType.COW.create(serverLevel);

            if(entidad != null){
                entidad.moveTo(spawnpos.getX() + 0.5, spawnpos.getY(), spawnpos.getZ() + 0.5, 0.0F, 0.0F);

                serverLevel.addFreshEntity(entidad);

                if(!context.getPlayer().isCreative()){
                    context.getItemInHand().shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }


       return  InteractionResult.PASS;
    }
}
