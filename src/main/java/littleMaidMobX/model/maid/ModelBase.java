package littleMaidMobX.model.maid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.render.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.MathHelper;

public abstract class ModelBase {
	
	public static final float PI = (float)Math.PI;

	public Render render;

	
	public int textureWidth = 64;
	public int textureHeight = 32;
	public float onGrounds[] = new float[] {0.0F, 0.0F};
	public int dominantArm = 0;
	public boolean isRiding = false;
	public boolean isChild = true;
	public List<ModelRenderer> boxList = new ArrayList<ModelRenderer>();
	private Map<String, TextureOffset> modelTextureMap = new HashMap<String, TextureOffset>();

	public float modelSize = 0F;


	

	public void render(IModelCaps pEntityCaps, float par2, float par3,
			float ticksExisted, float pheadYaw, float pheadPitch, float par7, boolean pIsRender) {
	}

	public void setRotationAngles(float par1, float par2, float pTicksExisted,
			float pHeadYaw, float pHeadPitch, float par6, IModelCaps pEntityCaps) {
	}

	public void setLivingAnimations(IModelCaps pEntityCaps, float par2, float par3, float pRenderPartialTicks) {
	}

	public ModelRenderer getRandomModelBox(Random par1Random) {
		
		int li = par1Random.nextInt(this.boxList.size());
		ModelRenderer lmr = (ModelRenderer)this.boxList.get(li);
		for (int lj = 0; lj < boxList.size(); lj++) {
			if (!lmr.cubeList.isEmpty()) {
				break;
			}
			
			if (++li >= boxList.size()) {
				li = 0;
			}
			lmr = (ModelRenderer)this.boxList.get(li);
		}
		return lmr;
	}

	protected void setTextureOffset(String par1Str, int par2, int par3) {
		modelTextureMap.put(par1Str, new TextureOffset(par2, par3));
	}

	
	public TextureOffset getTextureOffset(String par1Str) {
		
		return modelTextureMap.get(par1Str);
	}


	

	public static final float mh_sin(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.sin(f);
	}

	public static final float mh_cos(float f) {
		f = f % 6.283185307179586F;
		f = (f < 0F) ? 360 + f : f;
		return MathHelper.cos(f);
	}

	public static final float mh_sqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	public static final float mh_sqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	public static final int mh_floor_float(float f) {
		return MathHelper.floor_float(f);
	}

	public static final int mh_floor_double(double d) {
		return MathHelper.floor_double(d);
	}

	public static final long mh_floor_double_long(double d) {
		return MathHelper.floor_double_long(d);
	}

	public static final float mh_abs(float f) {
		return MathHelper.abs(f);
	}

	public static final double mh_abs_max(double d, double d1) {
		return MathHelper.abs_max(d, d1);
	}

	public static final int mh_bucketInt(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	public static final boolean mh_stringNullOrLengthZero(String s) {
		return MathHelper.stringNullOrLengthZero(s);
	}

	public static final int mh_getRandomIntegerInRange(Random random, int i, int j) {
		return MathHelper.getRandomIntegerInRange(random, i, j);
	}

	public abstract float[] getArmorModelsSize();
}
