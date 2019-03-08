package Bolt.Graphics.OpenGL;

import org.lwjgl.opengl.GL41;

public enum BufferAccess
{

    Read(GL41.GL_READ_ONLY),
    Write(GL41.GL_WRITE_ONLY),
    ReadWrite(GL41.GL_READ_WRITE);

    private final int m_Value;

    BufferAccess(int value)
    {
        m_Value = value;
    }

    public int GetValue()
    {
        return m_Value;
    }

}
