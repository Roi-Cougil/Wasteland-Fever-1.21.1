package net.lobogr.wastelandfever.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lobogr.wastelandfever.WastelandFever;
import net.lobogr.wastelandfever.entity.custom.PowerArmorFrame;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PowerArmorModel<T extends PowerArmorFrame> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WastelandFever.MODID, "power_armor_frame"), "main");
    private final ModelPart Root;
    private final ModelPart Body;
    private final ModelPart head;
    private final ModelPart Left_Arm;
    private final ModelPart Open_Left_Arm;
    private final ModelPart Right_Arm;
    private final ModelPart Open_Right_Arm;
    private final ModelPart Open_Body;
    private final ModelPart crank;
    private final ModelPart shoulders;
    private final ModelPart right_leg;
    private final ModelPart Open_right_leg;
    private final ModelPart left_leg;
    private final ModelPart Open_left_leg;

    public PowerArmorModel(ModelPart root) {
        this.Root = root.getChild("Root");
        this.Body = this.Root.getChild("Body");
        this.head = this.Body.getChild("head");
        this.Left_Arm = this.Body.getChild("Left_Arm");
        this.Open_Left_Arm = this.Left_Arm.getChild("Open_Left_Arm");
        this.Right_Arm = this.Body.getChild("Right_Arm");
        this.Open_Right_Arm = this.Right_Arm.getChild("Open_Right_Arm");
        this.Open_Body = this.Body.getChild("Open_Body");
        this.crank = this.Open_Body.getChild("crank");
        this.shoulders = this.Body.getChild("shoulders");
        this.right_leg = this.Root.getChild("right_leg");
        this.Open_right_leg = this.right_leg.getChild("Open_right_leg");
        this.left_leg = this.Root.getChild("left_leg");
        this.Open_left_leg = this.left_leg.getChild("Open_left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 36).addBox(-5.0F, -15.0F, -2.5F, 10.0F, 15.0F, 3.0F, new CubeDeformation(0.5F))
                .texOffs(36, 0).addBox(-5.0F, -15.0F, -2.5F, 10.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(56, 31).addBox(-5.0F, -15.0F, -3.5F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 61).addBox(-5.0F, -15.0F, -3.5F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -9.0F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-4.5F, -9.0F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition Left_Arm = Body.addOrReplaceChild("Left_Arm", CubeListBuilder.create().texOffs(80, 38).addBox(0.0F, 10.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(62, 61).addBox(0.0F, -2.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(66, 15).addBox(0.0F, -2.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(5.0F, -13.0F, 0.0F));

        PartDefinition Open_Left_Arm = Left_Arm.addOrReplaceChild("Open_Left_Arm", CubeListBuilder.create().texOffs(84, 69).addBox(-5.0F, -7.0F, 0.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 91).addBox(-5.0F, -7.0F, 1.0F, 5.0F, 12.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(5.0F, 5.0F, 0.5F));

        PartDefinition Right_Arm = Body.addOrReplaceChild("Right_Arm", CubeListBuilder.create().texOffs(82, 14).addBox(-5.0F, 10.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 65).addBox(-5.0F, -2.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, 71).addBox(-5.0F, -2.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(-5.0F, -13.0F, 0.0F));

        PartDefinition Open_Right_Arm = Right_Arm.addOrReplaceChild("Open_Right_Arm", CubeListBuilder.create().texOffs(0, 80).addBox(0.0F, -6.5F, 0.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 83).addBox(0.0F, -6.5F, 1.0F, 5.0F, 12.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(-5.0F, 4.5F, 0.5F));

        PartDefinition Open_Body = Body.addOrReplaceChild("Open_Body", CubeListBuilder.create().texOffs(56, 41).addBox(-5.0F, 9.0F, 0.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(74, 48).addBox(-5.0F, 9.0F, 0.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.5F))
                .texOffs(27, 50).addBox(-5.0F, -1.0F, 2.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(55, 93).addBox(-5.0F, -1.0F, 2.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.5F))
                .texOffs(50, 49).addBox(-5.0F, -1.0F, 0.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.5F));

        PartDefinition crank = Open_Body.addOrReplaceChild("crank", CubeListBuilder.create().texOffs(36, 31).addBox(-2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(46, 31).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 3.0F));

        PartDefinition shoulders = Body.addOrReplaceChild("shoulders", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -3.5F));

        PartDefinition cube_r1 = shoulders.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 36).addBox(-5.0F, -5.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition cube_r2 = shoulders.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 18).addBox(-5.0F, -5.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 4.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition right_leg = Root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(62, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(32, 76).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.5F))
                .texOffs(78, 30).addBox(-2.5F, 12.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 84).addBox(-2.5F, 12.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.5F, -15.0F, 0.0F));

        PartDefinition Open_right_leg = right_leg.addOrReplaceChild("Open_right_leg", CubeListBuilder.create().texOffs(78, 55).addBox(0.0F, -6.0F, 0.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(14, 86).addBox(0.0F, -6.0F, 1.0F, 5.0F, 12.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.5F, 6.0F, 0.5F));

        PartDefinition left_leg = Root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(46, 61).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 76).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.5F))
                .texOffs(64, 76).addBox(-2.5F, 12.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(82, 22).addBox(-2.5F, 12.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(2.5F, -15.0F, 0.0F));

        PartDefinition Open_left_leg = left_leg.addOrReplaceChild("Open_left_leg", CubeListBuilder.create().texOffs(78, 0).addBox(-5.0F, -6.0F, 0.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(26, 91).addBox(-5.0F, -6.0F, 1.0F, 5.0F, 12.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(2.5F, 6.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void setupAnim(PowerArmorFrame entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

    }
    private void applyHeadRotation(float headYaw, float headPitch){
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.yRot = headYaw * ((float)Math.PI / 180f );
        this.head.xRot = headPitch * ((float)Math.PI / 180f );
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Root;

    }

}
