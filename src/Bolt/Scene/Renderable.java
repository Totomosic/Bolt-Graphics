package Bolt.Scene;

import Bolt.Graphics.Mesh;

public class Renderable extends GameObject
{

    private Mesh m_Mesh;

    public Renderable(Transform transform, Mesh mesh)
    {
        super(transform);
        m_Mesh = mesh;
    }

    public Renderable(Mesh mesh)
    {
        super();
        m_Mesh = mesh;
    }

    public Renderable(float x, float y, Mesh mesh)
    {
        super(x, y);
        m_Mesh = mesh;
    }

    public Mesh GetMesh()
    {
        return m_Mesh;
    }

    public void SetMesh(Mesh mesh)
    {
        m_Mesh = mesh;
    }

}
