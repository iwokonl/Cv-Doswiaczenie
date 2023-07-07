package zadanie1;

public abstract class Person<T> implements Cloneable, Named, Comparable<T>{
    private String name;

    @Override
    public int compareTo(T o) {
         Person temp = (Person) o;
         if(this.name.compareTo(temp.name) > 0){
             return 1;
         } else if (this.name.compareTo(temp.name) == 0) {
             return 0;
         }
         else {
             return -1;
         }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try{
            Person cloned = (Person) super.clone();
            cloned.name = name;
            return cloned;
        }catch (CloneNotSupportedException e){
            return new CloneNotSupportedException();
        }
    }

    public Person(String name) { this.name = name; }
    public final String getName() { return name; }

    public abstract int getId();
}

