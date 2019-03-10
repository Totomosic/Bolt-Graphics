package Bolt.Graphics;

import Bolt.Graphics.OpenGL.Vertex;
import Bolt.Graphics.OpenGL.VertexArray;

public class Model
{

    public static final Model Square = ModelFactory.CreateRectangle(1, 1);
    public static final Model Circle = ModelFactory.CreateEllipse(2, 2, 1000);
    public static final Model Line = Square;
    public static final Model WireframeSquare = ModelFactory.CreateWireframeRectangle(1, 1);
    public static final Model WireframeCircle = ModelFactory.CreateWireframeEllipse(2, 2, 1000);

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

}
