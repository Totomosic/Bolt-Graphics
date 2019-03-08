package Bolt.Graphics;

import Bolt.Graphics.OpenGL.Shader;
import org.lwjgl.opengl.GL41;

public class Renderer
{

    public static void Render(Model model, Shader shader)
    {
        shader.Bind();
        model.GetVertexArray().Bind();
        GL41.glDrawElements(model.GetRenderMode(), model.GetRenderCount(), GL41.GL_UNSIGNED_INT, 0);
    }

}
