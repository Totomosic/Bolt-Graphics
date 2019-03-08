package Bolt.Graphics.OpenGL;

import org.lwjgl.opengl.GL41;

import java.nio.ByteBuffer;

public class GlBuffer
{

    private final int m_Id;
    private final long m_Capacity;
    private final BufferUsage m_Usage;
    private final BufferTarget m_Target;

    public GlBuffer(long capacity, BufferTarget target, BufferUsage usage)
    {
        m_Id = GL41.glGenBuffers();
        GlHelper.CheckErrors("glGenBuffers");
        m_Capacity = capacity;
        m_Usage = usage;
        m_Target = target;
        Bind();
        GL41.glBufferData(Target().GetValue(), m_Capacity, m_Usage.GetValue());
        GlHelper.CheckErrors("glBufferData");
    }

    @Override
    public void finalize()
    {
        GL41.glDeleteBuffers(m_Id);
        GlHelper.CheckErrors("glDeleteBuffer");
    }

    public int Id()
    {
        return m_Id;
    }

    public long Capacity()
    {
        return m_Capacity;
    }

    public BufferUsage Usage()
    {
        return m_Usage;
    }

    public BufferTarget Target()
    {
        return m_Target;
    }

    public void Bind()
    {
        GL41.glBindBuffer(Target().GetValue(), m_Id);
        GlHelper.CheckErrors("glBindBuffer");
    }

    public void Unbind()
    {
        GL41.glBindBuffer(Target().GetValue(), 0);
        GlHelper.CheckErrors("glBindBuffer");
    }

    public void Upload(ByteBuffer data, long offset)
    {
        Bind();
        GL41.glBufferSubData(Target().GetValue(), offset, data);
        GlHelper.CheckErrors("glBufferSubData");
    }

    public void Upload(ByteBuffer data)
    {
        Upload(data, 0);
    }

    public void Download(ByteBuffer outBuffer, long offset)
    {
        Bind();
        GL41.glGetBufferSubData(Target().GetValue(), offset, outBuffer);
        GlHelper.CheckErrors("glGetBufferSubData");
    }

    public void Download(ByteBuffer outBuffer)
    {
        Download(outBuffer, 0);
    }

    public ByteBuffer Map(BufferAccess access)
    {
        Bind();
        ByteBuffer result = GL41.glMapBuffer(Target().GetValue(), access.GetValue());
        GlHelper.CheckErrors("glMapBuffer");
        return result;
    }

    public void Unmap()
    {
        Bind();
        GL41.glUnmapBuffer(Target().GetValue());
        GlHelper.CheckErrors("glUnmapBuffer");
    }

}
