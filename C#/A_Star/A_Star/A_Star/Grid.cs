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
                char [] values = line.ToCharArray();
                foreach (var VARIABLE in values)
                {
                    if (VARIABLE != ' ')
                    {
                        this.grid[this.grid.Count-1].Add(new Spot(VARIABLE,this.grid.Count-1,this.grid[0].Count-1));
                    }
                }
                this.grid.Add(new List<Spot>());
                line = sr.ReadLine();
            }
            sr.Close();
            Console.ReadLine();
        }
        catch(Exception e)
        {
            Console.WriteLine("Exception: " + e.Message);
        }
        finally
        {
            Console.WriteLine("Executing finally block.");
        }
    }
    public void printGrid()
    {
        foreach (var row in this.grid)
        {
            foreach (var spot in row)
            {
                Console.Write(spot.value);
            }
            Console.WriteLine();
        }
    }
    private List<List<Spot>> grid;
}