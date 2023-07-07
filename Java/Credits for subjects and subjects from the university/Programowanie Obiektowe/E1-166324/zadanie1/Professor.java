package zadanie1;

import java.util.Date;

public class Professor extends Student implements Cloneable {
    public Professor(String name, int id) {
        super(name, id);
        this.id = id;
        this.nazwiko = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try{
            Professor cloned = (Professor) super.clone();
            return cloned;
        }catch (CloneNotSupportedException e){
            return new CloneNotSupportedException();
        }
    }
    private int id;
    private String nazwiko;

}
