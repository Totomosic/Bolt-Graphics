package Bolt.Graphics.OpenGL;

import java.nio.ByteBuffer;

public class IndexBuffer extends GlBuffer
{

    public IndexBuffer(int indexCount, BufferUsage usage)
    {
        super(indexCount * Integer.BYTES, BufferTarget.ElementBuffer, usage);
    }

    public IndexBuffer(int indexCount)
    {
        this(indexCount, BufferUsage.StaticDraw);
    }

    public IndexBuffer(ByteBuffer data, BufferUsage usage)
    {
        this(data.capacity() / Integer.BYTES, usage);
        Upload(data);
    }

    public IndexBuffer(ByteBuffer data)
    {
        this(data, BufferUsage.StaticDraw);
    }

    public int IndexCount()
    {
        return (int)(Capacity() / Integer.BYTES);
    }

}
