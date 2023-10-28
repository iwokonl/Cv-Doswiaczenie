import java.util.ArrayList;
import java.util.List;

public class Spot {

    Spot(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.previous = null;
        this.neighbors = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Spot getPrevious() {
        return previous;
    }

    public void setPrevious(Spot previous) {
        this.previous = previous;
    }

    public ArrayList<Spot> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Spot> neighbors) {
        this.neighbors = neighbors;
    }

    private int value;
    private int x;
    private int y;
    private Spot previous;
    private ArrayList<Spot> neighbors;
}
