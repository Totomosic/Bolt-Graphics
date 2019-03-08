package Bolt.Time;

public class Timeline
{

    private float m_CurrentTime;
    private float m_DeltaTime;
    private float m_TimeScale;

    public Timeline(float timeScale)
    {
        m_CurrentTime = 0.0f;
        m_DeltaTime = 0.0f;
        m_TimeScale = timeScale;
    }

    public Timeline()
    {
        this(1.0f);
    }

    public float GetCurrentTime()
    {
        return m_CurrentTime;
    }

    public float GetDeltaTime()
    {
        return m_DeltaTime;
    }

    public float GetTimeScale()
    {
        return m_TimeScale;
    }

    public void SetTimeScale(float timeScale)
    {
        m_TimeScale = timeScale;
    }

    public void Reset()
    {
        m_CurrentTime = 0.0f;
        m_DeltaTime = 0.0f;
    }

    public void Update(float realDeltaTime)
    {
        m_DeltaTime = realDeltaTime * m_TimeScale;
        m_CurrentTime += m_DeltaTime;
    }

}
