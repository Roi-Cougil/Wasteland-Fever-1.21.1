package net.lobogr.wastelandfever.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.entity.custom.PowerArmorFrame;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PowerArmorRenderer extends MobRenderer<PowerArmorFrame, PowerArmorModel<PowerArmorFrame>> {
    public PowerArmorRenderer(EntityRendererProvider.Context context){
        super(context, new PowerArmorModel<>(context.bakeLayer(PowerArmorModel.LAYER_LOCATION)), 0.25f);
    }
    @Override
    public ResourceLocation getTextureLocation(PowerArmorFrame entity){
        return ResourceLocation.fromNamespaceAndPath(WastelandFever.MODID, "textures/entity/powerarmorframe.png");
    }

    @Override
    public void render(PowerArmorFrame entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
