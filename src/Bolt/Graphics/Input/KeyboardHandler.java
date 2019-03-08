package Bolt.Graphics.Input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import java.util.List;

public class KeyboardHandler extends GLFWKeyCallback
{

    private final List<Keycode> m_PressedKeys;
    private final List<Keycode> m_ReleasedKeys;

    public KeyboardHandler(List<Keycode> pressedKeys, List<Keycode> releasedKeys)
    {
        m_PressedKeys = pressedKeys;
        m_ReleasedKeys = releasedKeys;
    }

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods)
    {
        if (action == GLFW.GLFW_PRESS)
        {
            m_PressedKeys.add(Keycode.FromGLFWKey(key));
        }
        else if (action == GLFW.GLFW_RELEASE)
        {
            m_ReleasedKeys.add(Keycode.FromGLFWKey(key));
        }
    }

}
