package zadanie1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Doktorant extends Student implements Named, Cloneable, Comparable<Doktorant> {
    private final int id;
    private Date dateOfStart = null;
    private ArrayList<Integer> points = null;

    public Doktorant(String name, int id, ArrayList<Integer> points) {
        super(name);
        this.id = id;
        this.dateOfStart = new Date();
        this.points = points;
    }
    @Override
    public Doktorant clone() throws CloneNotSupportedException{
        Doktorant clone = (Doktorant) super.clone();
        clone.dateOfStart = (Date) this.dateOfStart.clone();
        return clone;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Integer> getPoints() {
        return points;
    }

    public String toString() {
        return "ID = " + id
                + ", dateOfStart = " + dateOfStart
                + ", points = " + points;
    }
    public static Integer suma(ArrayList<Integer> lista){
        Integer temp = 0;
        for(int i = 0;i<lista.size();i++){
            temp += lista.get(i);
        }
        return temp;
    }
    @Override
    public int compareTo(Doktorant o) {
        if(this.getName().length() - o.getName().length() > 0){
            return 1;
        } else if (this.getName().length() == o.getName().length()) {
            if(suma(this.points) - suma(o.points) > 0){
                return 1;
            } else if (Objects.equals(suma(this.points), suma(o.points))) {
                return 0;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}
