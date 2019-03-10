package Bolt.Graphics;

import Bolt.Graphics.OpenGL.GlHelper;
import Bolt.Graphics.OpenGL.Shader;
import Bolt.Scene.*;
import org.lwjgl.opengl.GL41;

public class Renderer
{

    public static void Render(Renderable renderable, Camera camera)
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
        GL41.glDrawElements(model.GetVertexArray().GetRenderMode(), model.GetRenderCount(), GL41.GL_UNSIGNED_INT, 0);
        GlHelper.CheckErrors("glDrawElements");
    }

    public static void Render(Layer layer)
    {
        for (Renderable r : layer.GetRenderables())
        {
            Render(r, layer.GetCamera());
        }
    }

    public static void Render(Scene scene)
    {
        for (Layer layer : scene.GetLayers())
        {
            if (layer.IsEnabled())
            {
                Render(layer);
            }
            GL41.glClear(GL41.GL_DEPTH_BUFFER_BIT);
        }
    }

    public static void RenderScene()
    {
        if (SceneManager.CurrentScene() != null)
        {
            Render(SceneManager.CurrentScene());
        }
    }

}
