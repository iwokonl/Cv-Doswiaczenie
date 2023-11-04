using System.Reflection.PortableExecutable;
using System.Text;

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
                foreach (char a in line)
                {
                    if (a != ' ')
                    {
                        this.grid.Last().Add(new Spot((int)Char.GetNumericValue(a), this.grid.Count - 1,this.grid.Last().Count));
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
        Spot start = this.grid.Last().First();
        Spot end = this.grid.First().Last();
        openSet.Add(start);
        while(openSet.Any()) {
            Spot current = openSet[0];
            foreach (var spot in openSet) {
                if (spot.f < current.f) {
                    current = spot;
                }
            }
            if (current.PositionEquals(end)) {
                Spot temp = current;
                while (temp.previous != null) {
                    path.Add(temp);
                    temp = temp.previous;
                }
                for(int i = 0;i<path.Count;i++){
                    this.grid[path[i].x][path[i].y].value = 3;
                }
                this.grid[start.x][start.y].value = 3;
                this.grid[end.x][end.y].value = 3;
                return this;
            }

            openSet.Remove(current);
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
            for(int i = 0;i<current.neighbors.Count;i++) {
                Spot neighbor = current.neighbors[i];
                if (neighbor.value != 5 & current.value != 5 & !includes(closedSet,neighbor)) {
                    double tempG = current.g + 1;
                    bool newPath = false;
                    if (includes(openSet,neighbor)) {
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
    public bool includes(List<Spot> list, Spot spot)
    {
        for(int i = 0;i<list.Count;i++)
        {
            if (list[i] == spot)
            {
                return true;
            }
        }
        return false;
    }
    public override string ToString()
    {
        StringBuilder result = new StringBuilder();
        foreach (List<Spot> row in this.grid)
        {
            foreach (Spot spot in row)
            {
                result.Append(spot.value + " ");
            }
            result.Append( "\n");
        }
        return result.ToString();
    }

    private List<List<Spot>> _grid;
    public List<List<Spot>> grid
    {
        get => _grid;
        set => _grid = value;
    }
}