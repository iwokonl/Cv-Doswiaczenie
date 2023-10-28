using Main.A_Star;

namespace Main;

class main
{
    static void Main(string[] args)
    {
        Grid grid = new Grid(@"D:\github\Cv-Doswiaczenie\C#\A_Star\A_Star\A_Star\grid.txt");
        grid.printGrid();
    }
}