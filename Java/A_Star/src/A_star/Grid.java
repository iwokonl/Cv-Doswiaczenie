package A_star;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    public Grid(String fileName) {
        this.grid = new ArrayList<>();

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.grid.add(new ArrayList<>());
                for (char c : line.toCharArray()) {
                    if (c != ' ') {
                        this.grid.get(this.grid.size() - 1).add(new Spot(Character.getNumericValue(c), this.grid.size() - 1, this.grid.get(this.grid.size() - 1).size()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Grid A_star(){
        ArrayList<Spot> openSet = new ArrayList<>();
        ArrayList<Spot> closedSet = new ArrayList<>();
        ArrayList<Spot> path = new ArrayList<>();
        Spot start = this.grid.get(0).get(0);
        Spot end = this.grid.get(this.grid.size() - 1).get(this.grid.get(this.grid.size() - 1).size() - 1);
        openSet.add(start);
        while (!openSet.isEmpty()) {
            Spot current = openSet.get(0);
            for (Spot spot : openSet) {
                if (spot.getF() < current.getF()) {
                    current = spot;
                }
            }
            if (current == end) {
                return this;
            }
            openSet.remove(current);
            closedSet.add(current);
            for()
            for (Spot neighbor : current.getNeighbors()) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }
                double tempG = current.getG() + neighbor.getValue();
                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tempG >= neighbor.getG()) {
                    continue;
                }
                neighbor.setPrevious(current);
                neighbor.setG(tempG);
                neighbor.setH(neighbor.getManhattanDistance(end));
                neighbor.setF(neighbor.getG() + neighbor.getH());
            }
        }
        return null;
    }
    private boolean include(Spot spot, ArrayList<Spot> list){
        for (Spot s : list){
            if (s == spot){
                return true;
            }
        }
        return false;
    }

    private double heuristic(Spot spot, Spot end){
        return Math.sqrt(Math.pow(spot.getX() - end.getX(), 2) + Math.pow(spot.getY() - end.getY(), 2));
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Spot> row : grid) {
            for (Spot spot : row) {
                sb.append(spot.getValue() + "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private final ArrayList<ArrayList<Spot>> grid;
}
