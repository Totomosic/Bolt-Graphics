import Bolt.Graphics.Window;
import Bolt.Graphics.Renderer;
import Bolt.Application;

import Bolt.Core.*;
import Bolt.Scene.*;
import Bolt.Graphics.*;
import java.io.File;
import java.io.IOException;

public class Bolt extends Application
{

    private Scene scene;

    @Override
    public void Init()
    {
        System.out.println(System.getProperty("user.dir"));
        scene = SceneManager.CreateScene();
        Layer layer = scene.CreateLayer();
        layer.AddRenderable(Sprite.Rectangle(300, 300, 300, 300));
        Renderable renderable = layer.AddRenderable(Sprite.Rectangle(400, 400, 300, 300, Color.White));
        try
        {
            renderable.GetMesh().GetMaterial().SetTexture(new Texture2D(new File("res/test.jpeg")));
        }
        catch (IOException e)
        {
            System.out.println("IO Error " + e.getMessage());
        }
    }

    @Override
    public void Update()
    {

    }

    @Override
    public void Render(Window window)
    {
        Renderer.RenderScene(window);
    }

    public static void main(String[] args)
    {
        Bolt app = new Bolt();
        app.Run();
    }

}
