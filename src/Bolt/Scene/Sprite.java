package Bolt.Scene;

import Bolt.Core.Color;
import Bolt.Core.Vector2f;
import Bolt.Graphics.Material;
import Bolt.Graphics.Mesh;
import Bolt.Graphics.Model;
import Bolt.Graphics.OpenGL.Shader;

public class Sprite extends Renderable
{

    public Sprite(Transform transform, Mesh mesh)
    {
        super(transform, mesh);
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

}
