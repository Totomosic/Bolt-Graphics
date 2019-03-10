package Bolt.Graphics;

import Bolt.Core.Color;
import Bolt.Core.Matrix4f;
import Bolt.Core.Vector2f;
import Bolt.Graphics.OpenGL.Shader;
import Bolt.Scene.Camera;
import Bolt.Scene.Layer;
import Bolt.Scene.Sprite;
import Bolt.Scene.Transform;
import org.lwjgl.opengl.GL41;

public class Canvas
{

    private final Window m_Window;
    private final Camera m_Camera;
    private final int m_Width;
    private final int m_Height;
    private final Layer m_Layer;

    public Canvas(int windowWidth, int windowHeight, int canvasWidth, int canvasHeight, String title)
    {
        m_Window = new Window(windowWidth, windowHeight, title);
        m_Camera = new Camera(Matrix4f.Orthographic(0, canvasWidth, 0, canvasHeight, -100, 100));
        m_Width = canvasWidth;
        m_Height = canvasHeight;
        m_Layer = new Layer(m_Camera);
    }

    public Window GetWindow()
    {
        return m_Window;
    }

    public int GetWidth()
    {
        return m_Width;
    }

    public int GetHeight()
    {
        return m_Height;
    }

    public float GetAspect()
    {
        return (float)GetWidth() / (float)GetHeight();
    }

    public void StrokeWeight(float weight)
    {
        GL41.glLineWidth(weight);
    }

    public Sprite Fill(Color color)
    {
        return FillRect(0, 0, GetWidth(), GetHeight(), color);
    }

    public Sprite Fill(Texture2D texture)
    {
        return DrawImage(0, 0, GetWidth(), GetHeight(), texture);
    }

    public Sprite FillRect(float x, float y, float w, float h, Color color)
    {
        Sprite s = Sprite.Rectangle(x + w / 2.0f, y + h / 2.0f, w, h, color);
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite FillRect(float x, float y, float w, float h)
    {
        return FillRect(x, y, w, h, Color.White);
    }

    public Sprite FillEllipse(float x, float y, float w, float h, Color color)
    {
        Sprite s = Sprite.Ellipse(x + w / 2.0f, y + h / 2.0f, w, h, color);
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite FillEllipse(float x, float y, float w, float h)
    {
        return FillEllipse(x, y, w, h, Color.White);
    }

    public Sprite DrawLine(float x0, float y0, float x1, float y1, float thickness, Color color)
    {
        float mx = (x0 + x1) / 2.0f;
        float my = (y0 + y1) / 2.0f;
        float theta = (float)Math.atan2((y1 - y0), (x1 - x0));
        float length = Vector2f.Sub(new Vector2f(x0, y0), new Vector2f(x1, y1)).Length();
        Sprite s = new Sprite(new Transform(new Vector2f(mx, my), new Vector2f(length, thickness)), new Mesh(Model.Line, new Material(Shader.Default, color)));
        s.GetTransform().Rotate(theta);
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite DrawLine(float x0, float y0, float x1, float y1, float thickness)
    {
        return DrawLine(x0, y0, x1, y1, thickness, Color.White);
    }

    public Sprite DrawLine(float x0, float y0, float x1, float y1, Color color)
    {
        return DrawLine(x0, y0, x1, y1, 1.0f, color);
    }

    public Sprite DrawLine(float x0, float y0, float x1, float y1)
    {
        return DrawLine(x0, y0, x1, y1, Color.White);
    }

    public Sprite DrawRect(float x, float y, float w, float h, Color color)
    {
        Sprite s = new Sprite(new Transform(new Vector2f(x + w / 2.0f, y + h / 2.0f), new Vector2f(w, h)), new Mesh(Model.WireframeSquare, new Material(Shader.Default, color)));
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite DrawRect(float x, float y, float w, float h)
    {
        return DrawRect(x, y, w, h, Color.White);
    }

    public Sprite DrawEllipse(float x, float y, float w, float h, Color color)
    {
        Sprite s = new Sprite(new Transform(new Vector2f(x + w / 2.0f, y + h / 2.0f), new Vector2f(w / 2.0f, h / 2.0f)), new Mesh(Model.WireframeCircle, new Material(Shader.Default, color)));
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite DrawImage(float x, float y, float w, float h, Texture2D texture)
    {
        Sprite s = Sprite.Image(x + w / 2.0f, y + h / 2.0f, w, h, texture);
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite DrawImage(float x, float y, Texture2D texture)
    {
        return DrawImage(x, y, texture.GetWidth(), texture.GetHeight(), texture);
    }

    public Sprite DrawImageEllipse(float x, float y, float w, float h, Texture2D texture)
    {
        Sprite s = Sprite.Ellipse(x + w / 2.0f, y + h / 2.0f, w, h, Color.White);
        s.GetMesh().GetMaterial().SetTexture(texture);
        m_Layer.AddRenderable(s);
        return s;
    }

    public Sprite DrawImageEllipse(float x, float y, Texture2D texture)
    {
        return DrawImageEllipse(x, y, texture.GetWidth(), texture.GetHeight(), texture);
    }

    public void BlitToWindow()
    {
        Renderer.Render(m_Layer);
        m_Layer.Clear();
    }

}
