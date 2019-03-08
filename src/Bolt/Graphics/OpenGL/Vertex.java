package Bolt.Graphics.OpenGL;

import Bolt.Core.Vector2f;

public class Vertex
{

    public Vector2f Position;
    public Vector2f TexCoord;

    public Vertex(Vector2f position, Vector2f texCoord)
    {
        Position = position;
        TexCoord = texCoord;
    }

    public Vertex(float x, float y, float tx, float ty)
    {
        this(new Vector2f(x, y), new Vector2f(tx, ty));
    }

    public Vertex()
    {
        this(new Vector2f(), new Vector2f());
    }

}
