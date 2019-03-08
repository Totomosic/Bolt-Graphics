package Bolt.Graphics;

import Bolt.Graphics.OpenGL.Vertex;
import Bolt.Graphics.OpenGL.VertexArray;
import org.lwjgl.opengl.GL41;

public class Model
{

    public static final Model Square = new Model(new Vertex[]{ new Vertex(-0.5f, 0.5f, 0, 1),
                                                                new Vertex(-0.5f, -0.5f, 0, 0),
                                                                new Vertex(0.5f, -0.5f, 1, 0),
                                                                new Vertex(0.5f, 0.5f, 1, 1) },
                                                    new int[]{ 0, 1, 2, 0, 2, 3 });

    private final VertexArray m_Vertices;

    public Model(Vertex[] vertices, int[] indices)
    {
        m_Vertices = new VertexArray(vertices.length, indices.length);
        m_Vertices.SetVertices(vertices);
        m_Vertices.SetIndices(indices);
    }

    public VertexArray GetVertexArray()
    {
        return m_Vertices;
    }

    public int GetRenderCount()
    {
        return m_Vertices.GetIndexBuffer().IndexCount();
    }

    public int GetRenderMode()
    {
        return GL41.GL_TRIANGLES;
    }

}
