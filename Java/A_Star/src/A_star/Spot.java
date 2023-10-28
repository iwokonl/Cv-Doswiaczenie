package A_star;

import java.util.ArrayList;

public class Spot {

    protected Spot(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.h = 0;
        this.g = 0;
        this.f = 0;
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

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    private int value;
    private int x;
    private int y;
    private Spot previous;
    private double g;
    private double h;
    private double f;
    private ArrayList<Spot> neighbors;
}
