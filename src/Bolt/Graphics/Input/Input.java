package Bolt.Graphics.Input;

import Bolt.Core.Vector2f;
import Bolt.Graphics.Window;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private static Window s_Window;
    private static final List<Keycode> s_PressedKeys = new ArrayList<>();
    private static final List<Keycode> s_ReleasedKeys = new ArrayList<>();
    private static final List<MouseButton> s_PressedButtons = new ArrayList<>();
    private static final List<MouseButton> s_ReleasedButtons = new ArrayList<>();

    private static final KeyboardHandler s_KeyboardHandler = new KeyboardHandler(s_PressedKeys, s_ReleasedKeys);
    private static final MouseHandler s_MouseHandler = new MouseHandler(s_PressedButtons, s_ReleasedButtons);

    public static void Initialize(Window window)
    {
        s_Window = window;
    }

    public static KeyboardHandler GetKeyHandler()
    {
        return s_KeyboardHandler;
    }

    public static MouseHandler GetMouseHandler()
    {
        return s_MouseHandler;
    }

    public static boolean KeyDown(Keycode key)
    {
        int action = GLFW.glfwGetKey(s_Window.GetNativeWindow(), key.glfwKeycode);
        return action == GLFW.GLFW_PRESS || action == GLFW.GLFW_REPEAT;
    }

    public static boolean KeyUp(Keycode key)
    {
        int action = GLFW.glfwGetKey(s_Window.GetNativeWindow(), key.glfwKeycode);
        return action == GLFW.GLFW_RELEASE;
    }

    public static boolean KeyPressed(Keycode key)
    {
        return s_PressedKeys.contains(key);
    }

    public static boolean KeyReleased(Keycode key)
    {
        return s_ReleasedKeys.contains(key);
    }

    public static boolean MouseDown(MouseButton button)
    {
        int action = GLFW.glfwGetMouseButton(s_Window.GetNativeWindow(), button.glfwButtonCode);
        return action == GLFW.GLFW_PRESS || action == GLFW.GLFW_REPEAT;
    }

    public static boolean MouseUp(MouseButton button)
    {
        int action = GLFW.glfwGetMouseButton(s_Window.GetNativeWindow(), button.glfwButtonCode);
        return action == GLFW.GLFW_RELEASE;
    }

    public static boolean MousePressed(MouseButton button)
    {
        return s_PressedButtons.contains(button);
    }

    public static boolean MouseReleased(MouseButton button)
    {
        return s_ReleasedButtons.contains(button);
    }

    // Return Mouse position from Bottom-Left of Window
    public static Vector2f MousePosition()
    {
        DoubleBuffer xBuf = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer yBuf = BufferUtils.createDoubleBuffer(1);
        GLFW.glfwGetCursorPos(s_Window.GetNativeWindow(), xBuf, yBuf);
        return new Vector2f((float)xBuf.get(), s_Window.GetHeight() - (float)yBuf.get());
    }

    public static void Update()
    {
        s_PressedKeys.clear();
        s_PressedButtons.clear();
        s_ReleasedKeys.clear();
        s_ReleasedButtons.clear();
    }

}
