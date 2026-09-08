package net.lobogr.wastelandfever.item;

import net.lobogr.wastelandfever.WastelandFever;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;

import java.awt.event.InputEvent;
import java.util.function.Supplier;


public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WastelandFever.MODID);

    public static final Supplier<Item> POWER_ARMOR_FRAME_ITEM = ITEMS.registerItem(
            "power_armor_frame_item",
            Item::new,
            new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
