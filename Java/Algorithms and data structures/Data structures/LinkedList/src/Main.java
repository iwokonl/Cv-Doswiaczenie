import LinkedList.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList temp = new LinkedList(0);
        temp.addLast(1);
        temp.addLast(2);
        temp.addLast(3);
        temp.addLast(4);
        temp = temp.addFirst(-1);
        //temp = temp.reverse();
        temp.print();
    }
}