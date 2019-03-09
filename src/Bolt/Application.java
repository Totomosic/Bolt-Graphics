package Bolt;

import Bolt.Core.Time.Time;
import Bolt.Graphics.Window;
import Bolt.Graphics.Input.Input;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Application {

    private static Application s_Instance = null;

    private final Window m_Window;
    private boolean m_ShouldClose;

    public Application()
    {
        m_Window = new Window(1280, 720, "Bolt-Graphics");
        m_ShouldClose = false;
        s_Instance = this;
    }

    public static Application Instance()
    {
        return s_Instance;
    }

    public Window GetCanvas()
    {
        return m_Window;
    }

    public void Init()
    {

    }

    public void Update()
    {

    }

    public void Render(Window window)
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
            m_Window.Clear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            Render(m_Window);
            m_Window.SwapBuffers();
            Input.Update();
        }
    }

}
