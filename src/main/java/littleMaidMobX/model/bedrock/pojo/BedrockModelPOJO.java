package littleMaidMobX.model.bedrock.pojo;

import com.google.gson.annotations.SerializedName;

public class BedrockModelPOJO {

    @SerializedName("format_version")
    private String formatVersion;

    @SerializedName("geometry.model")
    private GeometryModelLegacy geometryModelLegacy;

    @SerializedName("minecraft:geometry")
    private GeometryModelNew[] geometryModelNew;

    public String getFormatVersion() {
        return formatVersion;
    }

    public GeometryModelLegacy getGeometryModelLegacy() {
        return geometryModelLegacy;
    }

    public GeometryModelNew getGeometryModelNew() {
        if (geometryModelNew == null || geometryModelNew.length == 0) {
            return null;
        }
        return geometryModelNew[0];
    }
}
