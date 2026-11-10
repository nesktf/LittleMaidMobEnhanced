package littleMaidMobX.model.maid;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import littleMaidMobX.io.FileManager;
import littleMaidMobX.model.bedrock.BedrockModelParser;
import littleMaidMobX.model.bedrock.BedrockPart;
import littleMaidMobX.model.bedrock.ModelBoxBedrockBox;
import littleMaidMobX.model.bedrock.ModelBoxBedrockPerFace;
import littleMaidMobX.model.bedrock.pojo.BedrockModelPOJO;
import littleMaidMobX.model.bedrock.pojo.BonesItem;
import littleMaidMobX.model.bedrock.pojo.CubesItem;
import littleMaidMobX.model.bedrock.pojo.Description;
import littleMaidMobX.model.bedrock.pojo.FaceUVsItem;
import littleMaidMobX.model.bedrock.pojo.GeometryModelLegacy;
import littleMaidMobX.model.bedrock.pojo.GeometryModelNew;
import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;
import littleMaidMobX.render.model.ModelRenderer;

public class MultiModelBedrock extends ModelMultiMMMBase {

    protected final Map<String, BedrockPart> modelMap = new HashMap<String, BedrockPart>();
    protected final Map<String, BonesItem> indexBones = new HashMap<String, BonesItem>();

    public BedrockPart head;
    public BedrockPart body;
    public BedrockPart armRight;
    public BedrockPart armLeft;
    public BedrockPart legRight;
    public BedrockPart legLeft;
    public BedrockPart skirt;
    public BedrockPart blink;
    public BedrockPart blink2;
    public BedrockPart hurtBlink;
    public BedrockPart reverseBlink;
    public BedrockPart eyeR;
    public BedrockPart eyeL;

    public boolean hideArmor = true;
    protected String modelResourcePath;
    protected float customHeight = 1.35F;
    protected float customWidth = 0.5F;
    protected float customYOffset = 1.35F;
    protected float customMountedYOffset = 0.35F;

    public MultiModelBedrock() {
        this(0.0F);
    }

    public MultiModelBedrock(float pSizeAdjust) {
        this(pSizeAdjust, null);
    }

    public MultiModelBedrock(float pSizeAdjust, String pModelPath) {
        this(pSizeAdjust, 0.0F, 64, 32, pModelPath);
    }

    public MultiModelBedrock(float pSizeAdjust, float pYOffset, int pTextureWidth, int pTextureHeight) {
        this(pSizeAdjust, pYOffset, pTextureWidth, pTextureHeight, null);
    }

    public MultiModelBedrock(float pSizeAdjust, float pYOffset, int pTextureWidth, int pTextureHeight,
        String pModelPath) {
        super((StringBuilder) null);
        this.modelSize = pSizeAdjust;
        this.isSneak = false;
        this.aimedBow = false;
        this.textureWidth = pTextureWidth;
        this.textureHeight = pTextureHeight;
        this.Arms = new ModelRenderer[2];
        this.Arms[0] = new ModelRenderer(this, "dummyArm0");
        this.Arms[1] = new ModelRenderer(this, "dummyArm1");
        this.HeadMount = new ModelRenderer(this, "HeadMount");
        this.HeadTop = new ModelRenderer(this, "HeadTop");
        this.modelResourcePath = pModelPath;
        initModel(pSizeAdjust, pYOffset);
    }

    @Override
    public void initModel(float psize, float pyoffset) {
        modelMap.clear();
        indexBones.clear();
        mainFrame = new ModelRenderer(this, "mainFrame");

        InputStream stream = openModelStream();
        if (stream == null) {
            System.err.println(
                "MultiModelBedrock: Could not open model stream for " + getClass().getSimpleName()
                    + " (path: "
                    + getModelPath()
                    + ")");
            return;
        }

        BedrockModelPOJO pojo = BedrockModelParser.parse(stream);
        try {
            stream.close();
        } catch (Exception ignored) {}

        if (pojo == null) {
            System.err.println(
                "MultiModelBedrock: Failed to parse JSON model for " + getClass().getSimpleName()
                    + " (path: "
                    + getModelPath()
                    + ")");
            return;
        }

        if (pojo.getGeometryModelNew() != null) {
            loadNewModel(pojo.getGeometryModelNew(), psize);
        } else if (pojo.getGeometryModelLegacy() != null) {
            loadLegacyModel(pojo.getGeometryModelLegacy(), psize);
        }

        bindStandardBones();
    }

