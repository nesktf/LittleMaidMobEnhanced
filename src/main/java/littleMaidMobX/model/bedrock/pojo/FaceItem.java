package littleMaidMobX.model.bedrock.pojo;

import com.google.gson.annotations.SerializedName;

public class FaceItem {

    @SerializedName("uv")
    private float[] uv;

    @SerializedName("uv_size")
    private float[] uvSize;

    @SerializedName("uv_rotation")
    private int uvRotation = 0;

    public FaceItem(float[] uv, float[] uvSize) {
        this.uv = uv;
        this.uvSize = uvSize;
    }

    public float[] getUv() {
        return uv;
    }

    public float[] getUvSize() {
        return uvSize;
    }

    public int getUvRotation() {
        return uvRotation;
    }

    public float[] getRotatedUVs(float texWidth, float texHeight) {
        if (uv == null || uvSize == null) {
            return new float[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        }
        float u1 = uv[0] / texWidth;
        float v1 = uv[1] / texHeight;
        float u2 = (uv[0] + uvSize[0]) / texWidth;
        float v2 = (uv[1] + uvSize[1]) / texHeight;

        switch (uvRotation) {
            case 90:
                return new float[] { u1, v1, u1, v2, u2, v2, u2, v1 };
            case 180:
                return new float[] { u1, v2, u2, v2, u2, v1, u1, v1 };
            case 270:
                return new float[] { u2, v2, u2, v1, u1, v1, u1, v2 };
            default:
                return new float[] { u2, v1, u1, v1, u1, v2, u2, v2 };
        }
    }
}
