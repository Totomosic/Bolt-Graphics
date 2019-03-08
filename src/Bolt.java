import Bolt.Graphics.Canvas;
import Bolt.Graphics.OpenGL.Shader;
import Bolt.Graphics.Renderer;
import Bolt.Graphics.Model;
import Bolt.Application;

public class Bolt extends Application
{

    @Override
    public void Init()
    {

    }

    @Override
    public void Update()
    {

    }

    @Override
    public void Render(Canvas canvas)
    {
        Renderer.Render(Model.Square, Shader.Default);
    }

    public static void main(String[] args)
    {
        Bolt app = new Bolt();
        app.Run();
    }

}