    protected InputStream openModelStream() {
        String path = getModelPath();
        if (path == null || path.isEmpty()) {
            return null;
        }
        String noSlash = path.startsWith("/") ? path.substring(1) : path;
        String withSlash = path.startsWith("/") ? path : "/" + path;

        InputStream is = null;
        if (FileManager.COMMON_CLASS_LOADER != null) {
            is = FileManager.COMMON_CLASS_LOADER.getResourceAsStream(noSlash);
        }
        if (is == null && getClass().getClassLoader() != null) {
            is = getClass().getClassLoader()
                .getResourceAsStream(noSlash);
        }
        if (
            is == null && Thread.currentThread()
                .getContextClassLoader() != null
        ) {
            is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(noSlash);
        }
        if (is == null) {
            is = getClass().getResourceAsStream(withSlash);
        }
        return is;
    }

    public String getModelPath() {
        if (modelResourcePath != null && !modelResourcePath.isEmpty()) {
            return modelResourcePath;
        }
        String className = getClass().getSimpleName();
        String modelName = className;
        int idx = className.indexOf('_');
        if (idx > -1 && idx < className.length() - 1) {
            modelName = className.substring(idx + 1);
        }
        return "assets/minecraft/models/entity/" + modelName + ".json";
    }

    protected void loadNewModel(GeometryModelNew geometry, float psize) {
        geometry.deco();
        Description desc = geometry.getDescription();
        if (desc != null) {
            this.textureWidth = desc.getTextureWidth();
            this.textureHeight = desc.getTextureHeight();
        }

        BonesItem[] bones = geometry.getBones();
        if (bones == null) return;

        buildBones(bones, psize);
    }

    protected void loadLegacyModel(GeometryModelLegacy geometry, float psize) {
        geometry.deco();
        this.textureWidth = geometry.getTextureWidth();
        this.textureHeight = geometry.getTextureHeight();

        BonesItem[] bones = geometry.getBones();
        if (bones == null) return;

        buildBones(bones, psize);
    }

    protected void buildBones(BonesItem[] bones, float psize) {
        for (BonesItem bone : bones) {
            indexBones.put(bone.getName(), bone);
            BedrockPart part = new BedrockPart(this, bone.getName());
            modelMap.put(bone.getName(), part);
        }

        for (BonesItem bone : bones) {
            String name = bone.getName();
            BedrockPart part = modelMap.get(name);
            if (part == null) continue;

            part.mirror = bone.isMirror();
            part.setInitPosition(convertPivot(bone, 0), convertPivot(bone, 1), convertPivot(bone, 2));

            float[] rotation = bone.getRotation();
            if (rotation != null) {
                part.setInitRotation(
                    convertRotation(rotation[0]),
                    convertRotation(rotation[1]),
                    convertRotation(rotation[2]));
            }

            String parentName = bone.getParent();
            if (parentName != null && modelMap.containsKey(parentName)) {
                modelMap.get(parentName)
                    .addChild(part);
            } else {
                mainFrame.addChild(part);
            }

            CubesItem[] cubes = bone.getCubes();
            if (cubes == null) continue;

            for (CubesItem cube : cubes) {
                float[] uv = cube.getUv();
                FaceUVsItem faceUv = cube.getFaceUv();
                float[] size = cube.getSize();
                float[] cubeRotation = cube.getRotation();
                boolean mirror = cube.isMirror();
                float inflate = cube.getInflate() + psize;

                if (cubeRotation == null) {
                    if (faceUv == null && uv != null) {
                        part.cubeList.add(
                            new ModelBoxBedrockBox(
                                uv[0],
                                uv[1],
                                convertOrigin(bone, cube, 0),
                                convertOrigin(bone, cube, 1),
                                convertOrigin(bone, cube, 2),
                                size[0],
                                size[1],
                                size[2],
                                inflate,
                                mirror,
                                textureWidth,
                                textureHeight));
                    } else if (faceUv != null) {
                        part.cubeList.add(
                            new ModelBoxBedrockPerFace(
                                convertOrigin(bone, cube, 0),
                                convertOrigin(bone, cube, 1),
                                convertOrigin(bone, cube, 2),
                                size[0],
                                size[1],
                                size[2],
                                inflate,
                                textureWidth,
                                textureHeight,
                                faceUv));
                    }
                } else {
                    BedrockPart cubeRenderer = new BedrockPart(this, name + "_cube");
                    cubeRenderer.setInitPosition(
                        convertPivot(bone, cube, 0),
                        convertPivot(bone, cube, 1),
                        convertPivot(bone, cube, 2));
                    cubeRenderer.setInitRotation(
                        convertRotation(cubeRotation[0]),
                        convertRotation(cubeRotation[1]),
                        convertRotation(cubeRotation[2]));

                    if (faceUv == null && uv != null) {
                        cubeRenderer.cubeList.add(
                            new ModelBoxBedrockBox(
                                uv[0],
                                uv[1],
                                convertOrigin(cube, 0),
                                convertOrigin(cube, 1),
                                convertOrigin(cube, 2),
                                size[0],
                                size[1],
                                size[2],
                                inflate,
                                mirror,
                                textureWidth,
                                textureHeight));
                    } else if (faceUv != null) {
                        cubeRenderer.cubeList.add(
                            new ModelBoxBedrockPerFace(
                                convertOrigin(cube, 0),
                                convertOrigin(cube, 1),
                                convertOrigin(cube, 2),
                                size[0],
                                size[1],
                                size[2],
                                inflate,
                                textureWidth,
                                textureHeight,
                                faceUv));
                    }

                    part.addChild(cubeRenderer);
                }
            }
        }
    }

