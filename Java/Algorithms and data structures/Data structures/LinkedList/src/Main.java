import LinkedList.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList temp = new LinkedList(0);
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp = temp.reverse();

        //temp = temp.delete(4);
        System.out.println(String.valueOf(temp.conteinValue(999)));
        temp.print();
    }
}