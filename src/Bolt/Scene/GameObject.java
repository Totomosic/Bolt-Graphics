package Bolt.Scene;

import Bolt.Core.Vector2f;

public class GameObject
{

    private final Transform m_Transform;

    public GameObject(Transform transform)
    {
        m_Transform = transform;
        m_Transform.SetGameObject(this);
    }

    public GameObject(float x, float y)
    {
        this(new Transform(new Vector2f(x, y)));
    }

    public GameObject()
    {
        this(new Transform());
    }

    public Transform GetTransform()
    {
        return m_Transform;
    }

    public boolean HasParent()
    {
        return m_Transform.HasParent();
    }

    public GameObject GetParent()
    {
        return m_Transform.GetParent().GetGameObject();
    }

    public void SetParent(GameObject gameObject)
    {
        m_Transform.SetParent(gameObject.GetTransform());
    }

}
