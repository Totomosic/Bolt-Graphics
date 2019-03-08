package Bolt.Graphics.Input;
import org.lwjgl.glfw.*;

public enum Keycode {

    LShift(GLFW.GLFW_KEY_LEFT_SHIFT),
    RShift(GLFW.GLFW_KEY_RIGHT_SHIFT),
    LAlt(GLFW.GLFW_KEY_LEFT_ALT),
    RAlt(GLFW.GLFW_KEY_RIGHT_ALT),
    LCtrl(GLFW.GLFW_KEY_LEFT_CONTROL),
    RCtrl(GLFW.GLFW_KEY_RIGHT_CONTROL),
    Tab(GLFW.GLFW_KEY_TAB),
    Enter(GLFW.GLFW_KEY_ENTER),
    CapsLock(GLFW.GLFW_KEY_CAPS_LOCK),
    Backspace(GLFW.GLFW_KEY_BACKSPACE),

    A(GLFW.GLFW_KEY_A),
    B(GLFW.GLFW_KEY_B),
    C(GLFW.GLFW_KEY_C),
    D(GLFW.GLFW_KEY_D),
    E(GLFW.GLFW_KEY_E),
    F(GLFW.GLFW_KEY_F),
    G(GLFW.GLFW_KEY_G),
    H(GLFW.GLFW_KEY_H),
    I(GLFW.GLFW_KEY_I),
    J(GLFW.GLFW_KEY_J),
    K(GLFW.GLFW_KEY_K),
    L(GLFW.GLFW_KEY_L),
    M(GLFW.GLFW_KEY_M),
    N(GLFW.GLFW_KEY_N),
    O(GLFW.GLFW_KEY_O),
    P(GLFW.GLFW_KEY_P),
    Q(GLFW.GLFW_KEY_Q),
    R(GLFW.GLFW_KEY_R),
    S(GLFW.GLFW_KEY_S),
    T(GLFW.GLFW_KEY_T),
    U(GLFW.GLFW_KEY_U),
    V(GLFW.GLFW_KEY_V),
    W(GLFW.GLFW_KEY_W),
    X(GLFW.GLFW_KEY_X),
    Y(GLFW.GLFW_KEY_Y),
    Z(GLFW.GLFW_KEY_Z),
    Space(GLFW.GLFW_KEY_SPACE),

    Grave(GLFW.GLFW_KEY_GRAVE_ACCENT),
    Zero(GLFW.GLFW_KEY_0),
    One(GLFW.GLFW_KEY_1),
    Two(GLFW.GLFW_KEY_2),
    Three(GLFW.GLFW_KEY_3),
    Four(GLFW.GLFW_KEY_4),
    Five(GLFW.GLFW_KEY_5),
    Six(GLFW.GLFW_KEY_6),
    Seven(GLFW.GLFW_KEY_7),
    Eight(GLFW.GLFW_KEY_8),
    Nine(GLFW.GLFW_KEY_9),
    Minus(GLFW.GLFW_KEY_MINUS),
    Equal(GLFW.GLFW_KEY_EQUAL),

    Comma(GLFW.GLFW_KEY_COMMA),
    Period(GLFW.GLFW_KEY_PERIOD),
    Slash(GLFW.GLFW_KEY_SLASH),
    Backslash(GLFW.GLFW_KEY_BACKSLASH),
    Semicolon(GLFW.GLFW_KEY_SEMICOLON),
    Apostrophe(GLFW.GLFW_KEY_APOSTROPHE),
    OpenBracket(GLFW.GLFW_KEY_LEFT_BRACKET),
    CloseBracket(GLFW.GLFW_KEY_RIGHT_BRACKET),

    Insert(GLFW.GLFW_KEY_INSERT),
    Home(GLFW.GLFW_KEY_HOME),
    Delete(GLFW.GLFW_KEY_DELETE),
    End(GLFW.GLFW_KEY_END),
    PageUp(GLFW.GLFW_KEY_PAGE_UP),
    PageDown(GLFW.GLFW_KEY_PAGE_DOWN),

