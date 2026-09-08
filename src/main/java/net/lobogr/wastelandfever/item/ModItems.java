package net.lobogr.wastelandfever.item;

import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.item.custom.PowerArmorFrameItem;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WastelandFever.MODID);

    public static final Supplier<Item> POWER_ARMOR_FRAME_ITEM = ITEMS.registerItem(
            "power_armor_frame_item",
            PowerArmorFrameItem::new,
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)
    );
    public static final Supplier<Item> FUSION_CORE = ITEMS.registerItem(
            "fusion_core",
            Item::new,
            new Item.Properties().rarity(Rarity.RARE).stacksTo(1)
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
