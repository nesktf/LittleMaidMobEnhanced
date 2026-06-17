package littleMaidMobX.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

import littleMaidMobX.entity.EntityLittleMaid;
import littleMaidMobX.model.caps.IModelCaps;

public class RenderLittleMaid extends RenderModelMulti {

    // Feilds

    // Method
    public RenderLittleMaid(float f) {
        super(f);
    }

    @Override
    public void setModelValues(EntityLivingBase par1EntityLiving, double par2, double par4, double par6, float par8,
        float par9, IModelCaps pEntityCaps) {

        EntityLittleMaid lmaid = (EntityLittleMaid) par1EntityLiving;
        super.setModelValues(par1EntityLiving, par2, par4, par6, par8, par9, pEntityCaps);

        // modelMain.setRender(this);
        // modelMain.setEntityCaps(pEntityCaps);
        // modelMain.showAllParts();
        // modelMain.isAlphablend = true;
        // modelFATT.isAlphablend = true;

        modelMain.setCapsValue(IModelCaps.caps_heldItemLeft, (Integer) 0);
        modelMain.setCapsValue(IModelCaps.caps_heldItemRight, (Integer) 0);
        // modelMain.setCapsValue(IModelCaps.caps_onGround, renderSwingProgress(lmaid, par9));
        modelMain.setCapsValue(
            IModelCaps.caps_onGround,
            lmaid.mstatSwingStatus[0].getSwingProgress(par9),
            lmaid.mstatSwingStatus[1].getSwingProgress(par9));
        modelMain.setCapsValue(IModelCaps.caps_isRiding, lmaid.isRiding());
        modelMain.setCapsValue(IModelCaps.caps_isSneak, lmaid.isSneaking());
        modelMain.setCapsValue(IModelCaps.caps_aimedBow, lmaid.isAimebow());
        modelMain.setCapsValue(IModelCaps.caps_isWait, lmaid.isMaidWait());
        modelMain.setCapsValue(IModelCaps.caps_isChild, lmaid.isChild());
        modelMain.setCapsValue(IModelCaps.caps_entityIdFactor, lmaid.entityIdFactor);
        modelMain.setCapsValue(IModelCaps.caps_ticksExisted, lmaid.ticksExisted);
        modelMain.setCapsValue(IModelCaps.caps_dominantArm, lmaid.maidDominantArm);

        // plittleMaid.textureModel0.isChild = plittleMaid.textureModel1.isChild = plittleMaid.textureModel2.isChild =
        // plittleMaid.isChild();
    }

