package Bolt.Graphics.Input;

import Bolt.Application;
import org.lwjgl.glfw.GLFWWindowCloseCallback;

public class WindowCloseHandler extends GLFWWindowCloseCallback
{

    public void invoke(long window)
    {
        Application.Instance().Close();
    }

}
