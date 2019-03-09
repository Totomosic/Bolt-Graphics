package Bolt.Scene;

import Bolt.Core.Matrix4f;
import Bolt.Core.Vector2f;
import com.sun.istack.internal.Nullable;

public class Transform
{

    private Vector2f m_LocalPosition;
    private float m_LocalRotation;
    private Vector2f m_LocalScale;
    private Transform m_Parent;

    private boolean m_IsValid;
    private Matrix4f m_TransformMatrix;
    private Matrix4f m_InvTransformMatrix;

    private GameObject m_GameObject;

    public Transform(Vector2f position, float rotation, Vector2f scale)
    {
        m_LocalPosition = position;
        m_LocalRotation = rotation;
        m_LocalScale = scale;
        m_Parent = null;
        m_IsValid = false;
        m_TransformMatrix = Matrix4f.Identity();
        m_InvTransformMatrix = Matrix4f.Identity();
        m_GameObject = null;
    }

    public Transform(Vector2f position, float rotation)
    {
        this(position, rotation, new Vector2f(1.0f, 1.0f));
    }

    public Transform(Vector2f position, Vector2f scale)
    {
        this(position, 0.0f, scale);
    }

    public Transform(Vector2f position)
    {
        this(position, 0.0f);
    }

    public Transform()
    {
        this(new Vector2f(0.0f, 0.0f));
    }

    public Transform GetParent()
    {
        return m_Parent;
    }

    public boolean HasParent()
    {
        return m_Parent != null;
    }

    public GameObject GetGameObject()
    {
        return m_GameObject;
    }

    public Vector2f GetLocalPosition()
    {
        return m_LocalPosition;
    }

    public float GetLocalRotation()
    {
        return m_LocalRotation;
    }

    public Vector2f GetLocalScale()
    {
        return m_LocalScale;
    }

    public Matrix4f GetTransformMatrix()
    {
        if (!m_IsValid)
        {
            RecalculateMatrices();
        }
        Matrix4f result = m_TransformMatrix;
        if (HasParent())
        {
            result = Matrix4f.Mul(GetParent().GetTransformMatrix(), result);
        }
        return result;
    }

    public Matrix4f GetInverseTransformMatrix()
    {
        if (!m_IsValid)
        {
            RecalculateMatrices();
        }
        Matrix4f result = m_InvTransformMatrix;
        if (HasParent())
        {
            result = Matrix4f.Mul(result, GetParent().GetInverseTransformMatrix());
        }
        return result;
    }

    public Vector2f GetPosition()
    {
        Matrix4f transformMatrix = GetTransformMatrix();
        return new Vector2f(transformMatrix.GetElement(0, 3), transformMatrix.GetElement(1, 3));
    }

    public float GetRotation()
    {
        float rot = GetLocalRotation();
        if (HasParent())
        {
            rot += GetParent().GetRotation();
        }
        return rot;
    }

    public Vector2f GetScale()
    {
        Matrix4f transformMatrix = GetTransformMatrix();
        return new Vector2f(transformMatrix.GetElement(0, 0), transformMatrix.GetElement(1, 1));
    }

    public void SetLocalPosition(Vector2f position)
    {
        m_LocalPosition = position;
        Invalidate();
    }

    public void SetLocalPosition(float x, float y)
    {
        SetLocalPosition(new Vector2f(x, y));
    }

    public void SetLocalRotation(float rotation)
    {
        m_LocalRotation = rotation;
        Invalidate();
    }

    public void SetLocalScale(Vector2f scale)
    {
        m_LocalScale = scale;
        Invalidate();
    }

    public void SetLocalScale(float x, float y)
    {
        SetLocalScale(new Vector2f(x, y));
    }

    public void Translate(Vector2f translation)
    {
        SetLocalPosition(Vector2f.Add(GetLocalPosition(), translation));
    }

    public void Translate(float x, float y)
    {
        Translate(new Vector2f(x, y));
    }

    public void Rotate(float rotation)
    {
        SetLocalRotation(GetLocalRotation() + rotation);
    }

    public void Scale(Vector2f scale)
    {
        SetLocalScale(Vector2f.Mul(GetLocalScale(), scale));
    }

    public void Scale(float x, float y)
    {
        Scale(new Vector2f(x, y));
    }

    public void SetParent(@Nullable Transform parent)
    {
        m_Parent = parent;
        Invalidate();
    }

    public void RemoveParent()
    {
        SetParent(null);
    }

    public void SetGameObject(@Nullable GameObject gameObject)
    {
        m_GameObject = gameObject;
    }

    private void Invalidate()
    {
        m_IsValid = false;
    }

    private void RecalculateMatrices()
    {
        m_IsValid = true;
        Matrix4f result = Matrix4f.Translation(m_LocalPosition.x, m_LocalPosition.y);
        result = Matrix4f.Mul(result, Matrix4f.RotationZ(m_LocalRotation));
        result = Matrix4f.Mul(result, Matrix4f.Scale(m_LocalScale.x, m_LocalScale.y));
        m_TransformMatrix = result;
        m_InvTransformMatrix = Matrix4f.Inverse(m_TransformMatrix);
    }

}