    protected void renderString(EntityLittleMaid plittleMaid, double px, double py, double pz, float f, float f1) {

        if (plittleMaid.mstatgotcha != null && plittleMaid.mstatgotcha instanceof EntityLivingBase) {
            EntityLivingBase lel = (EntityLivingBase) plittleMaid.mstatgotcha;
            py -= 0.5D;
            Tessellator tessellator = Tessellator.instance;
            float f9 = ((lel.prevRotationYaw + (lel.rotationYaw - lel.prevRotationYaw) * f1 * 0.5F) * 3.141593F) / 180F;
            float f3 = ((lel.prevRotationPitch + (lel.rotationPitch - lel.prevRotationPitch) * f1 * 0.5F) * 3.141593F)
                / 180F;
            double d3 = MathHelper.sin(f9);
            double d5 = MathHelper.cos(f9);
            float f11 = lel.getSwingProgress(f1);
            float f12 = MathHelper.sin(MathHelper.sqrt_float(f11) * 3.141593F);
            Vec3 vec3d = Vec3.createVectorHelper(-0.5D, 0.029999999999999999D, 0.55D);
            vec3d.rotateAroundX(
                (-(lel.prevRotationPitch + (lel.rotationPitch - lel.prevRotationPitch) * f1) * 3.141593F) / 180F);
            vec3d.rotateAroundY(
                (-(lel.prevRotationYaw + (lel.rotationYaw - lel.prevRotationYaw) * f1) * 3.141593F) / 180F);
            vec3d.rotateAroundY(f12 * 0.5F);
            vec3d.rotateAroundX(-f12 * 0.7F);
            double d7 = lel.prevPosX + (lel.posX - lel.prevPosX) * (double) f1 + vec3d.xCoord;
            double d8 = lel.prevPosY + (lel.posY - lel.prevPosY) * (double) f1 + vec3d.yCoord;
            double d9 = lel.prevPosZ + (lel.posZ - lel.prevPosZ) * (double) f1 + vec3d.zCoord;
            if (renderManager.options.thirdPersonView > 0) {
                float f4 = ((lel.prevRenderYawOffset + (lel.renderYawOffset - lel.prevRenderYawOffset) * f1)
                    * 3.141593F) / 180F;
                double d11 = MathHelper.sin(f4);
                double d13 = MathHelper.cos(f4);
                d7 = (lel.prevPosX + (lel.posX - lel.prevPosX) * (double) f1) - d13 * 0.34999999999999998D
                    - d11 * 0.54999999999999998D;
                d8 = (lel.prevPosY + (lel.posY - lel.prevPosY) * (double) f1) - 0.45000000000000001D;
                d9 = ((lel.prevPosZ + (lel.posZ - lel.prevPosZ) * (double) f1) - d11 * 0.34999999999999998D)
                    + d13 * 0.54999999999999998D;
            }
            double d10 = plittleMaid.prevPosX + (plittleMaid.posX - plittleMaid.prevPosX) * (double) f1;
            double d12 = plittleMaid.prevPosY + (plittleMaid.posY - plittleMaid.prevPosY) * (double) f1 + 0.25D - 0.5D;// +
                                                                                                                       // 0.75D;
            double d14 = plittleMaid.prevPosZ + (plittleMaid.posZ - plittleMaid.prevPosZ) * (double) f1;
            double d15 = (float) (d7 - d10);
            double d16 = (float) (d8 - d12);
            double d17 = (float) (d9 - d14);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(0);
            int i = 16;
            for (int j = 0; j <= i; j++) {
                float f5 = (float) j / (float) i;
                tessellator.addVertex(
                    px + d15 * (double) f5,
                    py + d16 * (double) (f5 * f5 + f5) * 0.5D
                        + (double) (((float) i - (float) j) / ((float) i * 0.75F) + 0.125F),
                    pz + d17 * (double) f5);
            }

            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }

    @Override
    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        EntityLittleMaid lmm = (EntityLittleMaid) par1EntityLiving;

        fcaps = lmm.maidCaps;
        // doRenderLitlleMaid(lmm, par2, par4, par6, par8, par9);
        renderModelMulti(lmm, par2, par4, par6, par8, par9, fcaps);
        renderString(lmm, par2, par4, par6, par8, par9);

        // func_110827_b(lmm, par2, par4 - modelMain.model.getLeashOffset(lmm.maidCaps), par6, par8, par9);
    }

    @Override
    protected void renderModel(EntityLivingBase par1EntityLiving, float par2, float par3, float par4, float par5,
        float par6, float par7) {
        if (!par1EntityLiving.isInvisible()) {
            modelMain.setArmorRendering(true);
        } else {
            modelMain.setArmorRendering(false);
        }

        mainModel.render(par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

    @Override
    protected void passSpecialRender(EntityLivingBase par1EntityLiving, double par2, double par4, double par6) {
        super.passSpecialRender(par1EntityLiving, par2, par4, par6);

        EntityLittleMaid llmm = (EntityLittleMaid) par1EntityLiving;

        for (int li = 0; li < llmm.maidEntityModeList.size(); li++) {
            llmm.maidEntityModeList.get(li)
                .showSpecial(this, par2, par4, par6);
        }
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase par1EntityLiving, float par2, float par3) {
        return ((EntityLittleMaid) par1EntityLiving).colorMultiplier(par2, par3);
    }

    public void renderLivingLabel(Entity p_147906_1_, String p_147906_2_, double p_147906_3_, double p_147906_5_,
        double p_147906_7_, int p_147906_9_) {
        super.func_147906_a(p_147906_1_, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
    }

}
