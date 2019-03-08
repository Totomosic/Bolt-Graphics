package Bolt.Graphics;

import Bolt.Graphics.Input.Input;
import Bolt.Graphics.Input.WindowCloseHandler;
import Bolt.Graphics.OpenGL.GlHelper;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import Bolt.Core.Color;

public class Canvas {

    private static boolean s_InitializedGL = false;

    private final long m_Window;
    private int m_Width;
    private int m_Height;
    private String m_Title;
    private Color m_ClearColor;

    public Canvas(int width, int height, String title, Color clearColor)
    {
        m_Width = width;
        m_Height = height;
        m_Title = title;
        m_ClearColor = clearColor;
        m_Window = CreateWindow();
        if (m_Window == 0)
        {
            System.exit(-1);
        }
        SetClearColor(clearColor);
    }

    public Canvas(int width, int height, String title)
    {
        this(width, height, title, Color.Black);
    }

    public int GetWidth()
    {
        return m_Width;
    }

    public int GetHeight()
    {
        return m_Height;
    }

    public String GetTitle()
    {
        return m_Title;
    }

    public Color GetClearColor()
    {
        return m_ClearColor;
    }

    public long GetNativeWindow()
    {
        return m_Window;
    }

    public void SetClearColor(Color color)
    {
        m_ClearColor = color;
        GL11.glClearColor(m_ClearColor.r, m_ClearColor.g, m_ClearColor.b, m_ClearColor.a);
        GlHelper.CheckErrors("glClearColor");
    }

    public void Clear(int mask)
    {
        GL11.glClear(mask);
        GlHelper.CheckErrors("glClear");
    }

    public void SwapBuffers()
    {
        GLFW.glfwSwapBuffers(m_Window);
    }

    private long CreateWindow()
    {
        if (!s_InitializedGL)
        {
            boolean result = InitializeGL();
            if (!result)
            {
                return 0;
            }
        }
        long window = GLFW.glfwCreateWindow(m_Width, m_Height, m_Title, 0, 0);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
        GL.createCapabilities();
        Input.Initialize(this);

        GLFW.glfwSetKeyCallback(window, Input.GetKeyHandler());
        GLFW.glfwSetMouseButtonCallback(window, Input.GetMouseHandler());
        GLFW.glfwSetWindowCloseCallback(window, new WindowCloseHandler());

        return window;
    }

    private boolean InitializeGL()
    {
        boolean result = GLFW.glfwInit();
        if (!result)
        {
            System.err.println("Failed to Initialize GLFW");
            return false;
        }
        s_InitializedGL = true;
        return true;
    }

}
