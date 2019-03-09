package Bolt.Graphics;

import Bolt.Graphics.OpenGL.GlHelper;
import Bolt.Graphics.OpenGL.Shader;
import Bolt.Scene.*;
import org.lwjgl.opengl.GL41;

public class Renderer
{

    public static void Render(Renderable renderable, Camera camera, Window window)
    {
        Material material = renderable.GetMesh().GetMaterial();
        Shader shader = material.GetShader();
        shader.Bind();
        shader.SetUniform("u_ModelMatrix", renderable.GetTransform().GetTransformMatrix());
        shader.SetUniform("u_ViewMatrix", camera.GetViewMatrix());
        shader.SetUniform("u_ProjectionMatrix", camera.GetProjectionMatrix());
        shader.SetUniform("u_Color", material.GetColor());
        if (material.HasTexture())
        {
            Texture2D texture = material.GetTexture();
            shader.SetUniform("u_Texture", texture);
        }
        Model model = renderable.GetMesh().GetModel();
        model.GetVertexArray().Bind();
        GL41.glDrawElements(model.GetRenderMode(), model.GetRenderCount(), GL41.GL_UNSIGNED_INT, 0);
        GlHelper.CheckErrors("glDrawElements");
    }

    public static void Render(Layer layer, Window window)
    {
        for (Renderable r : layer.GetRenderables())
        {
            Render(r, layer.GetCamera(), window);
        }
    }

    public static void Render(Scene scene, Window window)
    {
        for (Layer layer : scene.GetLayers())
        {
            if (layer.IsEnabled())
            {
                Render(layer, window);
            }
        }
    }

    public static void RenderScene(Window window)
    {
        if (SceneManager.CurrentScene() != null)
        {
            Render(SceneManager.CurrentScene(), window);
        }
    }

}
