package Bolt.Scene;

import java.util.ArrayList;
import java.util.List;

public class Scene
{

    private final List<Layer> m_Layers;
    private final Camera m_DefaultCamera;

    public Scene()
    {
        m_Layers = new ArrayList<>();
        m_DefaultCamera = new Camera();
    }

    public List<Layer> GetLayers()
    {
        return m_Layers;
    }

    public Camera GetDefaultCamera()
    {
        return m_DefaultCamera;
    }

    public Layer CreateLayer(Camera camera)
    {
        Layer l = new Layer(camera);
        m_Layers.add(l);
        return l;
    }

    public Layer CreateLayer()
    {
        return CreateLayer(m_DefaultCamera);
    }

}
