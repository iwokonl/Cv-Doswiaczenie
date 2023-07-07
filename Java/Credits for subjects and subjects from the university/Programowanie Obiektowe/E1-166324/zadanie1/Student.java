package zadanie1;

import java.util.*;

public class Student<T> extends Person<Student> implements Cloneable, Named, Comparable<Student>{
    private final int id;
    private Date dateOfStart = null;

    @Override
    public Object clone() throws CloneNotSupportedException {
        try{
            Student cloned = (Student) super.clone();
            return cloned;
        }catch (CloneNotSupportedException e){
            return new CloneNotSupportedException();
        }
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
        this.dateOfStart = new java.util.Date();
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID = " + id
                + ", dateOfStart = " + dateOfStart
                + "]";
    }

    @Override
    public int compareTo(Student o) {
        if(super.compareTo(o) > 0){
            return 1;
        } else if (super.compareTo(o) == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
