package Bolt;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2f(float xy)
    {
        this(xy, xy);
    }

    public Vector2f()
    {
        this(0.0f);
    }

    public float LengthSqrd()
    {
        return x * x + y * y;
    }

    public float Length()
    {
        return (float)Math.sqrt(LengthSqrd());
    }

    @Override
    public String toString()
    {
        return "Vector2f(" + x + ", " + y + ")";
    }

    public static Vector2f Add(Vector2f left, Vector2f right)
    {
        return new Vector2f(left.x + right.x, left.y + right.y);
    }

    public static Vector2f Add(Vector2f left, float right)
    {
        return new Vector2f(left.x + right, left.y + right);
    }

    public static Vector2f Sub(Vector2f left, Vector2f right)
    {
        return new Vector2f(left.x - right.x, left.y - right.y);
    }

    public static Vector2f Sub(Vector2f left, float right)
    {
        return new Vector2f(left.x - right, left.y - right);
    }

    public static Vector2f Mul(Vector2f left, Vector2f right)
    {
        return new Vector2f(left.x * right.x, left.y * right.y);
    }

    public static Vector2f Mul(Vector2f left, float right)
    {
        return new Vector2f(left.x * right, left.y * right);
    }

    public static Vector2f Div(Vector2f left, Vector2f right)
    {
        return new Vector2f(left.x / right.x, left.y / right.y);
    }

    public static Vector2f Div(Vector2f left, float right)
    {
        return new Vector2f(left.x / right, left.y / right);
    }

    public static Vector2f Normalize(Vector2f vec)
    {
        return Vector2f.Div(vec, vec.Length());
    }

    public static float Dot(Vector2f left, Vector2f right)
    {
        return left.x * right.x + left.y * right.y;
    }

}
