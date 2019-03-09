package Bolt.Graphics;

import Bolt.Core.Color;
import Bolt.Graphics.OpenGL.Shader;
import com.sun.istack.internal.Nullable;

public class Material
{

    private Shader m_Shader;
    private Color m_Color;
    private Texture2D m_Texture;

    public Material(Shader shader, Color baseColor)
    {
        m_Shader = shader;
        m_Color = baseColor;
        m_Texture = null;
    }

    public Material(Shader shader)
    {
        this(shader, Color.White);
    }

    public Material()
    {
        this(Shader.Default);
    }

    public Shader GetShader()
    {
        return m_Shader;
    }

    public Color GetColor()
    {
        return m_Color;
    }

    public boolean HasTexture()
    {
        return m_Texture != null;
    }

    public Texture2D GetTexture()
    {
        return m_Texture;
    }

    public void SetShader(Shader shader)
    {
        m_Shader = shader;
    }

    public void SetColor(Color color)
    {
        m_Color = color;
    }

    public void SetTexture(@Nullable Texture2D texture)
    {
        m_Texture = texture;
        if (texture != null)
        {
            m_Shader = Shader.Texture;
        }
        else
        {
            m_Shader = Shader.Default;
        }
    }
}
