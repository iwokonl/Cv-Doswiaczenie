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
        //temp = temp.reverse();
        LinkedList temp2 = new LinkedList(0);
        temp2.add(1);
        temp2.add(2);
        temp2.add(3);
        temp2.add(4);
        temp = LinkedList.merge(temp, temp2);
        temp.print();
    }
}