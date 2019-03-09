package Bolt.Scene;

import java.util.ArrayList;
import java.util.List;

public class Layer
{

    private final Camera m_Camera;
    private final List<Renderable> m_Renderables;
    private boolean m_IsEnabled;

    public Layer(Camera camera)
    {
        m_Camera = camera;
        m_Renderables = new ArrayList<>();
        m_IsEnabled = true;
    }

    public boolean IsEnabled()
    {
        return m_IsEnabled;
    }

    public Camera GetCamera()
    {
        return m_Camera;
    }

    public List<Renderable> GetRenderables()
    {
        return m_Renderables;
    }

    public Renderable AddRenderable(Renderable renderable)
    {
        m_Renderables.add(renderable);
        return renderable;
    }

    public void RemoveRenderable(Renderable renderable)
    {
        m_Renderables.remove(renderable);
    }

    public void Clear()
    {
        m_Renderables.clear();
    }

    public void SetEnabled(boolean isEnabled)
    {
        m_IsEnabled = isEnabled;
    }

    public void Enable()
    {
        SetEnabled(true);
    }

    public void Disable()
    {
        SetEnabled(false);
    }

}
