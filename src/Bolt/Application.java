package Bolt;

import Bolt.Core.Time.Time;
import Bolt.Graphics.Canvas;
import Bolt.Graphics.Input.Input;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Application {

    private static Application s_Instance = null;

    private final Canvas m_Canvas;
    private boolean m_ShouldClose;

    public Application()
    {
        // Window is only 1280x720 but canvas resolution is 1920x1080
        m_Canvas = new Canvas(1280, 720, 1920, 1080, "Bolt-Graphics");
        m_ShouldClose = false;
        s_Instance = this;
    }

    public static Application Instance()
    {
        return s_Instance;
    }

    public Canvas GetCanvas()
    {
        return m_Canvas;
    }

    public void Init()
    {

    }

    public void Update()
    {

    }

    public void Render(Canvas canvas)
    {

    }

    public void Close()
    {
        m_ShouldClose = true;
    }

    public final void Run()
    {
        Time.Reset();
        Init();
        while (!m_ShouldClose)
        {
            Time.Update();
            GLFW.glfwPollEvents();
            Update();
            m_Canvas.GetWindow().Clear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            Render(m_Canvas);
            m_Canvas.BlitToWindow();
            m_Canvas.GetWindow().SwapBuffers();
            Input.Update();
        }
    }

}
