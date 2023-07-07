package zadanie1;

import java.util.ArrayList;

public class StudentDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Student("Fred", 1729);
        System.out.println(p.getName());
        Student s = (Student) p;
        System.out.println(s.getName());

        Named n = s;

//        System.out.println(n.getName());
//        Professor d = (Professor) s.clone();
//        System.out.println(d.getName());
//        System.out.println(d);

        ArrayList<Professor> studenci = new ArrayList<>();
        studenci.add(new Professor("Zenon", 1729));
        studenci.add(new Professor("Andrzej", 1729));
        studenci.add(new Professor("Kamil", 1729));

        studenci.sort(null);

        System.out.println();
        for (Professor e : studenci) {
            System.out.println("nazwisko = " + e.getName() + ", id = " + e.getId());
        }
        System.out.println();



    }
}
