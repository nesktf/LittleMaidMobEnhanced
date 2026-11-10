package littleMaidMobX.model.bedrock;

import net.minecraft.client.renderer.Tessellator;

import littleMaidMobX.model.bedrock.pojo.FaceItem;
import littleMaidMobX.model.bedrock.pojo.FaceUVsItem;
import littleMaidMobX.render.model.ModelBoxBase;

public class ModelBoxBedrockPerFace extends ModelBoxBase {

    private static final int[][] VERTEX_ORDER = new int[][] { { 5, 4, 0, 1 }, // Down (-Y)
        { 2, 3, 7, 6 }, // Up (+Y)
        { 1, 0, 3, 2 }, // North (-Z)
        { 4, 5, 6, 7 }, // South (+Z)
        { 0, 4, 7, 3 }, // West (-X)
        { 5, 1, 2, 6 }, // East (+X)
    };

    private static final float[][] NORMALS = new float[][] { { 0.0F, -1.0F, 0.0F }, // Down
        { 0.0F, 1.0F, 0.0F }, // Up
        { 0.0F, 0.0F, -1.0F }, // North
        { 0.0F, 0.0F, 1.0F }, // South
        { -1.0F, 0.0F, 0.0F }, // West
        { 1.0F, 0.0F, 0.0F } // East
    };

    private final float[][] vertices = new float[8][3];
    private final float[][] faceUVs = new float[6][8];
    private int emptyFacesMask = 0;

    public ModelBoxBedrockPerFace(float x, float y, float z, float width, float height, float depth, float delta,
        float texWidth, float texHeight, FaceUVsItem faces) {

        float x1 = x - delta;
        float y1 = y - delta;
        float z1 = z - delta;
        float x2 = x + width + delta;
        float y2 = y + height + delta;
        float z2 = z + depth + delta;

        // 8 box vertices
        vertices[0] = new float[] { x1, y1, z1 };
        vertices[1] = new float[] { x2, y1, z1 };
        vertices[2] = new float[] { x2, y2, z1 };
        vertices[3] = new float[] { x1, y2, z1 };
        vertices[4] = new float[] { x1, y1, z2 };
        vertices[5] = new float[] { x2, y1, z2 };
        vertices[6] = new float[] { x2, y2, z2 };
        vertices[7] = new float[] { x1, y2, z2 };

        if (faces != null) {
            for (int i = 0; i < 6; i++) {
                FaceItem face = faces.getFace(i);
                if (face == null || isFaceEmpty(face)) {
                    emptyFacesMask |= (1 << i);
                } else {
                    float[] rotatedUVs = face.getRotatedUVs(texWidth, texHeight);
                    System.arraycopy(rotatedUVs, 0, faceUVs[i], 0, 8);
                }
            }
        } else {
            emptyFacesMask = 0x3F; // All 6 faces empty
        }
    }

    private static boolean isFaceEmpty(FaceItem face) {
        float[] uvSize = face.getUvSize();
        if (uvSize == null || uvSize.length < 2) {
            return true;
        }
        return Math.abs(uvSize[0]) < 1e-6F && Math.abs(uvSize[1]) < 1e-6F;
    }

    @Override
    public void render(Tessellator tessellator, float scale) {
        tessellator.startDrawingQuads();
        for (int i = 0; i < 6; i++) {
            if ((emptyFacesMask & (1 << i)) != 0) {
                continue;
            }
            tessellator.setNormal(NORMALS[i][0], NORMALS[i][1], NORMALS[i][2]);
            for (int j = 0; j < 4; j++) {
                int vIdx = VERTEX_ORDER[i][j];
                tessellator.addVertexWithUV(
                    vertices[vIdx][0] * scale,
                    vertices[vIdx][1] * scale,
                    vertices[vIdx][2] * scale,
                    faceUVs[i][j * 2],
                    faceUVs[i][j * 2 + 1]);
            }
        }
        tessellator.draw();
    }
}
