package Bolt.Graphics.OpenGL;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

import java.nio.ByteBuffer;

public class VertexArray
{

    private final int m_Id;
    private VertexBuffer m_Buffer;
    private IndexBuffer m_IndexBuffer;

    public VertexArray(int vertexCount, int indexCount)
    {
        m_Id = GL41.glGenVertexArrays();
        GlHelper.CheckErrors("glGenVertexArrays");
        m_Buffer = new VertexBuffer(vertexCount * BufferLayout.Size());
        m_IndexBuffer = new IndexBuffer(indexCount);
        SetupVertexBuffer();
    }

    public int Id()
    {
        return m_Id;
    }

    public VertexBuffer GetVertexBuffer()
    {
        return m_Buffer;
    }

    public IndexBuffer GetIndexBuffer()
    {
        return m_IndexBuffer;
    }

    public void Bind()
    {
        GL41.glBindVertexArray(m_Id);
        GlHelper.CheckErrors("glBindVertexArray");
        if (m_IndexBuffer != null)
        {
            m_IndexBuffer.Bind();
        }
    }

    public void Unbind()
    {
        GL41.glBindVertexArray(0);
        GlHelper.CheckErrors("glBindVertexArray");
        if (m_IndexBuffer != null)
        {
            m_IndexBuffer.Unbind();
        }
    }

    public void SetIndices(int[] indices)
    {
        ByteBuffer data = BufferUtils.createByteBuffer(indices.length * Integer.BYTES);
        for (int i : indices)
        {
            data.putInt(i);
        }
        data.flip();
        m_IndexBuffer.Upload(data);
    }

    public void SetVertices(Vertex[] vertices)
    {
        ByteBuffer data = BufferUtils.createByteBuffer(vertices.length * BufferLayout.Size());
        for (Vertex v : vertices)
        {
            data.putFloat(v.Position.x);
            data.putFloat(v.Position.y);
            data.putFloat(v.TexCoord.x);
            data.putFloat(v.TexCoord.y);
        }
        data.flip();
        m_Buffer.Upload(data);
    }

    private void SetupVertexBuffer()
    {
        Bind();
        m_Buffer.Bind();
        BufferLayout position = BufferLayout.Position;
        BufferLayout texCoord = BufferLayout.TexCoord;
        GL41.glEnableVertexAttribArray(position.Index());
        GlHelper.CheckErrors("glEnableVertexAttribArray");
        GL41.glEnableVertexAttribArray(texCoord.Index());
        GlHelper.CheckErrors("glEnableVertexAttribArray");
        GL41.glVertexAttribPointer(position.Index(), position.Count(), position.DataType(), false, BufferLayout.Size(), position.Offset());
        GlHelper.CheckErrors("glVertexAttribPointer");
        GL41.glVertexAttribPointer(texCoord.Index(), texCoord.Count(), texCoord.DataType(), false, BufferLayout.Size(), texCoord.Offset());
        GlHelper.CheckErrors("glVertexAttribPointer");
        m_Buffer.Unbind();
        Unbind();
    }

}
