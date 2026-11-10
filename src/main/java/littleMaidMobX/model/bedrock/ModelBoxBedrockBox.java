package littleMaidMobX.model.bedrock;

import net.minecraft.client.renderer.Tessellator;

import littleMaidMobX.render.model.ModelBoxBase;

public class ModelBoxBedrockBox extends ModelBoxBase {

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

    private static final int[][] UV_ORDER_NO_MIRROR = new int[][] { { 1, 2, 6, 7 }, { 2, 3, 7, 6 }, { 1, 2, 7, 8 },
        { 4, 5, 7, 8 }, { 0, 1, 7, 8 }, { 2, 4, 7, 8 }, };

    private static final int[][] UV_ORDER_MIRRORED = new int[][] { { 2, 1, 6, 7 }, { 3, 2, 7, 6 }, { 2, 1, 7, 8 },
        { 5, 4, 7, 8 }, { 4, 2, 7, 8 }, { 1, 0, 7, 8 }, };

    private final float[][] vertices = new float[8][3];
    private final float[][] faceUVs = new float[6][8];

    public ModelBoxBedrockBox(float texOffX, float texOffY, float x, float y, float z, float width, float height,
        float depth, float delta, boolean mirror, float texWidth, float texHeight) {

        float x1 = x - delta;
        float y1 = y - delta;
        float z1 = z - delta;
        float x2 = x + width + delta;
        float y2 = y + height + delta;
        float z2 = z + depth + delta;

        if (mirror) {
            float temp = x1;
            x1 = x2;
            x2 = temp;
        }

        // 8 box vertices
        vertices[0] = new float[] { x1, y1, z1 };
        vertices[1] = new float[] { x2, y1, z1 };
        vertices[2] = new float[] { x2, y2, z1 };
        vertices[3] = new float[] { x1, y2, z1 };
        vertices[4] = new float[] { x1, y1, z2 };
        vertices[5] = new float[] { x2, y1, z2 };
        vertices[6] = new float[] { x2, y2, z2 };
        vertices[7] = new float[] { x1, y2, z2 };

        float dx = (float) Math.floor(width);
        float dy = (float) Math.floor(height);
        float dz = (float) Math.floor(depth);

        float scaleU = 1.0F / texWidth;
        float scaleV = 1.0F / texHeight;

        float[] uvs = new float[9];
        uvs[0] = scaleU * texOffX;
        uvs[1] = scaleU * (texOffX + dz);
        uvs[2] = scaleU * (texOffX + dz + dx);
        uvs[3] = scaleU * (texOffX + dz + dx + dx);
        uvs[4] = scaleU * (texOffX + dz + dx + dz);
        uvs[5] = scaleU * (texOffX + dz + dx + dz + dx);
        uvs[6] = scaleV * texOffY;
        uvs[7] = scaleV * (texOffY + dz);
        uvs[8] = scaleV * (texOffY + dz + dy);

        int[][] uvOrder = mirror ? UV_ORDER_MIRRORED : UV_ORDER_NO_MIRROR;

        for (int i = 0; i < 6; i++) {
            faceUVs[i][0] = uvs[uvOrder[i][1]];
            faceUVs[i][1] = uvs[uvOrder[i][2]];
            faceUVs[i][2] = uvs[uvOrder[i][0]];
            faceUVs[i][3] = uvs[uvOrder[i][2]];
            faceUVs[i][4] = uvs[uvOrder[i][0]];
            faceUVs[i][5] = uvs[uvOrder[i][3]];
            faceUVs[i][6] = uvs[uvOrder[i][1]];
            faceUVs[i][7] = uvs[uvOrder[i][3]];
        }
    }

    @Override
    public void render(Tessellator tessellator, float scale) {
        tessellator.startDrawingQuads();
        for (int i = 0; i < 6; i++) {
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
