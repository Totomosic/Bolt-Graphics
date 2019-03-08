package Bolt.Graphics.OpenGL;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

import java.nio.IntBuffer;

public class Shader
{

    public static Shader Default = new Shader(new StringBuilder()
            .append("#version 430 core\n\n")
            .append("layout(location = 0) in vec2 in_Position;\n")
            .append("layout(location = 1) in vec2 in_TexCoord;\n\n")
            .append("void main()\n")
            .append("{\n")
            .append("\tgl_Position = vec4(in_Position, 0.0, 1.0);\n")
            .append("}").toString(),
            new StringBuilder()
            .append("#version 430 core\n\n")
            .append("layout(location = 0) out vec4 FinalColor;\n\n")
            .append("void main()\n")
            .append("{\n")
            .append("\tFinalColor = vec4(1.0, 1.0, 1.0, 1.0);\n")
            .append("}").toString());

    private final int m_Id;

    public Shader(String vertexSource, String fragmentSource)
    {
        m_Id = GL41.glCreateProgram();
        GlHelper.CheckErrors("glCreateProgram");
        int vertexShader = CreateShaderProgram(GL41.GL_VERTEX_SHADER, vertexSource);
        int fragmentShader = CreateShaderProgram(GL41.GL_FRAGMENT_SHADER, fragmentSource);
        GL41.glLinkProgram(m_Id);
        GlHelper.CheckErrors("glLinkProgram");
        IntBuffer resultBuffer = BufferUtils.createIntBuffer(1);
        GL41.glGetProgramiv(m_Id, GL41.GL_LINK_STATUS, resultBuffer);
        int result = resultBuffer.get();
        if (result == GL41.GL_FALSE)
        {
            String log = GL41.glGetProgramInfoLog(m_Id);
            System.err.println("Shader Link Error.");
            System.err.println(log);
        }
        GL41.glDetachShader(m_Id, vertexShader);
        GL41.glDetachShader(m_Id, fragmentShader);
        GL41.glDeleteShader(vertexShader);
        GL41.glDeleteShader(fragmentShader);
    }

    public int Id()
    {
        return m_Id;
    }

    public void Bind()
    {
        GL41.glUseProgram(m_Id);
        GlHelper.CheckErrors("glUseProgram");
    }

    public void Unbind()
    {
        GL41.glUseProgram(0);
        GlHelper.CheckErrors("glUseProgram");
    }

    private int CreateShaderProgram(int type, String source)
    {
        int shader = GL41.glCreateShader(type);
        GlHelper.CheckErrors("glCreateShader");
        GL41.glShaderSource(shader, source);
        GlHelper.CheckErrors("glShaderSource");
        GL41.glCompileShader(shader);
        GlHelper.CheckErrors("glCompileShader");

        IntBuffer resultBuffer = BufferUtils.createIntBuffer(1);
        GL41.glGetShaderiv(shader, GL41.GL_COMPILE_STATUS, resultBuffer);
        int result = resultBuffer.get();
        if (result == GL41.GL_FALSE)
        {
            String log = GL41.glGetShaderInfoLog(shader);
            GL41.glDeleteShader(shader);
            System.err.println("Shader Error.");
            System.err.println(log);
            return 0;
        }
        GL41.glAttachShader(m_Id, shader);
        GlHelper.CheckErrors("glAttachShader");
        return shader;
    }

}
