package littleMaidMobX.model.bedrock;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import littleMaidMobX.model.bedrock.pojo.BedrockModelPOJO;
import littleMaidMobX.model.bedrock.pojo.CubesItem;

public class BedrockModelParser {

    public static final Gson GSON = new GsonBuilder().registerTypeAdapter(CubesItem.class, new CubesItem.Deserializer())
        .create();

    public static BedrockModelPOJO parse(InputStream stream) {
        if (stream == null) {
            return null;
        }
        return parse(new InputStreamReader(stream, StandardCharsets.UTF_8));
    }

    public static BedrockModelPOJO parse(Reader reader) {
        if (reader == null) {
            return null;
        }
        try {
            return GSON.fromJson(reader, BedrockModelPOJO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BedrockModelPOJO parse(String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            return GSON.fromJson(json, BedrockModelPOJO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
