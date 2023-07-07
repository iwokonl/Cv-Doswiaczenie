package zadanie1;

public abstract class Student {
    private String name;

    public Student(String name) { this.name = name; }
    public final String getName() { return name; }

    public abstract int getId();
}

