package net.lobogr.wastelandfever.event;

import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.entity.ModEntities;
import net.lobogr.wastelandfever.entity.client.PowerArmorModel;
import net.lobogr.wastelandfever.entity.custom.PowerArmorFrame;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = WastelandFever.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(PowerArmorModel.LAYER_LOCATION, PowerArmorModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.POWER_ARMOR_FRAME.get(), PowerArmorFrame.createAttributes().build());
    }
}
