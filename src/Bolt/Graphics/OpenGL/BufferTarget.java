package Bolt.Graphics.OpenGL;

import org.lwjgl.opengl.GL21;

public enum BufferTarget
{

    ArrayBuffer(GL21.GL_ARRAY_BUFFER),
    ElementBuffer(GL21.GL_ELEMENT_ARRAY_BUFFER);

    private final int m_Target;

    BufferTarget(int target)
    {
        m_Target = target;
    }

    public int GetValue()
    {
        return m_Target;
    }

}
