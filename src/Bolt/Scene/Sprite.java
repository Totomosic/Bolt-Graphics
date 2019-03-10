package Bolt.Scene;

import Bolt.Core.Color;
import Bolt.Core.Vector2f;
import Bolt.Graphics.Material;
import Bolt.Graphics.Mesh;
import Bolt.Graphics.Model;
import Bolt.Graphics.OpenGL.Shader;
import Bolt.Graphics.OpenGL.Vertex;
import Bolt.Graphics.OpenGL.VertexArray;
import Bolt.Graphics.Texture2D;

public class Sprite extends Renderable
{

    private float m_Width;
    private float m_Height;
    private boolean m_IsValid;

    public Sprite(Transform transform, Mesh mesh)
    {
        super(transform, mesh);
        m_Width = 0;
        m_Height = 0;
        m_IsValid = false;
    }

    public float GetWidth()
    {
        if (!m_IsValid)
        {
            CalculateModelSize();
        }
        return m_Width;
    }

    public float GetHeight()
    {
        if (!m_IsValid)
        {
            CalculateModelSize();
        }
        return m_Height;
    }

    public Vector2f TopRight()
    {
        return Vector2f.Add(Center(), Vector2f.Div(new Vector2f(GetWidth(), GetHeight()), 2.0f));
    }

    public Vector2f BottomLeft()
    {
        return Vector2f.Sub(Center(), Vector2f.Div(new Vector2f(GetWidth(), GetHeight()), 2.0f));
    }

    public Vector2f Center()
    {
        return GetTransform().GetPosition();
    }

    public static Sprite Rectangle(float x, float y, float width, float height, Color color)
    {
        Material material = new Material(Shader.Default, color);
        return new Sprite(new Transform(new Vector2f(x, y), new Vector2f(width, height)), new Mesh(Model.Square, material));
    }

    public static Sprite Rectangle(float x, float y, float width, float height)
    {
        return Rectangle(x, y, width, height, Color.White);
    }

    public static Sprite Ellipse(float x, float y, float width, float height, Color color)
    {
        Material material = new Material(Shader.Default, color);
        return new Sprite(new Transform(new Vector2f(x, y), new Vector2f(width / 2.0f, height / 2.0f)), new Mesh(Model.Circle, material));
    }

    public static Sprite Image(float x, float y, float width, float height, Texture2D texture)
    {
        Material material = new Material(Shader.Texture, Color.White);
        material.SetTexture(texture);
        return new Sprite(new Transform(new Vector2f(x, y), new Vector2f(width, height)), new Mesh(Model.Square, material));
    }

    private void CalculateModelSize()
    {
        Model model = GetMesh().GetModel();
        VertexArray vao = model.GetVertexArray();
        Vertex[] vertices = vao.GetVertices();

        float minX = (float)+1e10;
        float maxX = (float)-1e10;
        float minY = (float)+1e10;
        float maxY = (float)-1e10;
        for (Vertex v : vertices)
        {
            float x = v.Position.x;
            float y = v.Position.y;
            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            minY = Math.min(x, minY);
            maxY = Math.max(x, maxY);
        }
        assert minX < maxX;
        assert minY < maxY;
        Vector2f scale = GetTransform().GetScale();
        m_Width = scale.x * (maxX - minX);
        m_Height = scale.y * (maxY - minY);
        m_IsValid = true;
    }

}
