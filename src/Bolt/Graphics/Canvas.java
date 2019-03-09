package Bolt.Graphics;

public class Canvas
{

    private final Window m_Window;

    public Canvas(int width, int height, String title)
    {
        m_Window = new Window(width, height, title);
    }

    public Window GetWindow()
    {
        return m_Window;
    }

}
