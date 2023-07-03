import pl.stanislawski.iwo.BST;

public class Main {


    public static void main(String[] args) {
        BST temp = new BST(10);
        temp.insert(9);
        temp.insert(1);
        temp.insert(3);
        temp.insert(2);
        temp.insert(4);
        temp.insert(6);
        temp.delete(-4);
        System.out.printf(temp.toString());

//        LinkedList list = new LinkedList(5);
//        list.addValue(4);
//        list.addValue(4);
//        list.addValue(4);
//        list.addValue(4);
//        System.out.println(list.toString());
    }
}