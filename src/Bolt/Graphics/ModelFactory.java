package Bolt.Graphics;

import Bolt.Graphics.OpenGL.Vertex;
import org.lwjgl.opengl.GL41;

public class ModelFactory
{

    public static Model CreateRectangle(float width, float height)
    {
        Vertex[] vertices = new Vertex[]{
            new Vertex(-0.5f, 0.5f, 0, 1),
            new Vertex(-0.5f, -0.5f, 0, 0),
            new Vertex(0.5f, -0.5f, 1, 0),
            new Vertex(0.5f, 0.5f, 1, 1)
        };
        int[] indices = new int[]{ 0, 1, 2, 0, 2, 3 };
        return new Model(vertices, indices);
    }

    public static Model CreateEllipse(float width, float height, int vertexCount)
    {
        Vertex[] vertices = new Vertex[vertexCount + 1];
        int[] indices = new int[vertexCount * 3];
        float rx = width / 2.0f;
        float ry = height / 2.0f;
        float dtheta = (float)Math.PI * 2.0f / vertexCount;
        vertices[0] = new Vertex(0, 0, 0.5f, 0.5f);
        for (int i = 0; i < vertexCount; i++)
        {
            float x = (float)Math.cos(i * dtheta);
            float y = (float)Math.sin(i * dtheta);
            float realX = rx * x;
            float realY = ry * y;
            float tx = (x + 1.0f) / 2.0f;
            float ty = (y + 1.0f) / 2.0f;
            vertices[i + 1] = new Vertex(realX, realY, tx, ty);
            indices[i * 3 + 0] = 0;
            indices[i * 3 + 1] = i + 1;
            indices[i * 3 + 2] = i + 2;
        }
        indices[vertexCount * 3 - 1] = 1;
        return new Model(vertices, indices);
    }

    public static Model CreateWireframeRectangle(float width, float height)
    {
        Vertex[] vertices = new Vertex[]{
                new Vertex(-0.5f, 0.5f, 0, 1),
                new Vertex(-0.5f, -0.5f, 0, 0),
                new Vertex(0.5f, -0.5f, 1, 0),
                new Vertex(0.5f, 0.5f, 1, 1)
        };
        int[] indices = new int[]{ 0, 1, 1, 2, 2, 3, 3, 0 };
        Model model = new Model(vertices, indices);
        model.GetVertexArray().SetRenderMode(GL41.GL_LINES);
        return model;
    }

    public static Model CreateWireframeEllipse(float width, float height, int vertexCount)
    {
        Vertex[] vertices = new Vertex[vertexCount];
        int[] indices = new int[vertexCount * 2];
        float rx = width / 2.0f;
        float ry = height / 2.0f;
        float dtheta = (float)Math.PI * 2.0f / vertexCount;
        for (int i = 0; i < vertexCount; i++)
        {
            float x = (float)Math.cos(i * dtheta);
            float y = (float)Math.sin(i * dtheta);
            float realX = rx * x;
            float realY = ry * y;
            float tx = (x + 1.0f) / 2.0f;
            float ty = (y + 1.0f) / 2.0f;
            vertices[i] = new Vertex(realX, realY, tx, ty);
            indices[i * 2 + 0] = i;
            indices[i * 2 + 1] = i + 1;
        }
        indices[vertexCount * 2 - 1] = 0;
        Model model = new Model(vertices, indices);
        model.GetVertexArray().SetRenderMode(GL41.GL_LINES);
        return model;
    }

}
