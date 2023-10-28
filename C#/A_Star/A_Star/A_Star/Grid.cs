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
        Spot end = this.grid[this.grid.Count-1][this.grid.Count-1];
        openSet.Add(start);
        while(!openSet.Any()) {
            Spot current = openSet[0];
            foreach (var spot in openSet) {
                if (spot.f < current.f) {
                    current = spot;
                }
            }
            if (current.Equals(end)) {
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
                current.addNeighbors(this.grid.get(current.getX()).get(current.getY()+1));
            }
            if (current.y  > 0) {
                current.addNeighbors(this.grid.get(current.getX()).get(current.getY()-1));
            }
            if (current.x > 0) {
                current.addNeighbors(this.grid.get(current.getX() - 1).get(current.getY()));
            }
            if (current.x < this.grid.Count - 1) {
                current.neighbors.Add(this.grid.get(current.getX() + 1).get(current.getY()));
            }
            closedSet.add(current);
            for (Spot neighbor : current.getNeighbors()) {
                if (!closedSet.contains(neighbor) & neighbor.getValue() != 5 & current.getValue() != 5) {
                    double tempG = current.getG() + 1;
                    boolean newPath = false;
                    if (openSet.contains(neighbor)) {
                        if (tempG < neighbor.getG()) {
                            neighbor.setG(tempG);
                            newPath = true;
                        }
                    } else {
                        neighbor.setG(tempG);
                        newPath = true;
                        openSet.add(neighbor);
                    }
                    if (newPath) {
                        neighbor.setH(heuristic(neighbor, end));
                        neighbor.setF(neighbor.getG() + neighbor.getH());
                        neighbor.setPrevious(current);
                    }
                }
            }
        }
        return this;
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