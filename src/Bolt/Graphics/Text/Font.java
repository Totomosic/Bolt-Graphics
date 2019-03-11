package Bolt.Graphics.Text;

import org.lwjgl.stb.STBTTFontinfo;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;

public class Font
{

    ByteBuffer m_FontData;

    public Font(String ttfFile) throws IOException
    {
        this(Files.readAllBytes(new File(ttfFile).toPath()));
    }

    public Font(byte[] ttfData)
    {
        m_FontData = ByteBuffer.wrap(ttfData);
    }

    public FontInstance CreateInstance(int size)
    {
        STBTTFontinfo info = STBTTFontinfo.create();
        return new FontInstance();
    }

}
