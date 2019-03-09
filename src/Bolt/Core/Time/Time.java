package Bolt.Core.Time;

import org.lwjgl.glfw.GLFW;

public class Time
{

    private static float m_CurrentTime = 0.0f;
    private static Timeline m_MainTimeline = new Timeline();

    public static float CurrentTime()
    {
        return m_CurrentTime;
    }

    public static Timeline MainTimeline()
    {
        return m_MainTimeline;
    }

    public static void Reset()
    {
        m_CurrentTime = 0.0f;
        GLFW.glfwSetTime(0.0f);
        m_MainTimeline.Reset();
    }

    public static void Update()
    {
        float currentTime = (float)GLFW.glfwGetTime();
        float delta = currentTime - m_CurrentTime;
        m_MainTimeline.Update(delta);
        m_CurrentTime = currentTime;
    }

}
