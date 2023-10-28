namespace Main.A_Star;

public class Spot
{
    public int value
    {
        get => _value;
        set => _value = value;
    }
    public int x
    {
        get => _x;
        set => _x = value;
    }
    public int y
    {
        get => _y;
        set => _y = value;
    }
    public int f
    {
        get => _f;
        set => _f = value;
    }
    public int g
    {
        get => _g;
        set => _g = value;
    }
    public int h
    {
        get => _h;
        set => _h = value;
    }
    public Spot previous
    {
        get => _previous;
        set => _previous = value;
    }
    public List<Spot> neighbors
    {
        get => _neighbors;
        set => _neighbors = value;
    }

    public override bool Equals(object? obj)
    {
        if (obj == null || GetType() != obj.GetType())
        {
            return false;
        }
        Spot spot = (Spot)obj;
        return spot.x == this.x && spot.y == this.y;
    }

    private int _value;
    private int _x;
    private int _y;
    private int _f;
    private int _g;
    private int _h;
    private Spot _previous;
    private List<Spot> _neighbors;

    public Spot(int value, int x, int y)
    {
        this._value = value;
        this._x = x;
        this._y = y;
        this._f = 0;
        this._g = 0;
        this._h = 0;
        this._previous = null;
        this._neighbors = new List<Spot>();
    }
    
}