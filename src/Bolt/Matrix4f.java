package Bolt;

public class Matrix4f
{

    public final float[] Values;

    public Matrix4f(float[] values)
    {
        Values = values;
    }

    public Matrix4f(float diagonal)
    {
        this(new float[16]);
        SetElement(0, 0, diagonal);
        SetElement(1, 1, diagonal);
        SetElement(2, 2, diagonal);
        SetElement(3, 3, diagonal);
    }

    public Matrix4f()
    {
        this(0.0f);
    }

    public float GetElement(int row, int col)
    {
        return Values[col * 4 + row];
    }

    public void SetElement(int row, int col, float value)
    {
        Values[col * 4 + row] = value;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                str.append(GetElement(j, i));
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static Matrix4f Mul(Matrix4f left, Matrix4f right)
    {
        Matrix4f result = new Matrix4f();
        for (int col = 0; col < 4; col++)
        {
            for (int row = 0; row < 4; row++)
            {
                float value = 0.0f;
                for (int i = 0; i < 4; i++)
                {
                    value += left.GetElement(row, i) * right.GetElement(i, col);
                }
                result.SetElement(row, col, value);
            }
        }
        return result;
    }

    public static Matrix4f Inverse(Matrix4f other)
    {
        float[] inv = new float[16];
        float[] invOut = new float[16];
        float det;
        int i;

        inv[0] = other.Values[5] * other.Values[10] * other.Values[15] -
                other.Values[5] * other.Values[11] * other.Values[14] -
                other.Values[9] * other.Values[6] * other.Values[15] +
                other.Values[9] * other.Values[7] * other.Values[14] +
                other.Values[13] * other.Values[6] * other.Values[11] -
                other.Values[13] * other.Values[7] * other.Values[10];

        inv[4] = -other.Values[4] * other.Values[10] * other.Values[15] +
                other.Values[4] * other.Values[11] * other.Values[14] +
                other.Values[8] * other.Values[6] * other.Values[15] -
                other.Values[8] * other.Values[7] * other.Values[14] -
                other.Values[12] * other.Values[6] * other.Values[11] +
                other.Values[12] * other.Values[7] * other.Values[10];

        inv[8] = other.Values[4] * other.Values[9] * other.Values[15] -
                other.Values[4] * other.Values[11] * other.Values[13] -
                other.Values[8] * other.Values[5] * other.Values[15] +
                other.Values[8] * other.Values[7] * other.Values[13] +
                other.Values[12] * other.Values[5] * other.Values[11] -
                other.Values[12] * other.Values[7] * other.Values[9];

        inv[12] = -other.Values[4] * other.Values[9] * other.Values[14] +
                other.Values[4] * other.Values[10] * other.Values[13] +
                other.Values[8] * other.Values[5] * other.Values[14] -
                other.Values[8] * other.Values[6] * other.Values[13] -
                other.Values[12] * other.Values[5] * other.Values[10] +
                other.Values[12] * other.Values[6] * other.Values[9];

        inv[1] = -other.Values[1] * other.Values[10] * other.Values[15] +
                other.Values[1] * other.Values[11] * other.Values[14] +
                other.Values[9] * other.Values[2] * other.Values[15] -
                other.Values[9] * other.Values[3] * other.Values[14] -
                other.Values[13] * other.Values[2] * other.Values[11] +
                other.Values[13] * other.Values[3] * other.Values[10];

        inv[5] = other.Values[0] * other.Values[10] * other.Values[15] -
                other.Values[0] * other.Values[11] * other.Values[14] -
                other.Values[8] * other.Values[2] * other.Values[15] +
                other.Values[8] * other.Values[3] * other.Values[14] +
                other.Values[12] * other.Values[2] * other.Values[11] -
                other.Values[12] * other.Values[3] * other.Values[10];

        inv[9] = -other.Values[0] * other.Values[9] * other.Values[15] +
                other.Values[0] * other.Values[11] * other.Values[13] +
                other.Values[8] * other.Values[1] * other.Values[15] -
                other.Values[8] * other.Values[3] * other.Values[13] -
                other.Values[12] * other.Values[1] * other.Values[11] +
                other.Values[12] * other.Values[3] * other.Values[9];

        inv[13] = other.Values[0] * other.Values[9] * other.Values[14] -
                other.Values[0] * other.Values[10] * other.Values[13] -
                other.Values[8] * other.Values[1] * other.Values[14] +
                other.Values[8] * other.Values[2] * other.Values[13] +
                other.Values[12] * other.Values[1] * other.Values[10] -
                other.Values[12] * other.Values[2] * other.Values[9];

        inv[2] = other.Values[1] * other.Values[6] * other.Values[15] -
                other.Values[1] * other.Values[7] * other.Values[14] -
                other.Values[5] * other.Values[2] * other.Values[15] +
                other.Values[5] * other.Values[3] * other.Values[14] +
                other.Values[13] * other.Values[2] * other.Values[7] -
                other.Values[13] * other.Values[3] * other.Values[6];

        inv[6] = -other.Values[0] * other.Values[6] * other.Values[15] +
                other.Values[0] * other.Values[7] * other.Values[14] +
                other.Values[4] * other.Values[2] * other.Values[15] -
                other.Values[4] * other.Values[3] * other.Values[14] -
                other.Values[12] * other.Values[2] * other.Values[7] +
                other.Values[12] * other.Values[3] * other.Values[6];

        inv[10] = other.Values[0] * other.Values[5] * other.Values[15] -
                other.Values[0] * other.Values[7] * other.Values[13] -
                other.Values[4] * other.Values[1] * other.Values[15] +
                other.Values[4] * other.Values[3] * other.Values[13] +
                other.Values[12] * other.Values[1] * other.Values[7] -
                other.Values[12] * other.Values[3] * other.Values[5];

        inv[14] = -other.Values[0] * other.Values[5] * other.Values[14] +
                other.Values[0] * other.Values[6] * other.Values[13] +
                other.Values[4] * other.Values[1] * other.Values[14] -
                other.Values[4] * other.Values[2] * other.Values[13] -
                other.Values[12] * other.Values[1] * other.Values[6] +
                other.Values[12] * other.Values[2] * other.Values[5];

        inv[3] = -other.Values[1] * other.Values[6] * other.Values[11] +
                other.Values[1] * other.Values[7] * other.Values[10] +
                other.Values[5] * other.Values[2] * other.Values[11] -
                other.Values[5] * other.Values[3] * other.Values[10] -
                other.Values[9] * other.Values[2] * other.Values[7] +
                other.Values[9] * other.Values[3] * other.Values[6];

        inv[7] = other.Values[0] * other.Values[6] * other.Values[11] -
                other.Values[0] * other.Values[7] * other.Values[10] -
                other.Values[4] * other.Values[2] * other.Values[11] +
                other.Values[4] * other.Values[3] * other.Values[10] +
                other.Values[8] * other.Values[2] * other.Values[7] -
                other.Values[8] * other.Values[3] * other.Values[6];

        inv[11] = -other.Values[0] * other.Values[5] * other.Values[11] +
                other.Values[0] * other.Values[7] * other.Values[9] +
                other.Values[4] * other.Values[1] * other.Values[11] -
                other.Values[4] * other.Values[3] * other.Values[9] -
                other.Values[8] * other.Values[1] * other.Values[7] +
                other.Values[8] * other.Values[3] * other.Values[5];

        inv[15] = other.Values[0] * other.Values[5] * other.Values[10] -
                other.Values[0] * other.Values[6] * other.Values[9] -
                other.Values[4] * other.Values[1] * other.Values[10] +
                other.Values[4] * other.Values[2] * other.Values[9] +
                other.Values[8] * other.Values[1] * other.Values[6] -
                other.Values[8] * other.Values[2] * other.Values[5];

        det = other.Values[0] * inv[0] + other.Values[1] * inv[4] + other.Values[2] * inv[8] + other.Values[3] * inv[12];

        if (det == 0)
        {
            return null;
        }

        det = 1 / det;

        for (i = 0; i < 16; i++)
        {
            invOut[i] = inv[i] * det;
        }
        return new Matrix4f(invOut);
    }

    public static Matrix4f Zero()
    {
        return new Matrix4f(0.0f);
    }

    public static Matrix4f Identity()
    {
        return new Matrix4f(1.0f);
    }

    public static Matrix4f Scale(float scale)
    {
        Matrix4f result = new Matrix4f(scale);
        result.SetElement(3, 3, 1.0f);
        return result;
    }

    public static Matrix4f Scale(float x, float y, float z)
    {
        Matrix4f result = new Matrix4f();
        result.SetElement(0, 0, x);
        result.SetElement(1, 1, y);
        result.SetElement(2, 2, z);
        result.SetElement(3, 3, 0);
        return result;
    }

    public static Matrix4f Scale(float x, float y)
    {
        return Scale(x, y, 1.0f);
    }

    public static Matrix4f Translation(float x, float y, float z)
    {
        Matrix4f result = Matrix4f.Identity();
        result.SetElement(0, 3, x);
        result.SetElement(1, 3, y);
        result.SetElement(2, 3, z);
        return result;
    }

    public static Matrix4f Translation(float x, float y)
    {
        return Translation(x, y, 0.0f);
    }

    public static Matrix4f Orthographic(float left, float right, float bottom, float top, float nearPlane, float farPlane)
    {
        Matrix4f result = Matrix4f.Identity();

        result.SetElement(0, 0, 2 / (right - left));
        result.SetElement(1, 1, 2 / (top - bottom));
        result.SetElement(2, 2, -2 / (farPlane - nearPlane));

        result.SetElement(0, 3, -(left + right) / (right - left));
        result.SetElement(1, 3, -(bottom + top) / (top - bottom));
        result.SetElement(2, 3, -(farPlane + nearPlane) / (farPlane - nearPlane));

        return result;
    }

}
