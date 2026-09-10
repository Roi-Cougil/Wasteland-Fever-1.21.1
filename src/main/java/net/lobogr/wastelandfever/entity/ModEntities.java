package net.lobogr.wastelandfever.entity;

import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.entity.custom.PowerArmorFrame;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, WastelandFever.MODID);

    public static final Supplier<EntityType<PowerArmorFrame>> POWER_ARMOR_FRAME = ENTITY_TYPE.register("power_armor_frame", () -> EntityType.Builder.of(PowerArmorFrame::new, MobCategory.CREATURE)
            .sized(0.6f,1.8f).build("power_armor_frame"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
