namespace Main.A_Star;

public class Grid
{
    
    
    
    
    
    public Grid(String path)
    {
        String line;
        this.grid = new List<List<Spot>>();
        try
        {
            StreamReader sr = new StreamReader(path);
            line = sr.ReadLine();
            while (line != null)
            {
                this.grid.Add(new List<Spot>());
                char [] values = line.ToCharArray();
                for(int i =0;i<values.Length;i++)
                {
                    if (values[i] != ' ')
                    {
                        this.grid[this.grid.Count - 1].Add(new Spot((int)Char.GetNumericValue(values[i]), this.grid.Count - 1,this.grid[this.grid.Count - 1].Count));
                    }
                }
                line = sr.ReadLine();
            }
            sr.Close();
        }
        catch(Exception e)
        {
            Console.WriteLine("Exception: " + e.Message);
        }
    }

 public Grid A_star(){
        List<Spot> openSet = new List<Spot>();
        List<Spot> closedSet = new List<Spot>();
        List<Spot> path = new List<Spot>();
        Spot start = this.grid[this.grid.Count-1][0];
        Spot end = this.grid[0][this.grid.Count-1];
        openSet.Add(start);
        while(openSet.Any()) {
            Spot current = openSet[0];
            foreach (var spot in openSet) {
                if (spot.f < current.f) {
                    current = spot;
                }
            }
            if (current.x == end.x && current.y == end.y ) {
                Spot temp = current;
                while (temp.previous != null) {
                    path.Add(temp);
                    temp = temp.previous;
                }
                foreach(Spot spot in path) {
                    this.grid[spot.x][spot.y].value = 3;
                }
                this.grid[start.x][start.y].value = 3;
                this.grid[end.x][end.y].value = 3;
                return this;
            }
            foreach(Spot spot in openSet) {
                if (spot.Equals(current)) {
                    openSet.Remove(spot);
                    break;
                }
            }
            if(current.y < this.grid[0].Count-1){
                current.neighbors.Add(this.grid[current.x][current.y+1]);
            }
            if (current.y  > 0) {
                current.neighbors.Add(this.grid[current.x][current.y-1]);
            }
            if (current.x > 0) {
                current.neighbors.Add(this.grid[current.x-1][current.y]);
            }
            if (current.x < this.grid.Count - 1) {
                current.neighbors.Add(this.grid[current.x+1][current.y]);
            }
            closedSet.Add(current);
            foreach(Spot neighbor in current.neighbors) {
                if (!closedSet.Contains(neighbor) & neighbor.value != 5 & current.value != 5) {
                    double tempG = current.g + 1;
                    bool newPath = false;
                    if (openSet.Contains(neighbor)) {
                        if (tempG < neighbor.g) {
                            neighbor.g = tempG;
                            newPath = true;
                        }
                    } else {
                        neighbor.g = tempG;
                        newPath = true;
                        openSet.Add(neighbor);
                    }
                    if (newPath) {
                        neighbor.h = heuristic(neighbor, end);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.previous = current;
                    }
                }
            }
        }
        Console.WriteLine("Brak ścieżki");
        return this;
        
 }
 
    double heuristic(Spot a, Spot b) {
        return Math.Sqrt(Math.Pow(a.x - b.x, 2) + Math.Pow(a.y - b.y, 2));
    }
    public override string ToString()
    {
        String result = "";
        foreach (List<Spot> row in this.grid)
        {
            foreach (Spot spot in row)
            {
                result += spot.value + " ";
            }
            result += "\n";
        }
        return result;
    }

    private List<List<Spot>> _grid;
    public List<List<Spot>> grid
    {
        get => _grid;
        set => _grid = value;
    }
}