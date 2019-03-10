package Bolt.Core;

public class Color {

    public static final Color White = new Color(255, 255, 255, 255);
    public static final Color Black = new Color(0, 0, 0, 255);
    public static final Color Red = new Color(255, 0, 0, 255);
    public static final Color Green = new Color(0, 255, 0, 255);
    public static final Color Blue = new Color(0, 0, 255, 255);
    public static final Color Yellow = new Color(255, 255, 0, 255);
    public static final Color Cyan = new Color(0, 255, 255, 255);
    public static final Color Magenta = new Color(255, 0, 255, 255);

    public float r;
    public float g;
    public float b;
    public float a;

    public Color(int r, int g, int b, int a)
    {
        this.r = r / 255.0f;
        this.g = g / 255.0f;
        this.b = b / 255.0f;
        this.a = a / 255.0f;
    }

    public Color(int r, int g, int b)
    {
        this(r, g, b, 255);
    }

    public static Color FromFloats(float r, float g, float b, float a)
    {
        return new Color((int)r * 255, (int)g * 255, (int)b * 255, (int)a * 255);
    }

}
