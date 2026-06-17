package littleMaidMobX.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import littleMaidMobX.model.caps.IModelCaps;

public abstract class ModelMCBase extends ModelBase implements IModelCaps {

    public RendererLivingEntity rendererLivingEntity;

    public boolean isAlphablend;
    public boolean isModelAlphablend;
    public ModelMCBase capsLink;
    public int lighting;
    public IModelCaps entityCaps;
    public boolean isRendering;

    public int renderCount;

    // @Override
    // public ModelRenderer getRandomModelBox(Random par1Random) {
    // return modelArmorInner.getRandomModelBox(par1Random);
    // }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        renderCount++;
    }

    public abstract void renderItems(EntityLivingBase pEntity, Render pRender);

    public abstract void showArmorParts(IModelCaps iModelCaps, int pParts);

    public abstract void setEntityCaps(IModelCaps pModelCaps);

    public abstract void setRender(Render pRender);

    public abstract void setArmorRendering(boolean pFlag);

    public abstract void showAllParts(IModelCaps iModelCaps);
}
