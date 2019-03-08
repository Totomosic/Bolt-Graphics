package Bolt.Graphics.Input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.List;

public class MouseHandler extends GLFWMouseButtonCallback
{

    private final List<MouseButton> m_PressedButtons;
    private final List<MouseButton> m_ReleasedButtons;

    public MouseHandler(List<MouseButton> pressedButtons, List<MouseButton> releasedButtons)
    {
        m_PressedButtons = pressedButtons;
        m_ReleasedButtons = releasedButtons;
    }

    @Override
    public void invoke(long window, int button, int action, int mods)
    {
        if (action == GLFW.GLFW_PRESS)
        {
            m_PressedButtons.add(MouseButton.FromGLFWButton(button));
        }
        else if (action == GLFW.GLFW_RELEASE)
        {
            m_ReleasedButtons.add(MouseButton.FromGLFWButton(button));
        }
    }

}
