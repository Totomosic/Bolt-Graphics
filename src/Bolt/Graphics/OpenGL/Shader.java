package Bolt.Graphics.OpenGL;

import Bolt.Graphics.Texture2D;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL41;

import java.nio.IntBuffer;
import Bolt.Core.Matrix4f;
import Bolt.Core.Color;

public class Shader
{

    public static Shader Default = new Shader(new StringBuilder()
                                                      .append("#version 430 core\n\n")
                                                      .append("layout(location = 0) in vec2 in_Position;\n")
                                                      .append("layout(location = 1) in vec2 in_TexCoord;\n\n")
                                                      .append("uniform mat4 u_ModelMatrix;\n")
                                                      .append("uniform mat4 u_ViewMatrix;\n")
                                                      .append("uniform mat4 u_ProjectionMatrix;\n\n")
                                                      .append("void main()\n")
                                                      .append("{\n")
                                                      .append("\tvec4 worldPosition = u_ModelMatrix * vec4(in_Position, 0.0, 1.0);\n")
                                                      .append("\tvec4 viewPosition = u_ViewMatrix * worldPosition;\n")
                                                      .append("\tvec4 screenPosition = u_ProjectionMatrix * viewPosition;\n")
                                                      .append("\tgl_Position = screenPosition;\n")
                                                      .append("}").toString(),
                                              new StringBuilder()
                                                      .append("#version 430 core\n\n")
                                                      .append("layout(location = 0) out vec4 FinalColor;\n\n")
                                                      .append("uniform vec4 u_Color;\n\n")
                                                      .append("void main()\n")
                                                      .append("{\n")
                                                      .append("\tFinalColor = u_Color;\n")
                                                      .append("}").toString());

    public static Shader Texture = new Shader(new StringBuilder()
                                                      .append("#version 430 core\n\n")
                                                      .append("layout(location = 0) in vec2 in_Position;\n")
                                                      .append("layout(location = 1) in vec2 in_TexCoord;\n\n")
                                                      .append("uniform mat4 u_ModelMatrix;\n")
                                                      .append("uniform mat4 u_ViewMatrix;\n")
                                                      .append("uniform mat4 u_ProjectionMatrix;\n\n")
                                                      .append("out vec2 f_TexCoord;\n\n")
                                                      .append("void main()\n")
                                                      .append("{\n")
                                                      .append("\tvec4 worldPosition = u_ModelMatrix * vec4(in_Position, 0.0, 1.0);\n")
                                                      .append("\tvec4 viewPosition = u_ViewMatrix * worldPosition;\n")
                                                      .append("\tvec4 screenPosition = u_ProjectionMatrix * viewPosition;\n")
                                                      .append("\tgl_Position = screenPosition;\n")
                                                      .append("\tf_TexCoord = in_TexCoord;\n")
                                                      .append("}").toString(),
                                              new StringBuilder()
                                                      .append("#version 430 core\n\n")
                                                      .append("layout(location = 0) out vec4 FinalColor;\n\n")
                                                      .append("uniform sampler2D u_Texture;\n")
                                                      .append("uniform vec4 u_Color;\n\n")
                                                      .append("in vec2 f_TexCoord;\n\n")
                                                      .append("void main()\n")
                                                      .append("{\n")
                                                      .append("\tFinalColor = u_Color * texture(u_Texture, f_TexCoord);\n")
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

    public void SetUniform(String uniformName, Matrix4f matrix)
    {
        Bind();
        GL41.glUniformMatrix4fv(GetUniformLocation(uniformName), false, matrix.Values);
        GlHelper.CheckErrors("glUniformMatrix4fv");
    }

    public void SetUniform(String uniformName, Color color)
    {
        Bind();
        GL41.glUniform4f(GetUniformLocation(uniformName), color.r, color.g, color.b, color.a);
        GlHelper.CheckErrors("glUniform4f");
    }

    public void SetUniform(String uniformName, Texture2D texture)
    {
        Bind();
        GL41.glUniform1i(GetUniformLocation(uniformName), 0);
        GlHelper.CheckErrors("glUniform1i");
        texture.Bind(0);
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

    private int GetUniformLocation(String uniformName)
    {
        int location = GL41.glGetUniformLocation(m_Id, uniformName);
        GlHelper.CheckErrors("glGetUniformLocation");
        return location;
    }

}
