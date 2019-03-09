package Bolt.Scene;

import Bolt.Application;
import Bolt.Core.Matrix4f;

public class Camera extends GameObject
{

    private Matrix4f m_ProjectionMatrix;

    public Camera(Matrix4f projectionMatrix)
    {
        m_ProjectionMatrix = projectionMatrix;
    }

    public Camera()
    {
        this(Matrix4f.Orthographic(0.0f, (float)Application.Instance().GetCanvas().GetWidth(), 0.0f, (float)Application.Instance().GetCanvas().GetHeight(), -100.0f, 100.0f));
    }

    public Matrix4f GetViewMatrix()
    {
        return GetTransform().GetInverseTransformMatrix();
    }

    public Matrix4f GetProjectionMatrix()
    {
        return m_ProjectionMatrix;
    }

    public float ViewWidth()
    {
        return 2.0f / GetProjectionMatrix().GetElement(0, 0);
    }

    public float ViewHeight()
    {
        return 2.0f / GetProjectionMatrix().GetElement( 1, 1);
    }

}
