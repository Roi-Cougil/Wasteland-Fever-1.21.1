package net.lobogr.wastelandfever.creativetabs;

import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab>  CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WastelandFever.MODID);

    public static final Supplier<CreativeModeTab> POWER_ARMORS = CREATIVE_MODE_TAB.register("power_armors", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + WastelandFever.MODID + ".power_armors"))
            .icon(() -> new ItemStack(ModItems.POWER_ARMOR_FRAME_ITEM.get()))
            .displayItems((itemDisplayParameters, output) ->{
                output.accept(ModItems.POWER_ARMOR_FRAME_ITEM.get());
            } )
            .build()
    );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
