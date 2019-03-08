package Bolt.Graphics.Input;
import org.lwjgl.glfw.*;

public enum MouseButton {

    Left(GLFW.GLFW_MOUSE_BUTTON_LEFT),
    Middle(GLFW.GLFW_MOUSE_BUTTON_MIDDLE),
    Right(GLFW.GLFW_MOUSE_BUTTON_RIGHT);

    public final int glfwButtonCode;

    MouseButton(int glfwButton)
    {
        glfwButtonCode = glfwButton;
    }

    public static MouseButton FromGLFWButton(int button)
    {
        switch (button)
        {
            case GLFW.GLFW_MOUSE_BUTTON_LEFT:
                return MouseButton.Left;
            case GLFW.GLFW_MOUSE_BUTTON_MIDDLE:
                return MouseButton.Middle;
            case GLFW.GLFW_MOUSE_BUTTON_RIGHT:
                return MouseButton.Right;
        }
        return MouseButton.Left;
    }

}
