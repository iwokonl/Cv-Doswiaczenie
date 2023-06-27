import pl.stanislawski.iwo.BinaryTree;
import pl.stanislawski.iwo.LinkedList;

public class Main {
    public static void main(String[] args) {
//        BinaryTree temp = new BinaryTree(10);
//        temp.insert(9);
//        temp.insert(1);
//        temp.insert(3);
//        temp.insert(2);
//        temp.insert(4);
//        temp.insert(6);
//        System.out.printf(temp.toString());
//        temp.preOrder();
//        //temp.delete(-4);
//       // System.out.printf(temp.toString());

        LinkedList list = new LinkedList(5);
        list.addValue(4);
        list.addValue(4);
        list.addValue(4);
        list.addValue(4);
        System.out.println(list.toString());
    }
}