    protected void bindStandardBones() {
        head = findBone("head", "bipedHead");
        body = findBone("body", "bipedBody", "torso", "bipedTorso");
        armRight = findBone("armRight", "rightArm", "bipedRightArm", "arm_right");
        armLeft = findBone("armLeft", "leftArm", "bipedLeftArm", "arm_left");
        legRight = findBone("legRight", "rightLeg", "bipedRightLeg", "leg_right");
        legLeft = findBone("legLeft", "leftLeg", "bipedLeftLeg", "leg_left");
        skirt = findBone("skirt", "Skirt");
        blink = findBone("blink");
        blink2 = findBone("blink2");
        hurtBlink = findBone("hurtBlink", "hurt_blink");
        reverseBlink = findBone("_blink", "_bink");
        eyeR = findBone("eyeR", "eye_right", "rightEye");
        eyeL = findBone("eyeL", "eye_left", "leftEye");

        if (head == null && modelMap.size() == 1) {
            head = modelMap.values()
                .iterator()
                .next();
        }

        Arms = new ModelRenderer[2];
        Arms[0] = armRight != null ? armRight : new ModelRenderer(this, "dummyArm0");
        Arms[1] = armLeft != null ? armLeft : new ModelRenderer(this, "dummyArm1");

        HeadMount = head != null ? head : mainFrame;
        HeadTop = head != null ? head : mainFrame;
    }

