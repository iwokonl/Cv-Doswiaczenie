import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    Grid(String fileName){
        this.grid = new ArrayList<>();

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.grid.add(new ArrayList<>());
                for (char c : line.toCharArray()) {
                    if(c != ' '){
                        this.grid.get(this.grid.size() - 1).add(new Spot(Character.getNumericValue(c), this.grid.size() - 1, this.grid.get(this.grid.size() - 1).size()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Spot> row : grid) {
            for (Spot spot : row) {
                sb.append(spot.getValue());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private final ArrayList<ArrayList<Spot>> grid;
}
