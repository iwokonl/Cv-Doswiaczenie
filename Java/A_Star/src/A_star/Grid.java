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
    public Grid A_star(){
        ArrayList<Spot> openSet = new ArrayList<>();
        ArrayList<Spot> closedSet = new ArrayList<>();
        ArrayList<Spot> path = new ArrayList<>();
        Spot start = this.grid.get(this.grid.size() - 1).get(0);
        Spot end = this.grid.get(0).get(this.grid.get(this.grid.size() - 1).size() - 1);
        openSet.add(start);
        while(!openSet.isEmpty()) {
            Spot current = openSet.get(0);
            for (Spot spot : openSet) {
                if (spot.getF() < current.getF()) {
                    current = spot;
                }
            }
            if (current.equals(end)) {
                Spot temp = current;
                while (temp.getPrevious() != null) {
                    path.add(temp);
                    temp = temp.getPrevious();
                }
                for(Spot spot : path) {
                    this.grid.get(spot.getX()).get(spot.getY()).setValue(3);
                }
                this.grid.get(start.getX()).get(start.getY()).setValue(3);
                this.grid.get(end.getX()).get(end.getY()).setValue(3);
                return this;
            }
            for(Spot spot : openSet) {
                if (spot.equals(current)) {
                    openSet.remove(spot);
                    break;
                }
            }
            if(current.getY() < this.grid.get(0).size()-1){
                current.addNeighbors(this.grid.get(current.getX()).get(current.getY()+1));
            }
            if (current.getY()  > 0) {
                current.addNeighbors(this.grid.get(current.getX()).get(current.getY()-1));
            }
            if (current.getX() > 0) {
                current.addNeighbors(this.grid.get(current.getX() - 1).get(current.getY()));
            }
            if (current.getX() < this.grid.size() - 1) {
                current.addNeighbors(this.grid.get(current.getX() + 1).get(current.getY()));
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
                sb.append(spot.getValue()+ "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private final ArrayList<ArrayList<Spot>> grid;
}
