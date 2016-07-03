package littleMaidMobX.render.model;

import static littleMaidMobX.model.caps.IModelCaps.caps_Actions;
import static littleMaidMobX.model.caps.IModelCaps.caps_Entity;
import static littleMaidMobX.model.caps.IModelCaps.caps_HeadMount;
import static littleMaidMobX.model.caps.IModelCaps.caps_Items;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.model.maid.ModelBase;
import littleMaidMobX.model.maid.ModelMultiBase;
import littleMaidMobX.wrapper.MinecraftClientWrapper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;


public class ModelRenderer {

	
	public float textureWidth;
	public float textureHeight;
	public int textureOffsetX;
	public int textureOffsetY;
	public float rotationPointX;
	public float rotationPointY;
	public float rotationPointZ;
	public float rotateAngleX;
	public float rotateAngleY;
	public float rotateAngleZ;
	protected boolean compiled;
	protected int displayList;
	public boolean mirror;
	public boolean showModel;
	public boolean isHidden;
	
	public boolean isRendering;
	public List<ModelBoxBase> cubeList;
	public List<ModelRenderer> childModels;
	public List<IRenderable> customShapes;
	public final String boxName;
	protected ModelBase baseModel;
	public ModelRenderer parent;
	public float offsetX;
	public float offsetY;
	public float offsetZ;
	public float scaleX;
	public float scaleY;
	public float scaleZ;
	
	
//	public static final float radFactor = 57.295779513082320876798154814105F;
	public static final float radFactor = 180F / (float)Math.PI;
//	public static final float degFactor = 0.01745329251994329576923690768489F;
	public static final float degFactor = (float)Math.PI / 180F;
	
	
	public int rotatePriority;
	public static final int RotXYZ = 0;
	public static final int RotXZY = 1;
	public static final int RotYXZ = 2;
	public static final int RotYZX = 3;
	public static final int RotZXY = 4;
	public static final int RotZYX = 5;
	
//	public static final int ModeEquip = 0x000;
//	public static final int ModeInventory = 0x001;
//	public static final int ModeItemStack = 0x002;
//	public static final int ModeParts = 0x010;
	protected ItemStack itemstack;
	
	public boolean adjust;
	public FloatBuffer matrix;
	public boolean isInvertX;

	private RenderBlocks renderBlocksIr = new RenderBlocks();



	public ModelRenderer(ModelBase pModelBase, String pName) {
		textureWidth = 64.0F;
		textureHeight = 32.0F;
		compiled = false;
		displayList = 0;
		mirror = false;
		showModel = true;
		isHidden = false;
		isRendering = true;
		cubeList = new ArrayList<ModelBoxBase>();
		customShapes = new ArrayList<IRenderable>(0);
		baseModel = pModelBase;
//		if (pModelBase instanceof MultiModel_NM && pModelBase.modelSize==0) {
//			System.out.println("our: "+pModelBase.boxList.size()+" = "+pName);
//		}
//		if (pName != null && pModelBase.modelSize == 0F) {
//			String s = "";
//			for (int i = 0; i < pModelBase.boxList.size(); i++) {
//				ModelRenderer r = pModelBase.boxList.get(i);
//				if (pName.equals(r.boxName)) {
//					if (s.isEmpty()) {
//						s = "While adding body part "+pName;
//					}
//					s+="\nAlready have body part "+r.boxName+" at index "+i;
//				}
//			}
//			if (!s.isEmpty()) {
//				System.err.println(s);
//				Thread.dumpStack();
//			}
//		}
//		if (pModelBase instanceof MultiModel_NM && pModelBase.modelSize==0) {
//			System.out.println("our: "+pModelBase.boxList.size()+" = "+pName);
//		}
		
		pModelBase.boxList.add(this);
		boxName = pName;
		setTextureSize(pModelBase.textureWidth, pModelBase.textureHeight);
		
		rotatePriority = RotXYZ;
		itemstack = null;
		adjust = true;
		matrix = BufferUtils.createFloatBuffer(16);
		isInvertX = false;
		
		scaleX = 1.0F;
		scaleY = 1.0F;
		scaleZ = 1.0F;
		
		parent = null;
		
//		renderBlocksIr.useInventoryTint = false;
	}

