import Bolt.Application;

import Bolt.Core.*;
import Bolt.Scene.*;
import Bolt.Graphics.*;

public class Bolt extends Application
{

    private Texture2D image;

    @Override
    public void Init()
    {
        image = Texture2D.Load("res/test.jpeg");
    }

    @Override
    public void Update()
    {

    }

    @Override
    public void Render(Canvas canvas)
    {
        canvas.Fill(new Color(175, 175, 175, 255));
        Sprite window = canvas.FillRect(50, canvas.GetHeight() - 750, 700 * canvas.GetAspect(), 700, Color.Black);
        canvas.FillRect(window.TopRight().x + 50, window.TopRight().y - (canvas.GetHeight() - 100), canvas.GetWidth() - window.TopRight().x - 100, canvas.GetHeight() - 100, Color.White);
    }

    public static void main(String[] args)
    {
        Bolt app = new Bolt();
        app.Run();
    }

}
