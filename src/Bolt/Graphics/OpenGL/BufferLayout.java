package Bolt.Graphics.OpenGL;

import org.lwjgl.opengl.*;

public enum BufferLayout
{

    Position(0, 2, GL41.GL_FLOAT, 0),
    TexCoord(1, 2, GL41.GL_FLOAT, 2 * Float.BYTES);

    private final int m_Index;
    private final int m_Offset;
    private final int m_Count;
    private final int m_DataType;

    BufferLayout(int index, int count, int dataType, int offset)
    {
        m_Index = index;
        m_Count = count;
        m_Offset = offset;
        m_DataType = dataType;
    }

    public int Index()
    {
        return m_Index;
    }

    public int Offset()
    {
        return m_Offset;
    }

    public int Count()
    {
        return m_Count;
    }

    public int DataType()
    {
        return m_DataType;
    }

    public static int Size()
    {
        return 4 * Float.BYTES;
    }

}
