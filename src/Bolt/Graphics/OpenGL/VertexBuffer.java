package Bolt.Graphics.OpenGL;

import java.nio.ByteBuffer;

public class VertexBuffer extends GlBuffer
{

    public VertexBuffer(long capacity, BufferUsage usage)
    {
        super(capacity, BufferTarget.ArrayBuffer, usage);
    }

    public VertexBuffer(long capacity)
    {
        this(capacity, BufferUsage.StaticDraw);
    }

    public VertexBuffer(ByteBuffer data, BufferUsage usage)
    {
        this((long)data.capacity(), usage);
        Upload(data);
    }

    public VertexBuffer(ByteBuffer data)
    {
        this(data, BufferUsage.StaticDraw);
    }

    public int VertexCount()
    {
        return (int)(Capacity() / BufferLayout.Size());
    }

}
