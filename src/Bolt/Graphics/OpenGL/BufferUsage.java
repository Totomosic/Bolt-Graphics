package Bolt.Graphics.OpenGL;
import org.lwjgl.opengl.*;

public enum BufferUsage
{
    StaticDraw(GL21.GL_STATIC_DRAW),
    StaticCopy(GL21.GL_STATIC_COPY),
    DynamicDraw(GL21.GL_DYNAMIC_DRAW),
    DynamicCopy(GL21.GL_DYNAMIC_COPY),
    StreamDraw(GL21.GL_STREAM_DRAW),
    StreamCopy(GL21.GL_STREAM_COPY);

    private final int m_Value;

    BufferUsage(int value)
    {
        this.m_Value = value;
    }

    public int GetValue()
    {
        return m_Value;
    }
}