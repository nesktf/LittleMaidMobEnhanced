package littleMaidMobX.render.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

public class ModelBoxTriangles implements IRenderable {

    // keep it private, if it doesnt change we can calculate normals once, plus use display lists later on
    private PositionTextureVertex[] vertexPositions;

    public int nVertices;
    private boolean invertNormal;
    public int red;
    public int green;
    public int blue;
    public int alpha;
    private boolean setColor;
    Vec3[] normals;

    public ModelBoxTriangles(int texOffsetX, int texOffsetY, float[][] vertices, float[][] texCoords, float[][] normalf,
        float[] rgba) {
        if (rgba != null) {
            red = (int) (255.0F * rgba[0]);
            green = (int) (255.0F * rgba[1]);
            blue = (int) (255.0F * rgba[2]);
            alpha = (int) (255.0F * rgba[3] * 0.5F);
            setColor = true;
        } else {
            red = 255;
            green = 255;
            blue = 255;
            alpha = 255;
            setColor = false;
        }
        float texScaleX = 1.0F;
        float texScaleY = 1.0F;
        nVertices = vertices.length;
        vertexPositions = new PositionTextureVertex[nVertices];
        normals = new Vec3[nVertices];

        for (int i = 0; i < nVertices; ++i) {
            vertexPositions[i] = new PositionTextureVertex(
                vertices[i][0],
                vertices[i][1],
                vertices[i][2],
                texCoords[i][0] / texScaleX,
                texCoords[i][1] / texScaleY);
        }
        if (normalf == null) {
            Vec3 vec3_1 = vertexPositions[1].vector3D;
            Vec3 vec3_0 = vec3_1.subtract(vertexPositions[0].vector3D);
            Vec3 vec3_2 = vec3_1.subtract(vertexPositions[2].vector3D);

            for (int i = 0; i < nVertices; ++i) {
                normals[i] = vec3_2.crossProduct(vec3_0)
                    .normalize();
            }
        } else {
            for (int i = 0; i < nVertices; ++i) {
                normals[i] = Vec3
                    .createVectorHelper((double) normalf[i][0], (double) normalf[i][1], (double) normalf[i][2]);
            }
        }
    }

    public void flipFace() {
        PositionTextureVertex[] o = new PositionTextureVertex[vertexPositions.length];
        for (int var2 = 0; var2 < vertexPositions.length; ++var2) {
            o[var2] = vertexPositions[vertexPositions.length - var2 - 1];
        }
        vertexPositions = o;
    }

    @Override
    public void render(Tessellator tessellator, float f) {

        GL11.glShadeModel(GL11.GL_SMOOTH);
        byte by = GL11.GL_TRIANGLE_FAN;
        //
        if (nVertices % 4 == 0) {
            by = GL11.GL_QUADS;
        }
        tessellator.startDrawing(by);

        for (int i1 = 0; i1 < nVertices; ++i1) {
            if (invertNormal) {
                tessellator
                    .setNormal((float) -normals[i1].xCoord, (float) -normals[i1].yCoord, (float) -normals[i1].zCoord);
            } else {
                tessellator
                    .setNormal((float) normals[i1].xCoord, (float) normals[i1].yCoord, (float) normals[i1].zCoord);
            }

            PositionTextureVertex vertexPosition = vertexPositions[i1];
            Vec3 vertexPositionVec3 = vertexPosition.vector3D;
            tessellator.addVertexWithUV(
                vertexPositionVec3.xCoord * f,
                vertexPositionVec3.yCoord * f,
                vertexPositionVec3.zCoord * f,
                vertexPosition.texturePositionX,
                vertexPosition.texturePositionY);
        }

        tessellator.draw();
    }

}