	public ModelRenderer(ModelBase pModelBase, int px, int py, String s) {
		this(pModelBase, s);
		setTextureOffset(px, py);
	}
	public ModelRenderer(ModelBase pModelBase, int px, int py) {
		this(pModelBase, null);
		setTextureOffset(px, py);
	}

	public ModelRenderer(ModelBase pModelBase) {
		this(pModelBase, (String)null);
	}

	public ModelRenderer(ModelBase pModelBase, int px, int py, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase, px, py);
		this.scaleX = pScaleX;
		this.scaleY = pScaleY;
		this.scaleZ = pScaleZ;
	}

	public ModelRenderer(ModelBase pModelBase, float pScaleX, float pScaleY, float pScaleZ) {
		this(pModelBase);
		this.scaleX = pScaleX;
		this.scaleY = pScaleY;
		this.scaleZ = pScaleZ;
	}

	

	public ModelRenderer(ModelBase pModelBase, int px, int py, ModelRenderer parent) {
		this(pModelBase, (String)null);
		setTextureOffset(px, py);
		parent.addChild(this);
	}

	public void addChild(ModelRenderer pModelRenderer) {
		if (childModels == null) {
			childModels = new ArrayList<ModelRenderer>();
		}
		childModels.add(pModelRenderer);
		pModelRenderer.parent = this;
	}

	public ModelRenderer setTextureOffset(int pOffsetX, int pOffsetY) {
		textureOffsetX = pOffsetX;
		textureOffsetY = pOffsetY;
		return this;
	}

	public ModelRenderer setRotationPoint(float pX, float pY, float pZ) {
		rotationPointX = pX;
		rotationPointY = pY;
		rotationPointZ = pZ;
		return this;
	}
	public List<ModelRenderer> getRendered() {
		Stack<ModelRenderer> stack = new Stack<ModelRenderer>();
		ArrayList<ModelRenderer> list = new ArrayList<ModelRenderer>();
		ArrayList<ModelBoxBase> clist = new ArrayList<ModelBoxBase>();
		HashSet<ModelRenderer> visited = new HashSet<ModelRenderer>();
		stack.push(this);
		while (!stack.isEmpty()) {
			ModelRenderer r = stack.pop();
			if (visited.contains(r)) {
				System.err.println("already visited "+r.boxName);
				continue;
			}
			visited.add(r);
			if (!r.isHidden) {
				if (r.showModel && r.isRendering) {
					list.add(r);
				}
				if (r.childModels != null) {
					for (int li = 0; li < r.childModels.size(); li++) {
						ModelRenderer r2 = r.childModels.get(li);
						if (r2 == r) {
							System.err.println("has self as child (and "+(r.childModels.size()-1)+" others)!!");
							continue;
						}
						stack.push(r2);
					}
				}
				if (r.cubeList != null) {
					clist.addAll(r.cubeList);
				}
			}
		}
		System.out.println("rendered "+clist.size()+" boxes");
		return list;
	}
	
	public void render(float par1, boolean pIsRender) {
		if (isHidden) {
			return;
		}
		if (!compiled && showModel) {
			compileDisplayList(par1);
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef(offsetX, offsetY, offsetZ);
		
		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
		renderObject(par1, pIsRender);
		GL11.glPopMatrix();
	}
	public void render(float par1) {
		render(par1, true);
	}

	public void renderWithRotation(float par1) {
		if (isHidden || !showModel) {
			return;
		}
		if (!compiled) {
			compileDisplayList(par1);
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		
		setRotation();

		GL11.glCallList(displayList);
		GL11.glPopMatrix();
	}

	public void postRender(float par1) {
		if (isHidden) return;
		if (!showModel) return;
		
		if (!compiled) {
			compileDisplayList(par1);
		}
		
		if (parent != null) {
			parent.postRender(par1);
		}
		
		GL11.glTranslatef(offsetX, offsetY, offsetZ);
		
		if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F) {
			GL11.glTranslatef(rotationPointX * par1, rotationPointY * par1, rotationPointZ * par1);
		}
		if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F) {
			setRotation();
		}
	}

	protected void compileDisplayList(float par1) {
		if (displayList <= 0) {
			displayList = GLAllocation.generateDisplayLists(1);			
		}
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		Tessellator tessellator = Tessellator.instance;

		for (int i = 0; i < cubeList.size(); i++) {
			cubeList.get(i).render(tessellator, par1);
		}
		for (int i = 0; i < customShapes.size(); i++) {
			customShapes.get(i).render(tessellator, par1);
		}
		
		GL11.glEndList();
		compiled = true;
	}

	public ModelRenderer setTextureSize(int pWidth, int pHeight) {
		textureWidth = (float)pWidth;
		textureHeight = (float)pHeight;
		return this;
	}
	
	public ModelRenderer addBox(String pName, float pX, float pY, float pZ, 
			int pWidth, int pHeight, int pDepth, float pSizeAdjust) {
		ModelBox box = new ModelBox(this, this.textureOffsetX, this.textureOffsetY, 
				pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust);
		box.setBoxName(pName);
		this.cubeList.add(box);
		return this;
	}

	public ModelRenderer addBox(float pX, float pY, float pZ, 
			int pWidth, int pHeight, int pDepth, float pSizeAdjust) {
		return this.addBox(null, pX, pY, pZ, pWidth, pHeight, pDepth, pSizeAdjust);
	}

	public ModelRenderer addBox(float pX, float pY, float pZ, 
			int pWidth, int pHeight, int pDepth) {
		return this.addBox(null, pX, pY, pZ, pWidth, pHeight, pDepth, 0F);
	}


	public ModelRenderer addPlate(String pName, float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane, float pSizeAdjust) {
		ModelBoxPlate plate = new ModelBoxPlate(this, this.textureOffsetX, this.textureOffsetY, 
				pX, pY, pZ, pWidth, pHeight, pFacePlane, pSizeAdjust);
		plate.setBoxName(pName);
		this.cubeList.add(plate);
		return this;
	}

	public ModelRenderer addPlate(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane) {
		return this.addPlate(null, pX, pY, pZ, pWidth, pHeight, pFacePlane, 0F);
	}

	public ModelRenderer addPlate(float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane, float pSizeAdjust) {
		return this.addPlate(null, pX, pY, pZ, pWidth, pHeight, pFacePlane, pSizeAdjust);
	}

	public ModelRenderer addPlate(String pName, float pX, float pY, float pZ,
			int pWidth, int pHeight, int pFacePlane) {
		return this.addPlate(pName, pX, pY, pZ, pWidth, pHeight, pFacePlane, 0F);
	}

	
	public void clearCubeList() {
		cubeList.clear();
		compiled = false;
		if (childModels != null) {
			for (ModelRenderer r : childModels) {
				r.parent = null;
			}
			childModels.clear();
		}
	}

	
	public boolean renderItems(ModelMultiBase pModelMulti, IModelCaps pEntityCaps, boolean pRealBlock, int pIndex) {
		ItemStack[] litemstacks = (ItemStack[])ModelCapsHelper.getCapsValue(pEntityCaps, caps_Items);
		if (litemstacks == null) return false;
		EnumAction[] lactions = (EnumAction[])ModelCapsHelper.getCapsValue(pEntityCaps, caps_Actions);
		EntityLivingBase lentity = (EntityLivingBase)pEntityCaps.getCapsValue(caps_Entity);
		
		renderItems(lentity, pModelMulti.render, pRealBlock, lactions[pIndex], litemstacks[pIndex]);
		return true;
	}

	public void renderItemsHead(ModelMultiBase pModelMulti, IModelCaps pEntityCaps) {
		ItemStack lis = (ItemStack)pEntityCaps.getCapsValue(caps_HeadMount);
		EntityLivingBase lentity = (EntityLivingBase)pEntityCaps.getCapsValue(caps_Entity);
		
		renderItems(lentity, pModelMulti.render, true, null, lis);
	}

	protected void renderItems(EntityLivingBase pEntityLiving, Render pRender,
			boolean pRealBlock, EnumAction pAction, ItemStack pItemStack) {
		itemstack = pItemStack;
		renderItems(pEntityLiving, pRender, pRealBlock, pAction);
	}

	protected void renderItems(EntityLivingBase pEntityLiving, Render pRender, boolean pRealBlock, EnumAction pAction) {
		if (itemstack == null) return;
		
		
		GL11.glPushMatrix();
		Item litem = itemstack.getItem();
		
		
		if (adjust) {
			// GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			
			if (pRealBlock && (litem instanceof ItemBlock)) {
				float f2 = 0.625F;
				GL11.glScalef(f2, -f2, -f2);
				GL11.glRotatef(270F, 0F, 1F, 0);
			} else if (pRealBlock && (litem instanceof ItemSkull)) {
				float f2 = 1.0625F;
				GL11.glScalef(f2, -f2, -f2);
			} else {
				float var6;
				if ((litem instanceof ItemBlock)
						&& RenderBlocks.renderItemIn3d(Block.getBlockFromItem(litem).getRenderType())) {
					var6 = 0.5F;
					// GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
					GL11.glTranslatef(0.0F, 0.1875F, -0.2125F);
					var6 *= 0.75F;
					GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
				} else if (litem instanceof ItemBow) {
					var6 = 0.625F;
					GL11.glTranslatef(-0.05F, 0.125F, 0.3125F);
					GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				} else if (litem.isFull3D()) {
					var6 = 0.625F;
					
					if (litem.shouldRotateAroundWhenRendering()) {
						GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
						GL11.glTranslatef(0.0F, -0.125F, 0.0F);
					}
					
					if (pAction == EnumAction.block) {
						GL11.glTranslatef(0.05F, 0.0F, -0.1F);
						GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
					}
					
					GL11.glTranslatef(0.0F, 0.1875F, 0.1F);
					GL11.glScalef(var6, -var6, var6);
					GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				} else {
					var6 = 0.375F;
					GL11.glTranslatef(0.15F, 0.15F, -0.05F);
					// GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
					GL11.glScalef(var6, var6, var6);
					GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
				}
			}
		}
		
		
		if (pRealBlock && litem instanceof ItemSkull) {
			String lsowner = "";
			if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner")) {
				lsowner = itemstack.getTagCompound().getString("SkullOwner");
			}
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//			TileEntitySkullRenderer.skullRenderer.func_82393_a(-0.5F, -0.25F, -0.5F, 1, 180.0F,
//					itemstack.getItemDamage(), lsowner);
			MinecraftClientWrapper.renderSkeletonHead(TileEntitySkullRenderer.field_147536_b, -0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), lsowner);
		} else if (pRealBlock && litem instanceof ItemBlock) {
//			Client.setTexture(TextureMap.field_110575_b);
//			pRender.loadTexture("/terrain.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			int var4 = pEntityLiving.getBrightnessForRender(0.0F);
			int var5 = var4 % 65536;
			int var6 = var4 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var5 / 1.0F, (float)var6 / 1.0F);

			
			GL11.glEnable(GL11.GL_CULL_FACE);
