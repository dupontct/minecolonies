// Made with Blockbench 4.0.0-beta.0
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.minecolonies.coremod.client.model;

import com.minecolonies.api.client.render.modeltype.CitizenModel;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelEntityStudentMale extends CitizenModel<AbstractEntityCitizen>
{

    public ModelEntityStudentMale(final ModelPart part)
    {
        super(part);
        hat.visible = false;
    }

    public static LayerDefinition createMesh()
    {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head =
          partdefinition.addOrReplaceChild("head",
            CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
              .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
              .texOffs(68, 2).addBox(-4.0F, -6.0F, -4.4F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.2F)),
            PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body =
          partdefinition.addOrReplaceChild("body",
            CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F)),
            PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Belly =
          body.addOrReplaceChild("Belly",
            CubeListBuilder.create().texOffs(56, 38).mirror().addBox(0.0F, 0.0F, 1.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
              .texOffs(56, 36).mirror().addBox(1.0F, -1.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
            PartPose.offset(-3.0F, 6.0F, -4.0F));

        PartDefinition right_arm =
          partdefinition.addOrReplaceChild("right_arm",
            CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F))
              .texOffs(64, 37).mirror().addBox(-2.3F, 7.5F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
            PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition left_arm =
          partdefinition.addOrReplaceChild("left_arm",
            CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
            PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition rightFoldedArm =
          body.addOrReplaceChild("rightFoldedArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition rightShoulder =
          rightFoldedArm.addOrReplaceChild("rightShoulder",
            CubeListBuilder.create().texOffs(56, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(72, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition rightForeArm =
          rightFoldedArm.addOrReplaceChild("rightForeArm",
            CubeListBuilder.create().texOffs(88, 16).addBox(-2.01F, -0.6F, -2.3F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(88, 24).addBox(-2.01F, -0.6F, -2.3F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.251F)),
            PartPose.offsetAndRotation(-1.0F, 2.5F, -3.8F, -1.0472F, 0.0F, 0.0F));

        PartDefinition leftFoldedArm =
          body.addOrReplaceChild("leftFoldedArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition leftShoulder = leftFoldedArm.addOrReplaceChild("leftShoulder",
          CubeListBuilder.create().texOffs(56, 26).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
            .texOffs(72, 26).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)),
          PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition leftForeArm = leftFoldedArm.addOrReplaceChild("leftForeArm",
          CubeListBuilder.create().texOffs(88, 32).mirror().addBox(-4.0F, -0.6F, -2.3F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
            .texOffs(88, 40).mirror().addBox(-4.0F, -0.6F, -2.3F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.252F)).mirror(false),
          PartPose.offsetAndRotation(-1.0F, 2.5F, -3.8F, -1.0472F, 0.0F, 0.0F));

        PartDefinition right_leg =
          partdefinition.addOrReplaceChild("right_leg",
            CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(0, 32).addBox(-2.051F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)),
            PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition left_leg =
          partdefinition.addOrReplaceChild("left_leg",
            CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
              .texOffs(0, 48).addBox(-1.94F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.591F)),
            PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }
}
