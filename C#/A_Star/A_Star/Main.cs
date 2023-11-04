using System.Diagnostics;
using System.Runtime.CompilerServices;
using Main.A_Star;

namespace Main;
class main
{
    static main()
    {
        
    }
    


    static void Main(string[] args)
    {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.Start();
        Grid grid = new Grid(@"D:\github\Cv-Doswiaczenie\C#\A_Star\A_Star\A_Star\grid.txt");
        Console.WriteLine(grid.A_star().ToString());
        stopwatch.Stop();
        Console.WriteLine($"Time elapsed: {stopwatch.Elapsed} ");
    }
}