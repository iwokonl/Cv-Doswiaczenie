import A_star.Grid;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid("src/A_star/generator/grid.txt");
        grid = grid.A_star();
        System.out.println(grid);
        System.out.println("Done!");
        }
    }