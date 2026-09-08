package net.lobogr.wastelandfever.entity;

import net.lobogr.wastelandfever.WastelandFever;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, WastelandFever.MODID);


    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
