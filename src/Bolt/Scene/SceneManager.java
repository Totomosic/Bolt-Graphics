package Bolt.Scene;

import java.util.ArrayList;
import java.util.List;

public class SceneManager
{

    private static Scene s_CurrentScene = null;
    private static final List<Scene> s_Scenes = new ArrayList<>();

    public static Scene CurrentScene()
    {
        return s_CurrentScene;
    }

    public static Scene CreateScene()
    {
        Scene s = new Scene();
        s_Scenes.add(s);
        if (s_CurrentScene == null)
        {
            SetCurrentScene(s);
        }
        return s;
    }

    public static void SetCurrentScene(Scene s)
    {
        s_CurrentScene = s;
    }

}
