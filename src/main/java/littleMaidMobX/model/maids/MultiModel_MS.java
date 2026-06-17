package littleMaidMobX.model.maids;

import littleMaidMobX.model.caps.IModelCaps;
import littleMaidMobX.model.caps.ModelCapsHelper;

public class MultiModel_MS extends MultiModel_MS1 {

    public MultiModel_MS(StringBuilder hack) {
        super(hack);
    }

    public MultiModel_MS() {
        this(0.0F);
    }

    public MultiModel_MS(float f) {
        this(f, 0.0F);
    }

    public MultiModel_MS(float f, float f1) {
        this(f, f1, 64, 64);
    }

    public MultiModel_MS(float f, float f1, int i, int j) {
        super(f, f1, i < 0 ? 64 : i, j < 0 ? 64 : j);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5,
        IModelCaps entityCaps) {
        super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entityCaps);
        Goggles1A.setVisible(false);
        Goggles2A.setVisible(false);
        Goggles3A.setVisible(false);
        GogglesRA.setVisible(false);
        GogglesLA.setVisible(false);
        if (ModelCapsHelper.getCapsValueBoolean(this, entityCaps, caps_aimedBow)) {
            setCapsValue(entityCaps, caps_visible, eyeR, false);
            setCapsValue(entityCaps, caps_visible, eyeL, true);
            Goggles1.setVisible(false);
            Goggles2.setVisible(false);
            Goggles3.setVisible(false);
            GogglesR.setVisible(false);
            GogglesL.setVisible(false);
            Goggles1A.setVisible(true);
            Goggles2A.setVisible(true);
            Goggles3A.setVisible(true);
            GogglesRA.setVisible(true);
            GogglesLA.setVisible(true);
        } else {
            Goggles1.setVisible(true);
            Goggles2.setVisible(true);
            Goggles3.setVisible(true);
            GogglesR.setVisible(true);
            GogglesL.setVisible(true);
            Goggles1A.setVisible(false);
            Goggles2A.setVisible(false);
            Goggles3A.setVisible(false);
            GogglesRA.setVisible(false);
            GogglesLA.setVisible(false);
        }
    }
}
