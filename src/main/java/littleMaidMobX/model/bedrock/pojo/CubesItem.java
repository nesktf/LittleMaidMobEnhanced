package littleMaidMobX.model.bedrock.pojo;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CubesItem {

    private float[] uv;
    private FaceUVsItem faceUv;
    private boolean mirror = false;
    private boolean hasMirror = false;

    @Expose
    @SerializedName("inflate")
    private float inflate;

    @Expose
    @SerializedName("size")
    private float[] size;

    @Expose
    @SerializedName("origin")
    private float[] origin;

    @Expose
    @SerializedName("rotation")
    private float[] rotation;

    @Expose
    @SerializedName("pivot")
    private float[] pivot;

    public float[] getUv() {
        return uv;
    }

    public FaceUVsItem getFaceUv() {
        return faceUv;
    }

    public boolean isMirror() {
        return mirror;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public boolean isHasMirror() {
        return hasMirror;
    }

    public float getInflate() {
        return inflate;
    }

    public float[] getSize() {
        return size;
    }

    public float[] getOrigin() {
        return origin;
    }

    public float[] getRotation() {
        return rotation;
    }

    public float[] getPivot() {
        return pivot;
    }

    public static class Deserializer implements JsonDeserializer<CubesItem> {

        @Override
        public CubesItem deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
            CubesItem cube = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                .create()
                .fromJson(json, CubesItem.class);
            if (json != null && json.isJsonObject()) {
                JsonObject obj = json.getAsJsonObject();

                JsonElement uvElement = obj.get("uv");
                if (uvElement != null) {
                    if (uvElement.isJsonArray()) {
                        JsonArray array = uvElement.getAsJsonArray();
                        cube.uv = new float[array.size()];
                        for (int i = 0; i < array.size(); i++) {
                            cube.uv[i] = array.get(i)
                                .getAsFloat();
                        }
                    } else if (uvElement.isJsonObject()) {
                        cube.faceUv = new Gson().fromJson(uvElement, FaceUVsItem.class);
                    }
                }

                JsonElement mirrorElement = obj.get("mirror");
                if (mirrorElement != null && mirrorElement.isJsonPrimitive()) {
                    JsonPrimitive primitive = mirrorElement.getAsJsonPrimitive();
                    if (primitive.isBoolean()) {
                        cube.mirror = primitive.getAsBoolean();
                        cube.hasMirror = true;
                    }
                }
            }
            return cube;
        }
    }
}