    Left(GLFW.GLFW_KEY_LEFT),
    Right(GLFW.GLFW_KEY_RIGHT),
    Up(GLFW.GLFW_KEY_UP),
    Down(GLFW.GLFW_KEY_DOWN),

    Esc(GLFW.GLFW_KEY_ESCAPE),
    F1(GLFW.GLFW_KEY_F1),
    F2(GLFW.GLFW_KEY_F2),
    F3(GLFW.GLFW_KEY_F3),
    F4(GLFW.GLFW_KEY_F4),
    F5(GLFW.GLFW_KEY_F5),
    F6(GLFW.GLFW_KEY_F6),
    F7(GLFW.GLFW_KEY_F7),
    F8(GLFW.GLFW_KEY_F8),
    F9(GLFW.GLFW_KEY_F9),
    F10(GLFW.GLFW_KEY_F10),
    F11(GLFW.GLFW_KEY_F11),
    F12(GLFW.GLFW_KEY_F12);

    public final int glfwKeycode;

    Keycode(int glfwKey)
    {
        glfwKeycode = glfwKey;
    }

    public static Keycode FromGLFWKey(int key)
    {
        switch (key)
        {
            case GLFW.GLFW_KEY_LEFT_SHIFT:
                return Keycode.LShift;
            case GLFW.GLFW_KEY_RIGHT_SHIFT:
                return Keycode.RShift;
            case GLFW.GLFW_KEY_LEFT_ALT:
                return Keycode.LAlt;
            case GLFW.GLFW_KEY_RIGHT_ALT:
                return Keycode.RAlt;
            case GLFW.GLFW_KEY_LEFT_CONTROL:
                return Keycode.LCtrl;
            case GLFW.GLFW_KEY_RIGHT_CONTROL:
                return Keycode.RCtrl;
            case GLFW.GLFW_KEY_TAB:
                return Keycode.Tab;
            case GLFW.GLFW_KEY_ENTER:
                return Keycode.Enter;
            case GLFW.GLFW_KEY_CAPS_LOCK:
                return Keycode.CapsLock;
            case GLFW.GLFW_KEY_BACKSPACE:
                return Keycode.Backspace;

            case GLFW.GLFW_KEY_A:
                return Keycode.A;
            case GLFW.GLFW_KEY_B:
                return Keycode.B;
            case GLFW.GLFW_KEY_C:
                return Keycode.C;
            case GLFW.GLFW_KEY_D:
                return Keycode.D;
            case GLFW.GLFW_KEY_E:
                return Keycode.E;
            case GLFW.GLFW_KEY_F:
                return Keycode.F;
            case GLFW.GLFW_KEY_G:
                return Keycode.G;
            case GLFW.GLFW_KEY_H:
                return Keycode.H;
            case GLFW.GLFW_KEY_I:
                return Keycode.I;
            case GLFW.GLFW_KEY_J:
                return Keycode.J;
            case GLFW.GLFW_KEY_K:
                return Keycode.K;
            case GLFW.GLFW_KEY_L:
                return Keycode.L;
            case GLFW.GLFW_KEY_M:
                return Keycode.M;
            case GLFW.GLFW_KEY_N:
                return Keycode.N;
            case GLFW.GLFW_KEY_O:
                return Keycode.O;
            case GLFW.GLFW_KEY_P:
                return Keycode.P;
            case GLFW.GLFW_KEY_Q:
                return Keycode.Q;
            case GLFW.GLFW_KEY_R:
                return Keycode.R;
            case GLFW.GLFW_KEY_S:
                return Keycode.S;
            case GLFW.GLFW_KEY_T:
                return Keycode.T;
            case GLFW.GLFW_KEY_U:
                return Keycode.U;
            case GLFW.GLFW_KEY_V:
                return Keycode.V;
            case GLFW.GLFW_KEY_W:
                return Keycode.W;
            case GLFW.GLFW_KEY_X:
                return Keycode.X;
            case GLFW.GLFW_KEY_Y:
                return Keycode.Y;
            case GLFW.GLFW_KEY_Z:
                return Keycode.Z;
            case GLFW.GLFW_KEY_SPACE:
                return Keycode.Space;

            case GLFW.GLFW_KEY_GRAVE_ACCENT:
                return Keycode.Grave;
            case GLFW.GLFW_KEY_0:
                return Keycode.Zero;
            case GLFW.GLFW_KEY_1:
                return Keycode.One;
            case GLFW.GLFW_KEY_2:
                return Keycode.Two;
            case GLFW.GLFW_KEY_3:
                return Keycode.Three;
            case GLFW.GLFW_KEY_4:
                return Keycode.Four;
            case GLFW.GLFW_KEY_5:
                return Keycode.Five;
            case GLFW.GLFW_KEY_6:
                return Keycode.Six;
            case GLFW.GLFW_KEY_7:
                return Keycode.Seven;
            case GLFW.GLFW_KEY_8:
                return Keycode.Eight;
            case GLFW.GLFW_KEY_9:
                return Keycode.Nine;
            case GLFW.GLFW_KEY_MINUS:
                return Keycode.Minus;
            case GLFW.GLFW_KEY_EQUAL:
                return Keycode.Equal;

            case GLFW.GLFW_KEY_COMMA:
                return Keycode.Comma;
            case GLFW.GLFW_KEY_PERIOD:
                return Keycode.Period;
            case GLFW.GLFW_KEY_SLASH:
                return Keycode.Slash;
            case GLFW.GLFW_KEY_BACKSLASH:
                return Keycode.Backslash;
            case GLFW.GLFW_KEY_SEMICOLON:
                return Keycode.Semicolon;
            case GLFW.GLFW_KEY_APOSTROPHE:
                return Keycode.Apostrophe;
            case GLFW.GLFW_KEY_LEFT_BRACKET:
                return Keycode.OpenBracket;
            case GLFW.GLFW_KEY_RIGHT_BRACKET:
                return Keycode.CloseBracket;

            case GLFW.GLFW_KEY_INSERT:
                return Keycode.Insert;
            case GLFW.GLFW_KEY_HOME:
                return Keycode.Home;
            case GLFW.GLFW_KEY_DELETE:
                return Keycode.Delete;
            case GLFW.GLFW_KEY_END:
                return Keycode.End;
            case GLFW.GLFW_KEY_PAGE_UP:
                return Keycode.PageUp;
            case GLFW.GLFW_KEY_PAGE_DOWN:
                return Keycode.PageDown;

            case GLFW.GLFW_KEY_LEFT:
                return Keycode.Left;
            case GLFW.GLFW_KEY_RIGHT:
                return Keycode.Right;
            case GLFW.GLFW_KEY_UP:
                return Keycode.Up;
            case GLFW.GLFW_KEY_DOWN:
                return Keycode.Down;

            case GLFW.GLFW_KEY_ESCAPE:
                return Keycode.Esc;
            case GLFW.GLFW_KEY_F1:
                return Keycode.F1;
            case GLFW.GLFW_KEY_F2:
                return Keycode.F2;
            case GLFW.GLFW_KEY_F3:
                return Keycode.F3;
            case GLFW.GLFW_KEY_F4:
                return Keycode.F4;
            case GLFW.GLFW_KEY_F5:
                return Keycode.F5;
            case GLFW.GLFW_KEY_F6:
                return Keycode.F6;
            case GLFW.GLFW_KEY_F7:
                return Keycode.F7;
            case GLFW.GLFW_KEY_F8:
                return Keycode.F8;
            case GLFW.GLFW_KEY_F9:
                return Keycode.F9;
            case GLFW.GLFW_KEY_F10:
                return Keycode.F10;
            case GLFW.GLFW_KEY_F11:
                return Keycode.F11;
            case GLFW.GLFW_KEY_F12:
                return Keycode.F12;
        }
        return Keycode.LShift;
    }

}