    protected BedrockPart findBone(String... names) {
        for (String name : names) {
            for (Map.Entry<String, BedrockPart> entry : modelMap.entrySet()) {
                if (
                    entry.getKey()
                        .equalsIgnoreCase(name)
                ) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    protected float convertPivot(BonesItem bones, int index) {
        if (bones.getParent() != null && indexBones.containsKey(bones.getParent())) {
            float[] parentPivot = indexBones.get(bones.getParent())
                .getPivot();
            float[] bonePivot = bones.getPivot();
            if (parentPivot != null && bonePivot != null) {
                if (index == 1) {
                    return parentPivot[index] - bonePivot[index];
                } else {
                    return bonePivot[index] - parentPivot[index];
                }
            }
        }
        float[] pivot = bones.getPivot();
        if (pivot != null) {
            if (index == 1) {
                return 24.0F - pivot[index];
            } else {
                return pivot[index];
            }
        }
        return 0.0F;
    }

    protected float convertPivot(BonesItem parent, CubesItem cube, int index) {
        float[] parentPivot = parent.getPivot();
        float[] cubePivot = cube.getPivot();
        if (parentPivot != null && cubePivot != null) {
            if (index == 1) {
                return parentPivot[index] - cubePivot[index];
            } else {
                return cubePivot[index] - parentPivot[index];
            }
        }
        return 0.0F;
    }

    protected float convertOrigin(BonesItem bone, CubesItem cube, int index) {
        float[] bonePivot = bone.getPivot();
        float[] cubeOrigin = cube.getOrigin();
        float[] cubeSize = cube.getSize();
        if (bonePivot != null && cubeOrigin != null && cubeSize != null) {
            if (index == 1) {
                return bonePivot[index] - cubeOrigin[index] - cubeSize[index];
            } else {
                return cubeOrigin[index] - bonePivot[index];
            }
        }
        return 0.0F;
    }

    protected float convertOrigin(CubesItem cube, int index) {
        float[] cubePivot = cube.getPivot();
        float[] cubeOrigin = cube.getOrigin();
        float[] cubeSize = cube.getSize();
        if (cubePivot != null && cubeOrigin != null && cubeSize != null) {
            if (index == 1) {
                return cubePivot[index] - cubeOrigin[index] - cubeSize[index];
            } else {
                return cubeOrigin[index] - cubePivot[index];
            }
        }
        return 0.0F;
    }

    protected float convertRotation(float degree) {
        return (float) (degree * Math.PI / 180.0);
    }

    @Override
    public float[] getArmorModelsSize() {
        return new float[] { 0.1F, 0.5F };
    }

    @Override
    public void setDefaultPause() {
        for (BedrockPart part : modelMap.values()) {
            part.resetPose();
        }
    }

    @Override
    public void setDefaultPause(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch,
        float par6, IModelCaps pEntityCaps) {
        setDefaultPause();

        mainFrame.setRotationPoint(0F, 0F, 0F);

        if (head != null) {
            float pitch = pHeadPitch < 0.0F ? pHeadPitch * 0.5F : pHeadPitch;
            head.rotateAngleX = head.initRotX + (pitch * ModelRenderer.degFactor);
            head.rotateAngleY = head.initRotY + (pHeadYaw * ModelRenderer.degFactor);
        }

        if (armRight != null) {
            armRight.rotateAngleX = armRight.initRotX
                + MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 2.0F * par2 * 0.5F;
            armRight.rotateAngleZ = armRight.initRotZ;
        }

        if (armLeft != null) {
            armLeft.rotateAngleX = armLeft.initRotX + MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
            armLeft.rotateAngleZ = armLeft.initRotZ;
        }

        if (legRight != null) {
            legRight.rotateAngleX = legRight.initRotX + MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        }

        if (legLeft != null) {
            legLeft.rotateAngleX = legLeft.initRotX + MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
        }

        if (isRiding) {
            if (legRight != null) {
                legRight.rotateAngleX = legRight.initRotX - 1.256637F;
                legRight.rotateAngleY = legRight.initRotY + 0.314159F;
            }
            if (legLeft != null) {
                legLeft.rotateAngleX = legLeft.initRotX - 1.256637F;
                legLeft.rotateAngleY = legLeft.initRotY - 0.314159F;
            }
            mainFrame.rotationPointY += 3.0F;
        }

        if (isSneak) {
            if (body != null) {
                body.rotateAngleX = body.initRotX + 0.5F;
            }
            mainFrame.rotationPointY += 1.0F;
        }
    }

    @Override
    public void setLivingAnimations(IModelCaps pEntityCaps, float par2, float par3, float pRenderPartialTicks) {
        super.setLivingAnimations(pEntityCaps, par2, par3, pRenderPartialTicks);
        if (head != null && pEntityCaps != null) {
            float angle = ModelCapsHelper.getCapsValueFloat(pEntityCaps, caps_interestedAngle, pRenderPartialTicks);
            head.rotateAngleZ = angle;
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float pTicksExisted, float pHeadYaw, float pHeadPitch,
        float par6, IModelCaps pEntityCaps) {
        setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, pEntityCaps);

        boolean isWaitState = isWait
            || (pEntityCaps != null && (ModelCapsHelper.getCapsValueBoolean(pEntityCaps, caps_isWait)
                || ModelCapsHelper.getCapsValueBoolean(pEntityCaps, caps_isWaitEX)));

        if (aimedBow && armRight != null && armLeft != null && head != null) {
            float lonGround = onGrounds[dominantArm];
            float f6 = MathHelper.sin(lonGround * 3.141593F);
            float f7 = MathHelper.sin((1.0F - (1.0F - lonGround) * (1.0F - lonGround)) * 3.141593F);
            float la = 0.1F - f6 * 0.6F;
            armRight.rotateAngleX = -1.470796F;
            armRight.rotateAngleY = -la;
            armLeft.rotateAngleX = -1.470796F;
            armLeft.rotateAngleY = la;
            armRight.rotateAngleX += head.rotateAngleX;
            armLeft.rotateAngleX += head.rotateAngleX;
            armRight.rotateAngleY += head.rotateAngleY;
            armLeft.rotateAngleY += head.rotateAngleY;
        } else if (isWaitState) {
            float lx = MathHelper.sin(pTicksExisted * 0.067F) * 0.05F - 0.7F;
            if (armRight != null) {
                armRight.rotateAngleX = lx;
                armRight.rotateAngleY = 0.0F;
                armRight.rotateAngleZ = -0.4F;
            }
            if (armLeft != null) {
                armLeft.rotateAngleX = lx;
                armLeft.rotateAngleY = 0.0F;
                armLeft.rotateAngleZ = 0.4F;
            }
            if (!isRiding) {
                if (legRight != null) {
                    legRight.rotateAngleX = legRight.initRotX;
                    legRight.rotateAngleY = legRight.initRotY;
                    legRight.rotateAngleZ = legRight.initRotZ;
                }
                if (legLeft != null) {
                    legLeft.rotateAngleX = legLeft.initRotX;
                    legLeft.rotateAngleY = legLeft.initRotY;
                    legLeft.rotateAngleZ = legLeft.initRotZ;
                }
            }
        } else {
            float la = MathHelper.sin(pTicksExisted * 0.067F) * 0.05F;
            float lc = MathHelper.cos(pTicksExisted * 0.09F) * 0.05F + 0.05F;
            if (armRight != null) {
                armRight.rotateAngleX += la;
                armRight.rotateAngleZ += lc;
            }
            if (armLeft != null) {
                armLeft.rotateAngleX -= la;
                armLeft.rotateAngleZ -= lc;
            }
        }

        // Eye blink animation
        boolean isSleeping = false;
        boolean isHurt = false;
        if (pEntityCaps != null) {
            Object entity = pEntityCaps.getCapsValue(caps_Entity);
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase living = (EntityLivingBase) entity;
                isSleeping = living.isPlayerSleeping();
                isHurt = living.hurtTime > 0;
            }
        }

        float remainder = (pTicksExisted + Math.abs(entityIdFactor * 100.0F)) % 60.0F;
        boolean isBlink = 55.0F < remainder && remainder < 60.0F;
        if (aimedBow) {
            isBlink = false;
        }

        if (blink != null) {
            blink.setVisible(isBlink || isSleeping);
        }
        if (blink2 != null) {
            blink2.setVisible(isBlink || isSleeping);
        }
        if (eyeR != null) {
            eyeR.setVisible(isBlink || isSleeping);
        }
        if (eyeL != null) {
            eyeL.setVisible(isBlink || isSleeping);
        }
        if (hurtBlink != null) {
            hurtBlink.setVisible(isHurt);
            if (isHurt) {
                if (blink != null) blink.setVisible(false);
                if (blink2 != null) blink2.setVisible(false);
                if (eyeR != null) eyeR.setVisible(false);
                if (eyeL != null) eyeL.setVisible(false);
            }
        }
        if (reverseBlink != null) {
            reverseBlink.setVisible(!isBlink && !isSleeping);
        }
    }

    @Override
    public int showArmorParts(IModelCaps iModelCaps, int parts, int index) {
        if (hideArmor) {
            if (mainFrame != null) {
                mainFrame.setVisible(false);
            }
            return -1;
        }
        return super.showArmorParts(iModelCaps, parts, index);
    }

    @Override
    public void showAllParts(IModelCaps pEntityCaps) {
        if (mainFrame != null) {
            mainFrame.setVisible(true);
        }
        for (BedrockPart part : modelMap.values()) {
            part.setVisible(true);
        }
        if (blink != null) {
            blink.setVisible(false);
        }
        if (blink2 != null) {
            blink2.setVisible(false);
        }
        if (eyeR != null) {
            eyeR.setVisible(false);
        }
        if (eyeL != null) {
            eyeL.setVisible(false);
        }
        if (hurtBlink != null) {
            hurtBlink.setVisible(false);
        }
    }

    @Override
    public void renderItems(IModelCaps pEntityCaps) {
        GL11.glPushMatrix();
        if (Arms != null && Arms[0] != null) {
            Arms[0].loadMatrix();
            GL11.glTranslatef(0F, 0.05F, -0.05F);
            Arms[0].renderItems(this, pEntityCaps, false, 0);
        }
        if (Arms != null && Arms[1] != null) {
            Arms[1].loadMatrix();
            GL11.glTranslatef(0F, 0.05F, -0.05F);
            Arms[1].renderItems(this, pEntityCaps, false, 1);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void renderFirstPersonHand(IModelCaps pEntityCaps) {
        if (armRight != null) {
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            onGrounds[0] = onGrounds[1] = 0.0F;
            setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, pEntityCaps);
            armRight.render(0.0625F);
        }
    }

    @Override
    public float getHeight(IModelCaps pEntityCaps) {
        return customHeight;
    }

    @Override
    public float getWidth(IModelCaps pEntityCaps) {
        return customWidth;
    }

    @Override
    public float getyOffset(IModelCaps pEntityCaps) {
        return customYOffset;
    }

    @Override
    public float getMountedYOffset(IModelCaps pEntityCaps) {
        return customMountedYOffset;
    }

    @Override
    public float getHeight() {
        return customHeight;
    }

    @Override
    public float getWidth() {
        return customWidth;
    }

    @Override
    public float getyOffset() {
        return customYOffset;
    }

    @Override
    public float getMountedYOffset() {
        return customMountedYOffset;
    }

    public Map<String, BedrockPart> getModelMap() {
        return modelMap;
    }
}
