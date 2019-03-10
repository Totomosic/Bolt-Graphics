package Bolt.Graphics.Input;

import Bolt.Application;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

public class WindowResizeHandler extends GLFWFramebufferSizeCallback
{

    @Override
    public void invoke(long window, int width, int height)
    {
        Application.Instance().GetCanvas().GetWindow().UpdateSize(width, height);
    }

}
