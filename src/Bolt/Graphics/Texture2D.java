package Bolt.Graphics;

import Bolt.Graphics.OpenGL.GlHelper;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Texture2D
{

    private final int m_Id;
    private int m_Width;
    private int m_Height;

    public Texture2D(int width, int height)
    {
        m_Id = GL41.glGenTextures();
        GlHelper.CheckErrors("glGenTextures");
        m_Width = width;
        m_Height = height;
        Bind();
        GL41.glTexImage2D(GL41.GL_TEXTURE_2D, 0, GL41.GL_RGB8, m_Width, m_Height, 0, GL41.GL_RGB, GL41.GL_UNSIGNED_BYTE, 0);
        GlHelper.CheckErrors("glTexImage2D");
        GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_MIN_FILTER, GL41.GL_LINEAR);
        GlHelper.CheckErrors("glTexParamateri");
        GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_MAG_FILTER, GL41.GL_LINEAR);
        GlHelper.CheckErrors("glTexParamateri");
        GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_WRAP_S, GL41.GL_CLAMP_TO_EDGE);
        GlHelper.CheckErrors("glTexParamateri");
        GL41.glTexParameteri(GL41.GL_TEXTURE_2D, GL41.GL_TEXTURE_WRAP_T, GL41.GL_CLAMP_TO_EDGE);
        GlHelper.CheckErrors("glTexParamateri");
    }

    public Texture2D(BufferedImage image)
    {
        this(image.getWidth(), image.getHeight());
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        SetPixels(pixels);
    }

    public Texture2D(File file) throws IOException
    {
        this(ImageIO.read(file));
    }

    @Override
    public void finalize()
    {
        GL41.glDeleteTextures(m_Id);
        GlHelper.CheckErrors("glDeleteTextures");
    }

    public int Id()
    {
        return m_Id;
    }

    public int GetWidth()
    {
        return m_Width;
    }

    public int GetHeight()
    {
        return m_Height;
    }

    public void SetPixels(int[] rgbPixels)
    {
        ByteBuffer buffer = BufferUtils.createByteBuffer(m_Width * m_Height * 4); //4 for RGBA, 3 for RGB
        for(int y = m_Height - 1; y >= 0; y--){
            for(int x = 0; x < m_Width; x++){
                int pixel = rgbPixels[y * m_Width + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red component
                buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green component
                buffer.put((byte) (pixel & 0xFF));               // Blue component
                buffer.put((byte) ((pixel >> 24) & 0xFF));    // Alpha component. Only for RGBA
            }
        }
        buffer.flip();
        Bind();
        GL41.glTexSubImage2D(GL41.GL_TEXTURE_2D, 0, 0, 0, m_Width, m_Height, GL41.GL_RGBA, GL41.GL_UNSIGNED_BYTE, buffer);
        GlHelper.CheckErrors("glTexSubImage2D");
        GL41.glGenerateMipmap(GL41.GL_TEXTURE_2D);
        GlHelper.CheckErrors("glGenerateMipmap");
    }

    public void Bind(int textureUnit)
    {
        GL41.glActiveTexture(GL41.GL_TEXTURE0 + textureUnit);
        GlHelper.CheckErrors("glActiveTexture");
        GL41.glBindTexture(GL41.GL_TEXTURE_2D, m_Id);
        GlHelper.CheckErrors("glBindTexture");
    }

    public void Bind()
    {
        Bind(0);
    }

    public void Unbind(int textureUnit)
    {
        GL41.glActiveTexture(GL41.GL_TEXTURE0 + textureUnit);
        GlHelper.CheckErrors("glActiveTexture");
        GL41.glBindTexture(GL41.GL_TEXTURE_2D, 0);
        GlHelper.CheckErrors("glBindTexture");
    }

    public void Unbind()
    {
        Unbind(0);
    }

}