//			pRender.renderBlocks.renderBlockAsItem(
//					Block.blocksList[itemstack.itemID],
//					itemstack.getItemDamage(), 1.0F);


			renderBlock(itemstack);

			GL11.glDisable(GL11.GL_CULL_FACE);
		} else {
			
//			pRender.loadTexture("/gui/items.png");
			for (int j = 0; j <= (litem.requiresMultipleRenderPasses() ? 1 : 0); j++) {
				int k = itemstack.getItem().getColorFromItemStack(itemstack, j);
				float f15 = (float) (k >> 16 & 0xff) / 255F;
				float f17 = (float) (k >> 8 & 0xff) / 255F;
				float f19 = (float) (k & 0xff) / 255F;
				GL11.glColor4f(f15, f17, f19, 1.0F);
				RenderManager.instance.itemRenderer.renderItem(pEntityLiving, itemstack, j);
			}
		}
		
		GL11.glPopMatrix();
	}
	
	private void renderBlock(ItemStack par2ItemStack)
	{
		GL11.glPushMatrix();
		TextureManager texturemanager = Minecraft.getMinecraft().renderEngine;
		Item item = par2ItemStack.getItem();
		Block block = Block.getBlockFromItem(item);

		if (par2ItemStack.getItemSpriteNumber() == 0 && item instanceof ItemBlock)// && RenderBlocks.renderItemIn3d(block.getRenderType()))
		{
			texturemanager.bindTexture(texturemanager.getResourceLocation(0));

			GL11.glDisable(GL11.GL_LIGHTING);
			if (item instanceof ItemCloth)
			{
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDepthMask(false);
				OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				
				GL11.glAlphaFunc(GL11.GL_GREATER, 0.001F);
				
				this.renderBlocksIr.renderBlockAsItem(block, par2ItemStack.getItemDamage(), 1.0F);
				GL11.glDepthMask(true);
				GL11.glDisable(GL11.GL_BLEND);
			}
			else
			{
				this.renderBlocksIr.renderBlockAsItem(block, par2ItemStack.getItemDamage(), 1.0F);
			}
			GL11.glEnable(GL11.GL_LIGHTING);
		}

		GL11.glPopMatrix();
	}

	
	public void setRotatePriority(int pValue) {
		rotatePriority = pValue;
	}

	
	protected void setRotation() {
		
		switch (rotatePriority) {
		case RotXYZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotXZY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			break;
		case RotYXZ:
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotYZX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			break;
		case RotZXY:
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		case RotZYX:
			if (rotateAngleX != 0.0F) {
				GL11.glRotatef(rotateAngleX * radFactor, 1.0F, 0.0F, 0.0F);
			}
			if (rotateAngleY != 0.0F) {
				GL11.glRotatef(rotateAngleY * radFactor, 0.0F, 1.0F, 0.0F);
			}
			if (rotateAngleZ != 0.0F) {
				GL11.glRotatef(rotateAngleZ * radFactor, 0.0F, 0.0F, 1.0F);
			}
			break;
		}
	}

	
	protected void renderObject(float par1, boolean pRendering) {
		
		/** Download the matrix from GPU
		 * 
		 * This is very bad practice
		 */
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, matrix); 
		
		if (pRendering && isRendering && showModel) {
			GL11.glPushMatrix();
			GL11.glScalef(scaleX, scaleY, scaleZ);
			GL11.glCallList(displayList);
			GL11.glPopMatrix();
		}
		
		if (childModels != null) {
			for (int li = 0; li < childModels.size(); li++) {
				childModels.get(li).render(par1, pRendering);
			}
		}
	}

	
	public ModelRenderer loadMatrix() {
		GL11.glLoadMatrix(matrix);
		if (isInvertX) {
			GL11.glScalef(-1F, 1F, 1F);
		}
		return this;
	}


	

	public boolean getMirror() {
		return mirror;
	}

	public ModelRenderer setMirror(boolean flag) {
		mirror = flag;
		return this;
	}

	public boolean getVisible() {
		return showModel;
	}

	public void setVisible(boolean flag) {
		showModel = flag;
	}


	

	public float getRotateAngleX() {
		return rotateAngleX;
	}

	public float getRotateAngleDegX() {
		return rotateAngleX * radFactor;
	}

	public float setRotateAngleX(float value) {
		return rotateAngleX = value;
	}

	public float setRotateAngleDegX(float value) {
		return rotateAngleX = value * degFactor;
	}

	public float addRotateAngleX(float value) {
		return rotateAngleX += value;
	}

	public float addRotateAngleDegX(float value) {
		return rotateAngleX += value * degFactor;
	}

	public float getRotateAngleY() {
		return rotateAngleY;
	}

	public float getRotateAngleDegY() {
		return rotateAngleY * radFactor;
	}

	public float setRotateAngleY(float value) {
		return rotateAngleY = value;
	}

	public float setRotateAngleDegY(float value) {
		return rotateAngleY = value * degFactor;
	}

	public float addRotateAngleY(float value) {
		return rotateAngleY += value;
	}

	public float addRotateAngleDegY(float value) {
		return rotateAngleY += value * degFactor;
	}

	public float getRotateAngleZ() {
		return rotateAngleZ;
	}

	public float getRotateAngleDegZ() {
		return rotateAngleZ * radFactor;
	}

	public float setRotateAngleZ(float value) {
		return rotateAngleZ = value;
	}

	public float setRotateAngleDegZ(float value) {
		return rotateAngleZ = value * degFactor;
	}

	public float addRotateAngleZ(float value) {
		return rotateAngleZ += value;
	}

	public float addRotateAngleDegZ(float value) {
		return rotateAngleZ += value * degFactor;
	}

	public ModelRenderer setRotateAngle(float x, float y, float z) {
		rotateAngleX = x;
		rotateAngleY = y;
		rotateAngleZ = z;
		return this;
	}

	public ModelRenderer setRotateAngleDeg(float x, float y, float z) {
		rotateAngleX = x * degFactor;
		rotateAngleY = y * degFactor;
		rotateAngleZ = z * degFactor;
		return this;
	}

	public float getRotationPointX() {
		return rotationPointX;
	}

	public float setRotationPointX(float value) {
		return rotationPointX = value;
	}

	public float addRotationPointX(float value) {
		return rotationPointX += value;
	}

	public float getRotationPointY() {
		return rotationPointY;
	}

	public float setRotationPointY(float value) {
		return rotationPointY = value;
	}

	public float addRotationPointY(float value) {
		return rotationPointY += value;
	}

	public float getRotationPointZ() {
		return rotationPointZ;
	}

	public float setRotationPointZ(float value) {
		return rotationPointZ = value;
	}

	public float addRotationPointZ(float value) {
		return rotationPointZ += value;
	}

	public ModelRenderer setScale(float pX, float pY, float pZ) {
		scaleX = pX;
		scaleY = pY;
		scaleZ = pZ;
		return this;
	}

	public float setScaleX(float pValue) {
		return scaleX = pValue;
	}

	public float setScaleY(float pValue) {
		return scaleY = pValue;
	}

	public float setScaleZ(float pValue) {
		return scaleZ = pValue;
	}

	public void removeChild(ModelRenderer par1ModelRenderer) {
		if (this.childModels != null) {
			this.childModels.remove(par1ModelRenderer);
			if (par1ModelRenderer != null && par1ModelRenderer.parent == this) {
				par1ModelRenderer.parent = null;
			}
			
		}
	}
	public void clearChildModels() {
		if (this.childModels != null)
			this.childModels.clear();
	}

	public ModelRenderer addBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		return makeBall(var1, var2, var3, var4, var5, var6);
	}

	private ModelRenderer makeBall(float var1, float var2, float var3, float var4, float var5, float var6) {
		float[][] v = new float[][]{ { 0.0F, 4.9745197F, -0.0F }, { 0.0F, 3.5175202F, 3.5175202F }, { 2.4997F, 3.5175202F, 2.4872599F }, { 3.5351F, 3.5175202F, -0.0F }, { 2.4997F, 3.5175202F, -2.4872599F }, { 0.0F, 3.5175202F, -3.5175202F }, { -2.4997F, 3.5175202F, -2.4872599F }, { -3.5351F, 3.5175202F, -0.0F }, { -2.4997F, 3.5175202F, 2.4872599F }, { 0.0F, 0.0F, 4.9745197F }, { 3.5351F, 0.0F, 3.5175202F }, { 4.99939F, 0.0F, 0.0F }, { 3.5351F, -0.0F, -3.5175202F }, { 0.0F, -0.0F, -4.9745197F }, { -3.5351F, -0.0F, -3.5175202F }, { -4.99939F, 0.0F, 0.0F }, { -3.5351F, 0.0F, 3.5175202F }, { 0.0F, -3.5175202F, 3.5175202F }, { 2.4997F, -3.5175202F, 2.4872599F }, { 3.5351F, -3.5175202F, 0.0F }, { 2.4997F, -3.5175202F, -2.4872599F }, { 0.0F, -3.5175202F, -3.5175202F }, { -2.4997F, -3.5175202F, -2.4872599F }, { -3.5351F, -3.5175202F, 0.0F }, { -2.4997F, -3.5175202F, 2.4872599F }, { 0.0F, -4.9745197F, 0.0F } };
		float[][] uv = new float[][]{ 
				{ textureOffsetX / this.textureWidth, (textureOffsetY + 1) / this.textureHeight }, 
				{ (textureOffsetX + 1) / this.textureWidth, (textureOffsetY + 1) / this.textureHeight }, 
				{ (textureOffsetX + 1) / this.textureWidth, textureOffsetY / this.textureHeight }, 
				{ textureOffsetX / this.textureWidth, textureOffsetY / this.textureHeight } };
		float[][] var9 = new float[][]{ { 0.0F, 1.0F, 0.0F }, { 0.0F, 0.663167F, 0.748436F }, { 0.527909F, 0.663594F, 0.529984F }, { 0.747673F, 0.664052F, 0.0F }, { 0.527909F, 0.663594F, -0.529984F }, { 0.0F, 0.663167F, -0.748436F }, { -0.527909F, 0.663594F, -0.529984F }, { -0.747673F, 0.664052F, 0.0F }, { -0.527909F, 0.663594F, 0.529984F }, { 0.0F, 0.0F, 0.999969F }, { 0.706076F, 0.0F, 0.70809F }, { 1.0F, 0.0F, 0.0F }, { 0.706107F, 0.0F, -0.70809F }, { 0.0F, 0.0F, -0.999969F }, { -0.706076F, 0.0F, -0.70809F }, { -1.0F, 0.0F, 0.0F }, { -0.706107F, 0.0F, 0.70809F }, { 0.0F, -0.663167F, 0.748436F }, { 0.527909F, -0.663594F, 0.529984F }, { 0.747673F, -0.664052F, 0.0F }, { 0.527909F, -0.663594F, -0.529984F }, { 0.0F, -0.663167F, -0.748436F }, { -0.527909F, -0.663594F, -0.529984F }, { -0.747673F, -0.664052F, 0.0F }, { -0.527909F, -0.663594F, 0.529984F }, { 0.0F, -1.0F, 0.0F } };
		int[][][] var10 = new int[][][]{ { { 1 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } }, { { 1 }, { 0, 2, 3 }, { 0, 1, 2 }, { 0, 2, 3 } }, { { 1 }, { 0, 3, 4 }, { 0, 1, 2 }, { 0, 3, 4 } }, { { 1 }, { 0, 4, 5 }, { 0, 1, 2 }, { 0, 4, 5 } }, { { 1 }, { 0, 5, 6 }, { 0, 1, 2 }, { 0, 5, 6 } }, { { 1 }, { 0, 6, 7 }, { 0, 1, 2 }, { 0, 6, 7 } }, { { 1 }, { 0, 7, 8 }, { 0, 1, 2 }, { 0, 7, 8 } }, { { 1 }, { 0, 8, 1 }, { 0, 1, 2 }, { 0, 8, 1 } }, { { 1 }, { 1, 9, 10, 2 }, { 0, 1, 2, 3 }, { 1, 9, 10, 2 } }, { { 1 }, { 2, 10, 11, 3 }, { 0, 1, 2, 3 }, { 2, 10, 11, 3 } }, { { 1 }, { 3, 11, 12, 4 }, { 0, 1, 2, 3 }, { 3, 11, 12, 4 } }, { { 1 }, { 4, 12, 13, 5 }, { 0, 1, 2, 3 }, { 4, 12, 13, 5 } }, { { 1 }, { 5, 13, 14, 6 }, { 0, 1, 2, 3 }, { 5, 13, 14, 6 } }, { { 1 }, { 6, 14, 15, 7 }, { 0, 1, 2, 3 }, { 6, 14, 15, 7 } }, { { 1 }, { 7, 15, 16, 8 }, { 0, 1, 2, 3 }, { 7, 15, 16, 8 } }, { { 1 }, { 8, 16, 9, 1 }, { 0, 1, 2, 3 }, { 8, 16, 9, 1 } }, { { 1 }, { 9, 17, 18, 10 }, { 0, 1, 2, 3 }, { 9, 17, 18, 10 } }, { { 1 }, { 10, 18, 19, 11 }, { 0, 1, 2, 3 }, { 10, 18, 19, 11 } }, { { 1 }, { 11, 19, 20, 12 }, { 0, 1, 2, 3 }, { 11, 19, 20, 12 } }, { { 1 }, { 12, 20, 21, 13 }, { 0, 1, 2, 3 }, { 12, 20, 21, 13 } }, { { 1 }, { 13, 21, 22, 14 }, { 0, 1, 2, 3 }, { 13, 21, 22, 14 } }, { { 1 }, { 14, 22, 23, 15 }, { 0, 1, 2, 3 }, { 14, 22, 23, 15 } }, { { 1 }, { 15, 23, 24, 16 }, { 0, 1, 2, 3 }, { 15, 23, 24, 16 } }, { { 1 }, { 16, 24, 17, 9 }, { 0, 1, 2, 3 }, { 16, 24, 17, 9 } }, { { 1 }, { 17, 25, 18 }, { 0, 1, 2 }, { 17, 25, 18 } }, { { 1 }, { 18, 25, 19 }, { 0, 1, 2 }, { 18, 25, 19 } }, { { 1 }, { 19, 25, 20 }, { 0, 1, 2 }, { 19, 25, 20 } }, { { 1 }, { 20, 25, 21 }, { 0, 1, 2 }, { 20, 25, 21 } }, { { 1 }, { 21, 25, 22 }, { 0, 1, 2 }, { 21, 25, 22 } }, { { 1 }, { 22, 25, 23 }, { 0, 1, 2 }, { 22, 25, 23 } }, { { 1 }, { 23, 25, 24 }, { 0, 1, 2 }, { 23, 25, 24 } }, { { 1 }, { 24, 25, 17 }, { 0, 1, 2 }, { 24, 25, 17 } } };
		int var11;

		for (var11 = 0; var11 < v.length; ++var11) {
			v[var11][0] *= var4 / 8.0F;
			v[var11][1] *= var5 / 8.0F;
			v[var11][2] *= var6 / 8.0F;
			v[var11][0] += var1;
			v[var11][1] += var2;
			v[var11][2] += var3;
		}

		for (var11 = 0; var11 < var10.length; ++var11) {
			int var12 = var10[var11][1].length;
			float[][] var13 = new float[var12][3];
			float[][] var14 = new float[var12][2];
			float[][] var15 = new float[var12][3];

			if (var10[var11][0][0] == 1) {
				for (int var16 = 0; var16 < var12; ++var16) {
					var13[var16] = v[var10[var11][1][var16]];
					var14[var16] = uv[var10[var11][2][var16]];
					var15[var16] = var9[var10[var11][3][var16]];
				}

				addPlateFreeShape(var13, var14, var15, (float[]) null);
			}
		}

		return this;
	}

	public ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN, float[] var4) {
		ModelBoxTriangles tri = new ModelBoxTriangles(textureOffsetX, textureOffsetY, vertex, texUV, vertexN, var4);
		if (this.mirror) {
			tri.flipFace();
		}
		this.customShapes.add(tri);
		return this;
	}
	public ModelRenderer addPlateFreeShape(float[][] vertex, float[][] texUV, float[][] vertexN) {
		return addPlateFreeShape(vertex, texUV, vertexN, null);
	}
}
