package Bolt.Graphics.OpenGL;

import org.lwjgl.opengl.GL41;

public class GlHelper
{

    public static void CheckErrors(String where)
    {
        int error = GL41.glGetError();
        if (error != GL41.GL_NO_ERROR)
        {
            System.err.println("GL ERROR " + where + ": " + new Integer(error).toString());
        }
    }

}
