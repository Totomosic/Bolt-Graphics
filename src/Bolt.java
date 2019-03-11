import Bolt.Application;

import Bolt.Core.*;
import Bolt.Graphics.Input.Input;
import Bolt.Graphics.Input.MouseButton;
import Bolt.Scene.*;
import Bolt.Graphics.*;

public class Bolt extends Application
{

    private Texture2D image;

    private Vector2f start;

    @Override
    public void Init()
    {
        image = Texture2D.Load("res/test.jpeg");
    }

    @Override
    public void Update()
    {
        if (Input.MousePressed(MouseButton.Left))
        {
            start = Input.CanvasMousePosition();
        }
    }

    @Override
    public void Render(Canvas canvas)
    {
        canvas.Fill(new Color(175, 175, 175, 255));
        Sprite window = canvas.FillRect(50, canvas.GetHeight() - 750, 700 * canvas.GetAspect(), 700, Color.Black);
        canvas.FillRect(window.TopRight().x + 50, window.TopRight().y - (canvas.GetHeight() - 100), canvas.GetWidth() - window.TopRight().x - 100, canvas.GetHeight() - 100, Color.White);
        if (Input.MouseDown(MouseButton.Left))
        {
            Vector2f current = Input.CanvasMousePosition();
            canvas.FillRect(start.x, start.y, current.x - start.x, current.y - start.y, new Color(50, 100, 200, 150));
            canvas.DrawRect(start.x, start.y, current.x - start.x, current.y - start.y, new Color(10, 10, 200, 255));
        }
    }

    public static void main(String[] args)
    {
        Bolt app = new Bolt();
        app.Run();
    }

}
