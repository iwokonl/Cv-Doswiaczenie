namespace Main.A_Star;

public class Spot
{
    public int value
    {
        get => _value;
        set => _value = value;
    }
    public double f
    {
        get => _f;
        set => _f = value;
    }
    public double g
    {
        get => _g;
        set => _g = value;
    }
    public double h
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

    public bool PositionEquals(Spot other)
    {
        return x == other.x && y == other.y;
    }
    
    public override bool Equals(object? obj)
    {
        Spot spot = (Spot)obj;
        return spot.x == this.x && spot.y == this.y;
    }

    private int _value;
    public int x;
    public int y;
    private double _f;
    private double _g;
    private double _h;
    private Spot _previous;
    private List<Spot> _neighbors;

    public Spot(int value, int x, int y)
    {
        this._value = value;
        this.x = x;
        this.y = y;
        this._f = 0;
        this._g = 0;
        this._h = 0;
        this._previous = null;
        this._neighbors = new List<Spot>();
    }
    
}