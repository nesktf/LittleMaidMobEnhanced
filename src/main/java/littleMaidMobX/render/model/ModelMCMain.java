package littleMaidMobX.render.model;

import java.util.Map;

import littleMaidMobX.util.helper.ClientHelper;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.maid.ModelMultiBase;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class ModelMCMain extends ModelMCBase {

	public ModelMultiBase model;
	public ResourceLocation[] textures;
	public static final ResourceLocation[] blanks = new ResourceLocation[0];


	public ModelMCMain(RendererLivingEntity pRender) {
		rendererLivingEntity = pRender;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4) {
		if (model != null) {
			try
			{
				model.setLivingAnimations(entityCaps, par2, par3, par4);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		isAlphablend = true;
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (model == null) {
			isAlphablend = false;
			return;
		}
		if (isAlphablend) {
			if (isModelAlphablend) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		if (textures.length > 2 && textures[2] != null) {
			
			model.setRotationAngles(par2, par3, par4, par5, par6, par7, entityCaps);
			// Face
			
			ClientHelper.setTexture(textures[2]);
			model.setCapsValue(caps_renderFace, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			// Body
			ClientHelper.setTexture(textures[0]);
			model.setCapsValue(caps_renderBody, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		} else {
			
			if (textures.length > 0 && textures[0] != null) {
				ClientHelper.setTexture(textures[0]);
//				System.out.println(textures[0]);
			}
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		}
		isAlphablend = false;
		if (textures.length > 1 && textures[1] != null && renderCount == 0) {
			
			ClientHelper.setTexture(textures[1]);
			float var4 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDepthFunc(GL11.GL_LEQUAL);
			
			ClientHelper.setLightmapTextureCoords(0x00f000f0);//61680
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, true);
			
			ClientHelper.setLightmapTextureCoords(lighting);
			
//			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
		}
//		textures = blanks;
		renderCount++;
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		return model == null ? null : model.getTextureOffset(par1Str);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		if (model != null) {
			model.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}


	

	@Override
	public void renderItems(EntityLivingBase pEntity, Render pRender) {
		if (model != null) {
			model.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(IModelCaps iModelCaps, int pParts) {
		if (model != null) {
			model.showArmorParts(null, pParts, 0);
		}
	}

	
	@Override
	public void setEntityCaps(IModelCaps pEntityCaps) {
		entityCaps = pEntityCaps;
		if (capsLink != null) {
			capsLink.setEntityCaps(pEntityCaps);
		}
	}

	@Override
	public void setRender(Render pRender) {
		if (model != null) {
			model.render = pRender;
		}
	}

	@Override
	public void setArmorRendering(boolean pFlag) {
		isRendering = pFlag;
	}


	

	@Override
	public Map<String, Integer> getModelCaps() {
		return model == null ? null : model.getModelCaps();
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return model == null ? null : model.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		if (capsLink != null) {
			capsLink.setCapsValue(pIndex, pArg);
		}
		if (model != null) {
			model.setCapsValue(pIndex, pArg);
		}
		return false;
	}

	@Override
	public void showAllParts(IModelCaps iModelCaps) {
		if (model != null) {
			model.showAllParts(iModelCaps);
		}
	}


}
