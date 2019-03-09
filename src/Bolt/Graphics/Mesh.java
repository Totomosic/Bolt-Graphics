package Bolt.Graphics;

public class Mesh
{

    private Model m_Model;
    private Material m_Material;

    public Mesh(Model model, Material material)
    {
        m_Model = model;
        m_Material = material;
    }

    public Mesh(Model model)
    {
        this(model, new Material());
    }

    public Model GetModel()
    {
        return m_Model;
    }

    public Material GetMaterial()
    {
        return m_Material;
    }

}
